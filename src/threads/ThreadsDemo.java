package threads;

import java.util.Scanner;
import java.util.stream.IntStream;

class PrintNumbers implements Runnable {
    private volatile boolean running = true;

    @Override
    public void run() {
	// synchronized(PrintNumbers.class) {
	IntStream.range(0, 50).forEach(n -> {
	    if (getCondition(n) && running) {
		System.out.println(n);
		try {
		    Thread.sleep((long) (Math.random() * 100));
		} catch (InterruptedException e) {
		    e.printStackTrace();
		}
	    }
	});
	// }
    }

    public boolean getCondition(int i) {
	return true;
    }

    public void shutdown() {
	running = false;
    }

}

class PrintEvenNumbers extends PrintNumbers {
    public boolean getCondition(int i) {
	return i % 2 == 0;
    }

}

class PrintOddNumbers extends PrintNumbers {
    public boolean getCondition(int i) {
	return i % 2 != 0;
    }
}

public class ThreadsDemo {
    public static void main(String... args) {
	PrintNumbers pEN = new PrintEvenNumbers();
	PrintNumbers pON = new PrintOddNumbers();
	Thread t = new Thread(pEN);
	Thread t2 = new Thread(pON);
	t.start();
	t2.start();
	System.out.println("Press Enter to stop and show count");

	Scanner sc = new Scanner(System.in);
	sc.nextLine();
	pEN.shutdown();
	pON.shutdown();
	sc.close();

	try {
	    t.join();
	    t2.join();
	} catch (InterruptedException e) {
	    e.printStackTrace();
	}
    }

}
