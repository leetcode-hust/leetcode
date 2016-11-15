package thread;

import org.junit.Test;


public class UnsafeSequence {
	
	private int value = 0;
	
	public int getNext() {
		return value++;
	}
	
	@Test
	void testThread(){
		
	}
}



