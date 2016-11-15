package thread;

import org.junit.Test;


public class SafeSequence {
	
	private int value = 0;
	
	public synchronized int getNext() {
		return value++;
	}
	
	@Test
	void testThread(){
		
	}
}



