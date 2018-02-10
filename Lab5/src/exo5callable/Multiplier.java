package exo5callable;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Multiplier {
	
	public static void main(String[] args) throws ExecutionException, InterruptedException{
		ExecutorService executorService = Executors.newFixedThreadPool(4);
		Future<Integer>[] futures = new Future[20];
		for(int n=0; n<20; n++) {
			int x=n;
			futures[n]=executorService.submit(
					new Callable() {
						@Override
						public Integer call() throws Exception {
							return x*10;
						}
			});
		}
		for (int i=0; i<20; i++) {
			System.out.println(futures[i].get());
		}
	}

}
