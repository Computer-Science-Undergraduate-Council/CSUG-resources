import java.util.*;

public class AStackTest {

  public static void main(String[] args) {

	Stack<Integer> S1;
	S1 = new AStack<Integer>();
	
	System.out.println(S1);
	S1.push(33);
	System.out.println(S1);
	S1.push(22);
	System.out.println(S1);
	S1.pop();
	System.out.println(S1);
	S1.push(44);
	System.out.println(S1);
	S1.topValue();
	System.out.println(S1);

	/*
	long startTime = System.currentTimeMillis();
		
	
	long stopTime = System.currentTimeMillis();
      	long elapsedTime = stopTime - startTime;
	System.out.println("Time: "+ elapsedTime);
	*/
  }
}     
