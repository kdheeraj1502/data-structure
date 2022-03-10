package threads;

import java.util.*;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CountDownLatchExample implements Runnable {

	CountDownLatch countDownLatch;
	static List<String> outputScraper = new ArrayList<>();

	CountDownLatchExample(CountDownLatch countDownLatch) {
		this.countDownLatch = countDownLatch;
	}

	@Override
	public void run() {
		long prevValue = countDownLatch.getCount();
		countDownLatch.countDown();
		if (countDownLatch.getCount() != prevValue) {
			outputScraper.add("Count Updated :: " + prevValue);
		}
	}

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		CountDownLatch countDownLatch = new CountDownLatch(7);
		CountDownLatchExample cde = new CountDownLatchExample(countDownLatch);
		ExecutorService es = Executors.newFixedThreadPool(20);
		Future<?> f = es.submit(cde);
		for (int i = 0; i < 2; i++) {
			es.execute(cde);
		}
		es.shutdown();
		f.get();
		System.out.println(outputScraper);
	}

}
