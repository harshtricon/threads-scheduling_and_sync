class BankAccount {
    private int balance;

    public BankAccount(int initialBalance) {
        this.balance = initialBalance;
    }

    public void withdraw(int amount) {
        synchronized (this) {
            if (balance >= amount) {
                System.out.println(Thread.currentThread().getName() + " is about to withdraw");
                balance -= amount;
                System.out.println(Thread.currentThread().getName() + " has withdrawn " + amount);
            } else {
                System.out.println(Thread.currentThread().getName() + " tried to withdraw, but insufficient balance");
            }
        }
    }

    public void deposit(int amount) {
        synchronized (this) {
            System.out.println(Thread.currentThread().getName() + " is about to deposit");
            balance += amount;
            System.out.println(Thread.currentThread().getName() + " has deposited " + amount);
        }
    }

    public int getBalance() {
        return balance;
    }
}

public class SynchronizedBlock {
    public static void main(String[] args) {
        BankAccount account = new BankAccount(1000);


        Thread t1 = new Thread(() -> {
            account.withdraw(600);
        }, "Thread 1");


        Thread t2 = new Thread(() -> {
            account.withdraw(600);
        }, "Thread 2");
        Thread t3 = new Thread(() -> {
            account.deposit(500);
        }, "Thread 3");

        t1.start();
        t2.start();
        t3.start();

        try {
            t1.join();
            t2.join();
            t3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Final balance: " + account.getBalance());
    }
}
