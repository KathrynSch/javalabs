package exo2;
import java.util.concurrent.locks.ReentrantLock;

public class PhilosopherDinner {

	private final ReentrantLock[] forks;
	
	public PhilosopherDinner(int forkCount) {
		// create 5 forks
		ReentrantLock[] forks = new ReentrantLock[forkCount];
		
		for (int i= 0; i< forkCount; i++) {
			forks[i] = new ReentrantLock();
		}
		this.forks = forks;
	}
	
	public void eat(int index) {
		//get right and left fork
		ReentrantLock fork1 = forks[index];
		ReentrantLock fork2 = forks[(index + 1)% forks.length];
		// try to lock right fork
		if(fork1.tryLock()) {
			try {
				//try to lock left fork
				if(fork2.tryLock()) {
					try { //then philosopher eat
						System.out.println("philosopher " + index + " eat");
		// unlock forks
					} finally {
						fork2.unlock();
					}
				}
			}finally {
				fork1.unlock();
			}
		}
	}
	
	public static void main(String[] args) {
		
		//instantiate dinner with 5 philosophers
		PhilosopherDinner dinner = new PhilosopherDinner(5);
		
		//start eating 
		for(int i=0; i<5; i++) {
			
			final int philosopher = i;
			
			new Thread(new Runnable() {
				
				@Override
				public void run() {
					for(;;) {
						dinner.eat(philosopher);
					}
				}
			}).start();
		}
	}
}
