package threads;

import java.util.Scanner;

public class WaitNotifyDemo extends ProdConsDemo {

    public static void main(String[] args) {
        WaitNotifyDemo demo = new WaitNotifyDemo();
        demo.main();
    }

    public void produce() throws InterruptedException {
        System.out.println("Produce thread started");
        synchronized (this) {// intrinsic lock
            System.out.println("Producer thread running....");
            wait();
            // wait(100);
            System.out.println("Resumed producer");
        }
        System.out.println("Produce thread completed");
    }

    public void consume() throws InterruptedException {
        System.out.println("Consume thread started");
        Scanner sc = new Scanner(System.in);
        Thread.sleep(2000);
        synchronized (this) {
            System.out.println("Waiting for return key");
            sc.nextLine();
            System.out.println("Return key pressed");
            notify();
            System.out
                    .println("sleep here prevents resuming of producer thread");
            Thread.sleep(2000);
        }
        sc.close();
        System.out.println("sleep here prevents completion of consumer thread");
        Thread.sleep(2000);
        System.out.println("Consume thread completed");
    }

}
