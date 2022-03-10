package thread;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class BarrierService implements Runnable {
	CyclicBarrier barrier;
	
	BarrierService(CyclicBarrier barrier){
		this.barrier = barrier;
	}

	@Override
	public void run() {
		while(true) {
			try {
				Thread.sleep(2000);
				barrier.await();
				System.out.println("Hi " + Thread.currentThread().getName());
			} catch (InterruptedException | BrokenBarrierException e) {
				e.printStackTrace();
			}
		}
	}
}
