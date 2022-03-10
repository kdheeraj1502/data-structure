package thread;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CountDownLatchApp {


	public static void main(String[] args) throws InterruptedException {
		ExecutorService execute = Executors.newFixedThreadPool(4);
		CountDownLatch latch = new CountDownLatch(3);
		execute.submit(new DependentService(latch));
		execute.submit(new DependentService(latch));
		execute.submit(new DependentService(latch));
		latch.await();
		System.out.println("All dependent initialized");
	}
}
