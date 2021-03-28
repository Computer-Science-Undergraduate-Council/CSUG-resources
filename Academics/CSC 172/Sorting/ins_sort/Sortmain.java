/** Source code example for "A Practical Introduction to Data
    Structures and Algorithm Analysis, 3rd Edition (Java)" 
    by Clifford A. Shaffer
    Copyright 2008-2011 by Clifford A. Shaffer
*/

// Sorting main function for testing correctness of sort algorithm.
// To use: <sortname> [+/-] <size_of_array> <threshold>
//  + means increasing values, - means decreasing value and no
//    parameter means random values;
// where <size_of_array> controls the number of objects to be sorted;
// and <threshold> controls the threshold parameter for certain sorts, e.g.,
//   cutoff point for quicksort sublists.

import java.io.*;

public class Sortmain {

static int THRESHOLD = 0;

static int ARRAYSIZE = 0;
static <E extends Comparable<? super E>>
void Sort(E[] A) {
  for (int i=1; i<A.length; i++) // Insert i'th record
    for (int j=i; (j>0) && (A[j].compareTo(A[j-1])<0); j--)
      DSutil.swap(A, j, j-1);
}

public static void main(String args[]) throws IOException {
  assert args.length >= 1 : "Usage: Sortmain [+/-] <size> <threshold>";

System.out.println("Args: " + args.length);
  int i;
  int input = 0;
  int currarg = 0;
  if (args[currarg].charAt(0) == '+') { input = 1; currarg++; }
  else if (args[currarg].charAt(0) == '-') { input = -1; currarg++; }

  ARRAYSIZE = Integer.parseInt(args[currarg++]);
  if (args.length > currarg)
	THRESHOLD = Integer.parseInt(args[currarg]);


  Integer[] A = new Integer[ARRAYSIZE];

  System.out.println("Input: " + input +
          ", size: " + ARRAYSIZE + ", threshold: " + THRESHOLD);

  if (input == -1)
    for (i=0; i<ARRAYSIZE; i++)
      A[i] = new Integer(ARRAYSIZE - i);  // Reverse sorted
  else if (input == 0)
    for (i=0; i<ARRAYSIZE; i++)
      A[i] = new Integer(DSutil.random(32003));  // Random
  else
    for (i=0; i<ARRAYSIZE; i++)
      A[i] = new Integer(i);              // Sorted

  long time1 = System.currentTimeMillis();
    Sort(A);
  long time2 = System.currentTimeMillis();
  System.out.println("Time is " + (time2-time1));

  System.out.println("Done sorting");

  for (i=1; i<ARRAYSIZE; i++)
    if (A[i-1].compareTo(A[i]) > 0) {
      System.out.println("OOPS -- bad sort algorithm!");
        for (int j=0; j<ARRAYSIZE; j++)
          System.out.print(A[j] + " ");
      System.out.println();
      break;
    }
  System.out.println("Sorting checked out OK.");

//  System.in.read();
}

}
