package threads;

public abstract class ProdConsDemo {

    public abstract void produce() throws InterruptedException;

    public abstract void consume() throws InterruptedException;

    public void main() {
        Thread producerThread = new Thread(new Runnable() {
            public void run() {
                try {
                    produce();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        Thread consumerThread = new Thread(new Runnable() {
            public void run() {
                try {
                    consume();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        producerThread.start();
        consumerThread.start();

        try {
            producerThread.join();
            consumerThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

}
