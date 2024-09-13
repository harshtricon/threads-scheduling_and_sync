//Java doesn't explicitly provide a built-in FCFS scheduling mechanism, 
//but we can do it using thread management techniques like manually starting threads in a particular order 
///and making sure they complete before starting the next one.

class Task implements Runnable {
    private String taskName;

    public Task(String taskName) {
        this.taskName = taskName;
    }


    @Override
    public void run() {
        System.out.println(taskName + " started.");

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(taskName + " finished.");
    }
}

public class Fcfs {
    public static void main(String[] args) {

        Task task1 = new Task("Task 1");
        Task task2 = new Task("Task 2");
        Task task3 = new Task("Task 3");
        Thread thread1 = new Thread(task1);
        Thread thread2 = new Thread(task2);
        Thread thread3 = new Thread(task3);


        System.out.println("Starting threads in FCFS order:");

        thread1.start();
        try {
            thread1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        thread2.start();
        try {
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        thread3.start();
        try {
            thread3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("All tasks finished in FCFS order.");
    }
}
