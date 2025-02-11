package companies.threads;

import java.util.concurrent.atomic.AtomicInteger;

public class PrintSeriesByThread implements Runnable {
    AtomicInteger atomicInteger = new AtomicInteger(0);

    public void run() {
        try {
            while (atomicInteger.get() <= 30) {
                synchronized (this) {
                    if (atomicInteger.get() % 2 == 0 && Thread.currentThread().getName().equals("1")) {
                        System.out.println("Even Thread : " + atomicInteger.getAndIncrement());
                    }
                    if (atomicInteger.get() % 2 != 0 && Thread.currentThread().getName().equals("2")) {
                        System.out.println("Odd Thread : " + atomicInteger.getAndIncrement());
                    }
                    notifyAll();
                    wait();
                }
            }
            Thread.currentThread().interrupt();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) throws Exception {
        PrintSeriesByThread task = new PrintSeriesByThread();
        Thread t1 = new Thread(task, "1");
        Thread t2 = new Thread(task, "2");
        t1.start();
        t2.start();

        t1.join();
        t2.join();
    }
}