package threads;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class InterruptingThreadsDemo {

    public static void main(String... args) throws InterruptedException {

        System.out.println("Starting..");

        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                Random r = new Random();
                for (int i = 0; i < 1E3; i++) {
                    try {
                        Thread.sleep(1);
                    } catch (InterruptedException e) {
                        System.out.println("Thread has been interrupted");
                        break;
                    }
                    Math.sin(r.nextDouble());
                }
            }

        });
        t.start();

        t.interrupt();
        // t.stop();

        t.join();

        System.out.println("Finished.");

        System.out.println("Starting ExecutorService thread..");

        ExecutorService executor = Executors.newCachedThreadPool();
        Future<?> f = executor.submit(new Callable<Void>() {
            @Override
            public Void call() throws Exception {
                Random r = new Random();
                for (int i = 0; i < 1E8; i++) {
                    if (Thread.currentThread().isInterrupted()) {
                        System.out
                                .println("executor service thread has been interrupted");
                        break;
                    }
                    Math.sin(r.nextDouble());
                }
                return null;
            }
        });

        executor.shutdown();

        Thread.sleep(500);

        // f.cancel(true);
        executor.shutdownNow();

        executor.awaitTermination(1, TimeUnit.DAYS);

        System.out.println("Finished ExecutorService thread..");
    }

}
