package threads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ThreadsPool {

    public static void main(String... args) {
	boolean success = false;
	ExecutorService taskRunner = Executors.newFixedThreadPool(2);
	for (int i = 1; i <= 5; i++) {
	    taskRunner.submit(new Task(i));
	}
	taskRunner.shutdown();
	System.out.println("All task submited");

	try {
	    success = taskRunner.awaitTermination(2000, TimeUnit.MILLISECONDS);
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
