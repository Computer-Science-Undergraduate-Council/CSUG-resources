/** Source code example for "A Practical Introduction to Data
    Structures and Algorithm Analysis, 3rd Edition (Java)" 
    by Clifford A. Shaffer
    Copyright 2008-2011 by Clifford A. Shaffer
*/

import java.io.*;

public class VarTest
    extends junit.framework.TestCase
{
/** Preorder traversal */
public static void traverse(VarBinNode rt) {
  if (rt == null) return;          // Nothing to visit
  if (rt.isLeaf())                 // Process leaf node
    Visit.VisitLeafNode(((VarLeafNode)rt).value());
  else {                           // Process internal node
    Visit.VisitInternalNode(((VarIntlNode)rt).value());
    traverse(((VarIntlNode)rt).leftchild());
    traverse(((VarIntlNode)rt).rightchild());
  }
}

  /**
   * This method is automatically called once before each test case
   * method, so that all the variables are cleanly initialized for
   * each test.
   */
  public void setUp()
  {
    Visit.VisitInit();
  }

  public void testVar() {
    String string1 = "Hello1";
    String string2 = "Another string";

    VarLeafNode temp1 = new VarLeafNode(string1);
    VarLeafNode temp2 = new VarLeafNode(string2);
    VarIntlNode root = new VarIntlNode(new Character('+'), temp1, temp2);
    traverse(root);
    assertEquals(Visit.VisitOut(), "+ Hello1 Another string ");
  }
}
