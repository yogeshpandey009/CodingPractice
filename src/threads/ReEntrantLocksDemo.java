package threads;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReEntrantLocksDemo {

    private int count = 0;
    private Lock lock = new ReentrantLock();

    private void increment() {
	for (int i = 0; i < 10000; i++) {
	    count++;
	}
    }

    public void firstThread() throws InterruptedException {
	lock.lock();
	try {
	    increment();
	} finally {
	    lock.unlock();
	}
    }

    public void secondThread() throws InterruptedException {
	lock.lock();
	try {
	    increment();
	} finally {
	    lock.unlock();
	}
    }

    public void finished() {
	System.out.println("Count: " + count);
    }

    public static void main(String... args) {

	ReEntrantLocksDemo demo = new ReEntrantLocksDemo();

	Thread t1 = new Thread(new Runnable() {
	    @Override
	    public void run() {
		try {
		    demo.firstThread();
		} catch (InterruptedException e) {
		    e.printStackTrace();
		}
	    }

	});

	Thread t2 = new Thread(new Runnable() {
	    @Override
	    public void run() {
		try {
		    demo.secondThread();
		} catch (InterruptedException e) {
		    e.printStackTrace();
		}
	    }

	});

	t1.start();
	t2.start();

	try {
	    t1.join();
	    t2.join();
	} catch (InterruptedException e) {
	    e.printStackTrace();
	} finally {
	    demo.finished();
	}

    }

}
