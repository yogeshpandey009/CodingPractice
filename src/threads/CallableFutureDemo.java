package threads;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CallableFutureDemo {

    public static void main(String... args) {

	ExecutorService executor = Executors.newCachedThreadPool();

	Future<Integer> future = executor.submit(new Callable<Integer>() {

	    @Override
	    public Integer call() throws Exception {
		System.out.println("Starting..");

		Random r = new Random();
		int duration = r.nextInt(1000);
		if (duration > 500) {
		    throw new IllegalStateException("Thread taking too long..");
		}

		try {
		    Thread.sleep(duration);
		} catch (InterruptedException e) {
		    // TODO Auto-generated catch block
		    e.printStackTrace();
		}

		System.out.println("Finished.");
		return duration;

	    }
	});
	executor.shutdown();

	try {
	    System.out.println("Result is: " + future.get());
	} catch (InterruptedException | ExecutionException e) {
	    // TODO Auto-generated catch block
	    IllegalStateException ise = (IllegalStateException) e.getCause();
	    System.out.println(ise.getMessage());
	    System.out.println("--------");
	    System.out.println(e.getMessage());
	    System.out.println("--------");
	    e.printStackTrace();
	}
    }

}
