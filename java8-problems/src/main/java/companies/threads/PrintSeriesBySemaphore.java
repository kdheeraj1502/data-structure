package companies.threads;

import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;

public class PrintSeriesBySemaphore implements Runnable {
    int i = 0;
    Semaphore semaphore;

    public PrintSeriesBySemaphore(Semaphore semaphore) {
        this.semaphore = semaphore;
    }

    public void run() {
        try {
            while (i <= 30) {
                semaphore.acquire();
                if (i % 2 == 0 && Thread.currentThread().getName().equals("1")) {
                    System.out.println("Even Thread : " + i++);
                }
                if (i % 2 != 0 && Thread.currentThread().getName().equals("2")) {
                    System.out.println("Odd Thread : " + i++);
                }
                semaphore.release();
            }
            Thread.currentThread().interrupt();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) throws Exception {
        PrintSeriesBySemaphore task = new PrintSeriesBySemaphore(new Semaphore(1));
        Thread t1 = new Thread(task, "1");
        Thread t2 = new Thread(task, "2");
        t1.start();
        t2.start();

    }
}
