/** Source code example for "A Practical Introduction to Data
    Structures and Algorithm Analysis, 3rd Edition (Java)" 
    by Clifford A. Shaffer
    Copyright 2008-2011 by Clifford A. Shaffer
*/

/** A Huffman coding tree */
class HuffTree<E> implements Comparable<HuffTree<E>>{
  private HuffBaseNode<E> root;  // Root of the tree

  /** Constructors */
  public HuffTree(E el, int wt)
    { root = new HuffLeafNode<E>(el, wt); }
  public HuffTree(HuffBaseNode<E> l,
                  HuffBaseNode<E> r, int wt)
    { root = new HuffInternalNode<E>(l, r, wt); }

  public HuffBaseNode<E> root() { return root; }
  public int weight() // Weight of tree is weight of root
    { return root.weight(); }
  public int compareTo(HuffTree<E> that) {
    if (root.weight() < that.weight()) return -1;
    else if (root.weight() == that.weight()) return 0;
    else return 1;
  }
}
