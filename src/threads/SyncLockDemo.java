package threads;

import java.util.ArrayList;
import java.util.List;

public class SyncLockDemo {

    private List<Integer> list1 = new ArrayList<Integer>();
    private List<Integer> list2 = new ArrayList<Integer>();

    private Object lock1 = new Object();
    private Object lock2 = new Object();

    private void processOne() {
	try {
	    Thread.sleep(1);
	} catch (InterruptedException e) {
	    e.printStackTrace();
	}
	synchronized (lock1) {
	    list1.add((int) (Math.random() * 100));
	}
    }

    private void processTwo() {
	try {
	    Thread.sleep(1);
	} catch (InterruptedException e) {
	    e.printStackTrace();
	}
	synchronized (lock2) {
	    list2.add((int) (Math.random() * 100));
	}
    }

    public void process() {
	for (int i = 0; i < 1000; i++) {
	    processOne();
	    processTwo();
	}
    }

    public static void main(String... args) {
	SyncLockDemo lockDemo = new SyncLockDemo();
	Runnable runProcess = new Runnable() {
	    @Override
	    public void run() {
		lockDemo.process();
	    }
	};

	Thread t1 = new Thread(runProcess);
	Thread t2 = new Thread(runProcess);

	t1.start();
	t2.start();

	long start = System.currentTimeMillis();
	try {
	    t1.join();
	    t2.join();
	} catch (InterruptedException e) {
	    e.printStackTrace();
	}
	long end = System.currentTimeMillis();

	System.out.println("list1 size: " + lockDemo.list1.size());
	System.out.println("list2 size: " + lockDemo.list2.size());
	System.out.println("time taken: " + (end - start));
    }

}
