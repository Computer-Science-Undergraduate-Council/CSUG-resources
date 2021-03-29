/** Source code example for "A Practical Introduction to Data
    Structures and Algorithm Analysis, 3rd Edition (Java)" 
    by Clifford A. Shaffer
    Copyright 2008-2011 by Clifford A. Shaffer
*/

/** A JUnit test class for the BST. */

import java.io.*;

public class BSTTest
    extends junit.framework.TestCase
{

  private Dictionary<Integer, Integer> D1;

  public void setUp()
  {
    D1 = new BST<Integer, Integer>();
  }

  public void testBST1() {
    assertEquals(D1.size(), 0);
    D1.insert(50, 50);
    assertEquals(D1.size(), 1);
    D1.remove(20);
    assertEquals(D1.size(), 1);
    D1.remove(50);
    assertEquals(D1.size(), 0);
    D1.clear();
    assertEquals(D1.size(), 0);
    D1.insert(40, 40);
    D1.insert(20, 20);
    D1.insert(30, 30);
    assertEquals(D1.size(), 3);
    D1.clear();
    assertEquals(D1.size(), 0);
  }

  public void testBST2() {
    D1.insert(70, 70);
    assertEquals(D1.toString(), "70 ");
    D1.insert(35, 35);
    D1.insert(20, 20);
    D1.insert(17, 17);
    D1.insert(15, 15);
    assertEquals(D1.toString(), "15 17 20 35 70 ");
    D1.insert(19, 19);
    D1.insert(100, 100);
    D1.insert(90, 90);
    D1.insert(95, 95);
    assertEquals(D1.toString(), "15 17 19 20 35 70 90 95 100 ");
    D1.insert(1, 1);
    assertEquals(D1.size(), 10);
    D1.insert(1, 1);
    assertEquals(D1.toString(), "1 1 15 17 19 20 35 70 90 95 100 ");
    assertEquals(D1.size(), 11);
    assertEquals(D1.find(99), null);
    assertEquals(D1.find(100), new Integer(100));
    assertEquals(D1.find(15), new Integer(15));
    assertEquals(D1.find(70), new Integer(70));
    assertEquals(D1.remove(15), new Integer(15));
    assertEquals(D1.size(), 10);
    assertEquals(D1.remove(33), null);
    assertEquals(D1.size(), 10);
    assertEquals(D1.remove(70), new Integer(70));
    assertEquals(D1.size(), 9);
    D1.clear();
    assertEquals(D1.size(), 0);
  }
}
