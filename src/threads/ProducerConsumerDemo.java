package threads;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ProducerConsumerDemo extends ProdConsDemo {

    private static BlockingQueue<Integer> queue = new ArrayBlockingQueue<Integer>(
            10);

    public static void main(String... args) {
        ProducerConsumerDemo demo = new ProducerConsumerDemo();
        demo.main();
    }

    public void consume() throws InterruptedException {
        while (true) {
            Integer value = queue.take();
            System.out.println("Taken value: " + value + " queue size: "
                    + queue.size());
            Thread.sleep((long) (Math.random() * 500));
        }
    }

    public void produce() throws InterruptedException {
        while (true) {
            Random r = new Random();
            queue.put(r.nextInt(100));
            Thread.sleep((long) (Math.random() * 300));
        }
    }

}
