package exo5;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Multiplier {
	
	public static void main(String[] args) throws ExecutionException, InterruptedException{
		ExecutorService executorService = Executors.newFixedThreadPool(4);
		for(int n=0; n<20; n++) {
			int x=n;
			executorService.submit(new Runnable() {
				@Override
				public void run() {
					System.out.println(x*10);
				}
			});
		}
	}

}
