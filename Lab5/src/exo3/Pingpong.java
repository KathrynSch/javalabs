package exo3;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Pingpong {
	
	final Lock lock = new ReentrantLock();
	final Condition notPing = lock.newCondition();

//	private boolean sent = false;
	
	private void ping() {
		lock.lock();
		try {
//			sent = true;
			System.out.println("ping");		//ping 
			notPing.signal();				//send signal that ping happened
		}finally {
			lock.unlock();
		}
		
	}
	
	private void pong() throws InterruptedException{
//		while(sent == false) {
//			//Thread.sleep(100);
//			
//		}
		lock.lock();
		try {
			notPing.await();		// wait for ping to send signal
			System.out.println("pong");	//then pong
		}finally {
			lock.unlock();		
		}
		
	}
	
	public static void main(String[] args) throws InterruptedException {
		Pingpong pingPong = new Pingpong();
		new Thread(new Runnable() {
			
			@Override
			public void run () {
				try {
					Thread.sleep(2000);
				}catch (InterruptedException e) {
					new AssertionError(e);
				}
				pingPong.ping();
			}
		}).start();
		pingPong.pong();
	}
}
