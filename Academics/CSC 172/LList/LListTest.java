import java.util.*;

public class LListTest {

  public static void main(String[] args) {

	List<Integer> L1;
	L1 = new LList<Integer>();
	int i = 0;
	long startTime = System.currentTimeMillis();
	for(i = 1; i < 100000; i++) 
		L1.insert(i);
		
	
	long stopTime = System.currentTimeMillis();
      	long elapsedTime = stopTime - startTime;
	System.out.println("Time: "+ elapsedTime);

  }
}     
