package threads;

public class SyncKeywordDemo {

    private static int count = 0;

    private synchronized static void increament() {
	count++;
    }

    public static void main(String... args) throws InterruptedException {
	Thread t1 = new Thread(new Runnable() {
	    @Override
	    public void run() {
		for (int i = 0; i < 1000; i++) {
		    try {
			Thread.sleep(1);
		    } catch (InterruptedException e) {
			e.printStackTrace();
		    }
		    increament();
		}
	    }
	});
	Thread t2 = new Thread(new Runnable() {
	    @Override
	    public void run() {
		for (int i = 0; i < 1000; i++) {
		    try {
			Thread.sleep(1);
		    } catch (InterruptedException e) {
			e.printStackTrace();
		    }
		    increament();
		}
	    }
	});
	t1.start();
	t2.start();
	long start = System.currentTimeMillis();
	t1.join();
	t2.join();
	long end = System.currentTimeMillis();
	System.out.println("count: " + count + " time taken: " + (end - start));

    }

}
