package thread.p3;

public class NoVisibility {
	
	private static boolean ready;
	private static int number;
	
	private static class ReaderThread extends Thread {
		
		@Override
		public void run() {
			//循环等待，直到ready变成 true
			while(!ready)
				Thread.yield();
			
			System.out.println(number);
			super.run();
		}
	}
	
	public static void main(String[] args) {
		new ReaderThread().start();
		number=42;
		ready=true;
	}
	
}
