package exo4;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicLong;

public class RandomNumGen {
	
	private AtomicLong x;
	
	public RandomNumGen(long seed) {
		if(seed == 0) {
			throw new IllegalArgumentException("seed == 0");
		}
		x = new AtomicLong(seed);
	}
	
	public long next() {	// Marsaglia's XorShift
		long prev;
		long next;
		
		do {
			prev = x.get();
			next =prev;
			next ^= next >>> 12;
		}while(!x.compareAndSet(prev, next));
		do {
			prev = x.get();
			next =prev;
			next ^= next << 25;
		}while(!x.compareAndSet(prev, next));
		do {
			prev = x.get();
			next =prev;
			next ^= next >>> 27;
		}while(!x.compareAndSet(prev, next));
		
		return x.get()*2685821657736338717L;
	}
	
	public static void main(String[] args) {
		
		RandomNumGen rng = new RandomNumGen(1);
		for(int i=0; i<1000; i++) {
			System.out.println(rng.next());
		}
	}

}
