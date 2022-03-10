package thread;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CountDownLatchExample {

	public static void main(String[] args) throws InterruptedException {
		CountDownLatch latch = new CountDownLatch(4);
		
		ExecutorService executor = Executors.newFixedThreadPool(1);
		executor.submit(() ->{
			for(int i= 0; i < 10; i++) {
				System.out.println(i + " latch val :: " + latch.getCount());
				latch.countDown();
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
			}
		});
		latch.await();
		System.out.println(Thread.currentThread().getName());
	}
}
