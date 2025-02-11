package companies.threads;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicLong;

public class CountDownLatchExample implements Runnable {

	CountDownLatch countDownLatch;
	static List<String> outputScraper = new ArrayList<>();

	CountDownLatchExample(CountDownLatch countDownLatch) {
		this.countDownLatch = countDownLatch;
	}

	AtomicLong atm = new AtomicLong(3);
	@Override
	public void run() {
		long prevValue = countDownLatch.getCount();

		countDownLatch.countDown();
		System.out.println(prevValue + " prevValue");
		try {
			System.out.println(Thread.currentThread() + " is waiting - 1");

			countDownLatch.await();
			System.out.println(Thread.currentThread() + " is waiting - 2");
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}
        if (countDownLatch.getCount() != prevValue) {
			System.out.println("countDownLatch.getCount -- " + countDownLatch.getCount());
			System.out.println("prevValue -- and atm is " + prevValue + " -- " + atm.get());
			outputScraper.add("Count Updated :: " + prevValue);
		}
	}

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		CountDownLatch countDownLatch = new CountDownLatch(3);

		CountDownLatchExample cde = new CountDownLatchExample(countDownLatch);
/*		ExecutorService es = Executors.newFixedThreadPool(20);
		//Future<?> f = es.submit(cde);
		for (int i = 0; i < 4; i++) {
			Thread.sleep(2000);
			es.execute(cde);
		}*/
		ArrayBlockingQueue queue = new ArrayBlockingQueue(10);
		queue.add(123);
		queue.put(123);

		ConcurrentHashMap map = new ConcurrentHashMap();
		map.put(45, "Four");
		map.put(45, "Five");
	//	es.shutdown();
	//	f.get();
	//	es.awaitTermination(1, TimeUnit.MINUTES);
		System.out.println(outputScraper);
	}

}
