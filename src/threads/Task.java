package threads;

public class Task extends Thread {

    private int id;

    public Task(int id) {
        super();
        this.id = id;
    }

    public void run() {
        // long timetaken = 500;
        long timetaken = (long) (Math.random() * 800 + 200);
        ;
        System.out.println("Starting Thread: " + id);
        try {
            Thread.sleep(timetaken);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Completing Thread: " + id + " in: " + timetaken
                + "ms");
    }

}
