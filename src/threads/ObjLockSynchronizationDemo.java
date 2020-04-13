package threads;

import java.util.LinkedList;

public class ObjLockSynchronizationDemo extends ProdConsDemo {

    private LinkedList<Integer> llist = new LinkedList<Integer>();
    private final int LIMIT = 10;
    private Object lock = new Object();

    public void produce() throws InterruptedException {
	int val = 0;

	while (true) {
	    synchronized (lock) {
		while (llist.size() == LIMIT) {
		    // Interrupts and spurious wakeups are possible, and this
		    // method should always be used in a loop
		    lock.wait();
		}
		llist.add(val++);
		System.out.println("List size: " + llist.size());
		lock.notify();
	    }
	}

    }

    public void consume() throws InterruptedException {

	while (true) {
	    synchronized (lock) {
		while (llist.size() == 0) {
		    // Interrupts and spurious wakeups are possible, and this
		    // method should always be used in a loop
		    lock.wait();
		}
		int val = llist.removeFirst();
		System.out.println("Removed val: " + val);
		lock.notify();
	    }
	    Thread.sleep((long) (Math.random() * 1000));
	}
    }

    public static void main(String... args) {
	ObjLockSynchronizationDemo demo = new ObjLockSynchronizationDemo();
	demo.main();
    }

}
