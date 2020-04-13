package code;

import java.util.Random;

public class WaitNotify {

    private String str = null;

    public static void main(String[] args) {
        WaitNotify wn = new WaitNotify();
        String[] calls = {"get", "get", "get", "put", "put"};
        for (final String s : calls) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        if (s.equals("get")) {
                            System.out.println(wn.get());
                        } else {
                            wn.put("x" + new Random().nextInt(10));
                        }
                    } catch (InterruptedException ie) {
                        ie.printStackTrace();
                    }
                }
            }).start();
        }
    }

    public synchronized void put(String s) throws InterruptedException {
        while (str != null) {
            wait();
        }
        Thread.sleep(1000);
        str = s;
        notifyAll();
    }

    public synchronized String get() throws InterruptedException {
        while (str == null) {
            wait();
        }
        Thread.sleep(1000);
        String o = str;
        str = null;
        // notifyAll();
        return o;
    }
}
