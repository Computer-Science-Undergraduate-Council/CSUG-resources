/** Source code example for "A Practical Introduction to Data
    Structures and Algorithm Analysis, 3rd Edition (Java)" 
    by Clifford A. Shaffer
    Copyright 2008-2011 by Clifford A. Shaffer
*/

public class Code { // One code stored in a code table
  private char data;
  private String code;

  public Code(char d, String c)
  { data = d;  code = c; }

  public char data() { return data; }
  public String code() { return code; }
}
