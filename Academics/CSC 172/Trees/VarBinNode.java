/** Source code example for "A Practical Introduction to Data
    Structures and Algorithm Analysis, 3rd Edition (Java)" 
    by Clifford A. Shaffer
    Copyright 2008-2011 by Clifford A. Shaffer
*/

/** Base class for expression tree nodes */
public interface VarBinNode {
  public boolean isLeaf(); // All subclasses must implement
}
