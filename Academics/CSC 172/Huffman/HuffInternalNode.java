/** Source code example for "A Practical Introduction to Data
    Structures and Algorithm Analysis, 3rd Edition (Java)" 
    by Clifford A. Shaffer
    Copyright 2008-2011 by Clifford A. Shaffer
*/

/** Huffman tree node: Internal class */
class HuffInternalNode<E> implements HuffBaseNode<E> {
  private int weight;            // Weight (sum of children)
  private HuffBaseNode<E> left;  // Pointer to left child
  private HuffBaseNode<E> right; // Pointer to right child

  /** Constructor */
  public HuffInternalNode(HuffBaseNode<E> l,
                          HuffBaseNode<E> r, int wt)
    { left = l; right = r; weight = wt; }

  /** @return The left child */
  public HuffBaseNode<E> left() { return left; }

  /** @return The right child */
  public HuffBaseNode<E> right() { return right; }

  /** @return The weight */
  public int weight() { return weight; }

  /** Return false */
  public boolean isLeaf() { return false; }
}
