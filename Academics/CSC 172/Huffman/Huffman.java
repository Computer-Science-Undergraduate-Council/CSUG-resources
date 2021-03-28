/** Huffman coding tree Main program.
    First, read from the data file a set of strings and associated
    frequencies.  These are placed onto a list of (single node)
    Huffman trees.  Next, build a single Huffman coding tree for
    the set.  The strings and their codes are then output, with
    CodeTable storing the coding for each input string.  Next, read
    commands to "encode" or "decode" strings, providing the
    appropriate output.

    This distribution should come with three test files: huffex.dat,
    hufftest.dat, and huffbook.dat. You can use any of these to test the
    program by reading them in from standard input. For example (in
    Linux) type to the command prompt:

    java Huffman < huffbook.dat
*/

import java.io.*;
import java.util.*;

public class Huffman {

private static Vector<Code> codeTable = new Vector<Code>(); // The code lookup table
private static int total = 0;  // Total weight of codes
private static MinHeap<HuffTree<Character>> Hheap;
private static HuffTree<Character>[] TreeArray;

/** Read a list of strings and frequencies,
    creating initial list of Huffman coding tree nodes */
@SuppressWarnings("unchecked")  // Allow the generic array allocation 
static void readFreqs(BufferedReader d) throws IOException {
  String line;
  char letter;
  int freq;

  line = d.readLine();
  assert (line != null) : "Bad input file";
  int count = Integer.parseInt(line);
  TreeArray = (HuffTree<Character>[])new HuffTree[count];
  for (int i=0; i<count; i++) {
    // process the entry, creating a new HuffTree
    line = d.readLine();
    assert (line != null) : "Not enough characters";
    letter = line.charAt(0);
    freq = Integer.parseInt(line.substring(2));
    TreeArray[i] = new HuffTree<Character>(letter, freq);
  }
  Hheap = new MinHeap<HuffTree<Character>>(TreeArray, count, count);
}
/** Build a Huffman tree from list hufflist */
static HuffTree<Character> buildTree() {
  HuffTree tmp1, tmp2, tmp3 = null;

  while (Hheap.heapsize() > 1) { // While two items left
    tmp1 = Hheap.removemin();
    tmp2 = Hheap.removemin();
    tmp3 = new HuffTree<Character>(tmp1.root(), tmp2.root(),
  	     		     tmp1.weight() + tmp2.weight());
    Hheap.insert(tmp3);   // Return new tree to heap
  }
  return tmp3;            // Return the tree
}

// Find the index in CodeTable for the given codeword
static int getindex(char codeword)
{
  int i;

  for (i=0; i<codeTable.size(); i++)
    if (codeword == codeTable.elementAt(i).data())
      return i;
  return i; // Not found
}


// Print out the codes; insert these codes into CodeTable
static void outputTree(HuffBaseNode<Character> node, String prefix) {
  assert node != null : "Bad input tree";
  // This is a full binary tree so must not be null subtree
  if (node.isLeaf()) {
    System.out.println(((HuffLeafNode<Character>)node).element() + "\t" + prefix);
    char temp  = ((HuffLeafNode<Character>)node).element();
    codeTable.addElement(new Code(temp, prefix));
    total += prefix.length() * node.weight();
  }
  else {
    outputTree(((HuffInternalNode)node).left(), prefix + "0");
    outputTree(((HuffInternalNode)node).right(), prefix + "1");
  }
}


// Process Encode and Decode commands
static void doCommands(BufferedReader d, HuffTree<Character> tree)
      throws IOException {
  HuffBaseNode<Character> temp;
  String line;
  int i;

  while ((line = d.readLine()) != null) {
    if (line.substring(0, 6).equals("decode")) {
      for (i=0; line.charAt(i) != '"'; i++);
      System.out.print("Decode " + line.charAt(i++));
      temp = tree.root();
      for (; line.charAt(i) != '"'; i++) { // Traverse the tree
        if (line.charAt(i) == '0')
          temp = ((HuffInternalNode)temp).left();
        else if (line.charAt(i) == '1')
          temp = ((HuffInternalNode)temp).right();
        else
          assert false : "Bad input: " + line;
        if (temp.isLeaf()) {
          System.out.print(((HuffLeafNode)temp).element());
          temp = tree.root(); // reset at root
        }
      }
      System.out.println(line.charAt(i));
    }
    else if (line.substring(0, 6).equals("encode")) {
      for (i=0; line.charAt(i) != '"'; i++);
      System.out.print("Encode " + line.charAt(i++));
      for (; line.charAt(i) != '"'; i++) {
        // Assume codes are characters.  Should generalize this.
        int index = getindex(line.charAt(i));
        assert index < codeTable.size() :
		  "Tried to find code of bad character|" +
		  line.charAt(i) + "|";
        System.out.print(codeTable.elementAt(index).code());
      }
      System.out.println(line.charAt(i));
    }
    else
      assert false : "Bad command line: " + line;
  } // while
}

public static void main(String argv[])
       throws FileNotFoundException, IOException {
  BufferedReader f;

  if (argv.length == 0) // Read from standard input
      f = new BufferedReader(new InputStreamReader(System.in));
  else // Data file entered as parameter
      f = new BufferedReader(new InputStreamReader(new FileInputStream(argv[0])));
  System.out.println("Read frequencies");
  readFreqs(f);
  System.out.println("Build the tree");
  HuffTree<Character> codes = buildTree();
  System.out.println("Output the tree");
  outputTree(codes.root(), "");
  System.out.println("Average code length is " +
		(double)total/(double)codes.weight());
  doCommands(f, codes);
  System.in.read();
}

}
