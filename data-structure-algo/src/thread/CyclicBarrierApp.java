package thread;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CyclicBarrierApp {

	public static void main(String[] args) throws InterruptedException, BrokenBarrierException {
		CyclicBarrier barrier = new CyclicBarrier(3);
		ExecutorService execute = Executors.newFixedThreadPool(4);
		execute.submit(new BarrierService(barrier));
		execute.submit(new BarrierService(barrier));
		execute.submit(new BarrierService(barrier));
		//barrier.await();
		System.out.println("All Thread initialized");
	}
}
