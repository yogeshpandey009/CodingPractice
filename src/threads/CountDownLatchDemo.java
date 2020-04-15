package threads;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class TaskWithLatch extends Task {

    private CountDownLatch latch;

    public TaskWithLatch(int id, CountDownLatch latch) {
        super(id);
        this.latch = latch;
    }

    public void run() {
        super.run();
        latch.countDown();
    }

}

public class CountDownLatchDemo {

    public static void main(String[] args) {
        CountDownLatch latch = new CountDownLatch(5);
        boolean success = false;
        ExecutorService taskRunner = Executors.newFixedThreadPool(2);
        for (int i = 1; i <= 5; i++) {
            taskRunner.submit(new TaskWithLatch(i, latch));
        }
        try {
            // latch.await();
            success = latch.await(2000, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if (success) {
            System.out.println("All tasks completed on time");
        } else {
            System.out.println("Timeout!!!");
        }

    }

}
