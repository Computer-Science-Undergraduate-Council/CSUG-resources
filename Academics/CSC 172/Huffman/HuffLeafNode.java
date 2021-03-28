/** Source code example for "A Practical Introduction to Data
    Structures and Algorithm Analysis, 3rd Edition (Java)" 
    by Clifford A. Shaffer
    Copyright 2008-2011 by Clifford A. Shaffer
*/

/** Huffman tree node: Leaf class */
class HuffLeafNode<E> implements HuffBaseNode<E> {
  private E element;         // Element for this node
  private int weight;        // Weight for this node

  /** Constructor */
  public HuffLeafNode(E el, int wt)
    { element = el; weight = wt; }

  /** @return The element value */
  public E element() { return element; }

  /** @return The weight */
  public int weight() { return weight; }

  /** Return true */
  public boolean isLeaf() { return true; }
}
