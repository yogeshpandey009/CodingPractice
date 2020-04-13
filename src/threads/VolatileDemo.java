package threads;

class VolatileExample extends Thread {

    private volatile int volatileValue;

    public VolatileExample(String str) {
	super(str);
    }

    public void run() {
	int i;
	for (i = 0; i < 3; i++) {
	    try {
		System.out.println(getName() + " : " + i);
		if (getName().equals("First ")) {
		    volatileValue = 10;
		    System.out.println("Test Value : " + volatileValue);
		}
		if (getName().equals("Second ")) {
		    System.out.println("Test Value : " + volatileValue);
		}
		Thread.sleep(1000);
	    } catch (InterruptedException exception) {
		exception.printStackTrace();
	    }
	}
    }
}

public class VolatileDemo {

    public static void main(String args[]) {

	new VolatileExample("First ").start();
	new VolatileExample("Second ").start();

    }
}