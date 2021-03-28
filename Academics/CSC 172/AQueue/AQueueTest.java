import java.util.*;

public class AQueueTest {

  public static void main(String[] args) {

	Queue<Integer> Q1;
	Q1 = new AQueue<Integer>();
	
	System.out.println(Q1);
	Q1.enqueue(33);
	System.out.println(Q1);
	Q1.enqueue(22);
	System.out.println(Q1);
	Q1.frontValue();
	System.out.println(Q1);
	Q1.dequeue();
	System.out.println(Q1);
	Q1.enqueue(91);
	System.out.println(Q1);

	/*
	long startTime = System.currentTimeMillis();
		
	
	long stopTime = System.currentTimeMillis();
      	long elapsedTime = stopTime - startTime;
	System.out.println("Time: "+ elapsedTime);
	*/
  }
}     
