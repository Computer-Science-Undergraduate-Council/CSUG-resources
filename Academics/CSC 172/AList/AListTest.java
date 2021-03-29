import java.util.*;

public class AListTest {

  public static void main(String[] args) {
	AList<Integer> L1;
	L1 = new AList<Integer>(100010);
	int i = 0;


	//L1.moveToStart();
	for(i = 1; i < 100000; i++) 
		L1.insert(i);
	long startTime = System.currentTimeMillis();
	for(i = 1; i < 100000; i++) 
		L1.remove();
			
	long stopTime = System.currentTimeMillis();
      	long elapsedTime = stopTime - startTime;
	System.out.println("Time: "+ elapsedTime);

  }
}     
