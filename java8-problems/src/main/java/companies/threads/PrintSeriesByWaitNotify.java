package companies.threads;

import java.util.concurrent.Semaphore;

public class PrintSeriesByWaitNotify implements Runnable {
    volatile int i = 0;
    public synchronized void run() {

        try {
            while (i <= 30) {
                if(i % 2 == 0 && Thread.currentThread().getName().equalsIgnoreCase("1")) {
                    this.notifyAll();
                    this.wait();
                }
                if(i % 2 == 1 && Thread.currentThread().getName().equalsIgnoreCase("2")) {
                    this.notifyAll();
                    this.wait();
                }
                System.out.println("Number is " + i++ + " Printer is " + Thread.currentThread().getName());
                this.notifyAll();
            }
            Thread.currentThread().interrupt();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) throws Exception {
        PrintSeriesByWaitNotify task = new PrintSeriesByWaitNotify();
        Thread t1 = new Thread(task, "1");
        Thread t2 = new Thread(task, "2");
        t1.start();
        t2.start();

    }
}
