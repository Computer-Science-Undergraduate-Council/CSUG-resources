/** Source code example for "A Practical Introduction to Data
    Structures and Algorithm Analysis, 3rd Edition (Java)" 
    by Clifford A. Shaffer
    Copyright 2008-2011 by Clifford A. Shaffer
*/

/** Huffman tree node implementation: Base class */
public interface HuffBaseNode<E> {
  public boolean isLeaf();
  public int weight();
}
