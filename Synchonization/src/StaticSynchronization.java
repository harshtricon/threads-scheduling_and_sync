class Counter {
    private static int count = 0;


    public static synchronized void increment() {
        count++;
        System.out.println(Thread.currentThread().getName() + " incremented count to: " + count);
    }

    public static int getCount() {
        return count;
    }
}

public class StaticSynchronization {
    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                Counter.increment();
            }
        }, "Thread 1");

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                Counter.increment();
            }
        }, "Thread 2");

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Final count: " + Counter.getCount());
    }
}
