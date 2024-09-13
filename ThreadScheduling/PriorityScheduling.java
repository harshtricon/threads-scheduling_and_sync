class PriorityTask extends Thread {
    public PriorityTask(String name, int priority) {
        super(name);
        setPriority(priority);
    }

    @Override
    public void run() {
        for (int i = 1; i <= 5; i++) {
            for(int j=0;j<5000;j++){
                for(int k=0;k<45454;k++){}
            }
            System.out.println(getName() + " with priority " + getPriority() + " is executing iteration " + i);

        }
    }
}

public class PriorityScheduling {
    public static void main(String[] args) {

        PriorityTask lowPriorityThread = new PriorityTask("Low Priority Thread", Thread.MIN_PRIORITY);  //1
        PriorityTask normalPriorityThread = new PriorityTask("Normal Priority Thread", Thread.NORM_PRIORITY);  //5
        PriorityTask highPriorityThread = new PriorityTask("High Priority Thread", Thread.MAX_PRIORITY);  //10
        lowPriorityThread.start();
        normalPriorityThread.start();
        highPriorityThread.start();



///when we are using big nested loops to increase the worrkload then the thread with 10 priority
// is executing first but still there are some irregularity .
// conclusion ---In Java, we can't fully control how the operating system schedules threads.





        System.out.println("All threads have finished execution.");
    }
}
