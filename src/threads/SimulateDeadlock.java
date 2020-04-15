package threads;

public class SimulateDeadlock {

    public static void main(String[] args) throws InterruptedException {
        final boolean[] f1 = {false};
        final boolean[] f2 = {false};
        Thread t1 = new Thread() {
            public void run() {
                while (!f1[0]) {
                    f1[0] = true;
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    while (!f2[0]) {
                        f1[0] = false;
                    }
                }

            }
        };
        Thread t2 = new Thread() {
            public void run() {
                while (!f2[0]) {
                    f2[0] = true;
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    while (!f1[0]) {
                        f1[0] = true;
                    }
                }

            }
        };
        t1.start();
        t2.start();
    }
}
