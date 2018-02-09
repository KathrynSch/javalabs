package exo1;
import java.util.ArrayList;

public class CounterThread {
	
	public static void main(String[] args) throws InterruptedException {
		
		ArrayList<Integer> counters = new ArrayList<>();
		Object lock = new Object();

		Runnable runnable = new Runnable() {
			
			@Override
			public void run() {
				int i=0;
				while(i<1000) {
					synchronized(lock) {
						counters.add(i);
					}
					System.out.println(Thread.currentThread().getName() +"\t"+i);
					i++;
				}
				System.out.println(Thread.currentThread().getName() +"\t I am Done");
			}
		};
		
		
		Thread thread1 = new Thread(runnable);
		Thread thread2 = new Thread(runnable);
		Thread thread3 = new Thread(runnable);
		Thread thread4 = new Thread(runnable);
		
		// run threads
		thread1.start();
		thread2.start();
		thread3.start();
		thread4.start();
		
		// wait for threads to finish
		thread1.join();
		thread2.join();
		thread3.join();
		thread4.join();
		
		System.out.println("Program finishes");
		System.out.println(counters);
		System.out.println(counters.size());
	}
	
	
	
	

}
