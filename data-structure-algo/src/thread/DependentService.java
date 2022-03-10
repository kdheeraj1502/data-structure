package thread;

import java.util.concurrent.CountDownLatch;

public class DependentService implements Runnable {

	private CountDownLatch latch;

	DependentService(CountDownLatch latch) {
		this.latch = latch;
	}

	@Override
	public void run() {
		try {
			Thread.sleep(2000);
			System.out.println("Latch count down " + Thread.currentThread().getName());
			Thread.sleep(2000);
			latch.countDown();
			Thread.sleep(2000);
			System.out.println(Thread.currentThread().getName() + " Hi ");
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
