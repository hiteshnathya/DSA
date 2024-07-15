package Day_12.Synchronisation;

// This class represents a table
class Table {
    // This method creates a table for a given number
    public void createTable(int n) {
        // Print the current thread name (this part is not synchronized)

        System.out.println("Thread " + Thread.currentThread().getName() + " is starting to create table for " + n);

        // Synchronized block to ensure only one thread can execute this code at a time
        synchronized (this) {
            System.out.println("Thread " + Thread.currentThread().getName() + " has acquired the lock and is creating table for " + n);
            for (int i = 1; i <= 5; i++) {
                System.out.println(n + " * " + i + " = " + n * i);
                try {
                    // Pause the thread for 2 seconds
                    Thread.sleep(2000);
                } catch (Exception e) {
                    System.out.println("Thread Interrupted");
                }
            }
            System.out.println("Thread " + Thread.currentThread().getName() + " has finished creating table for " + n);
        }
        System.out.println("Thread " + Thread.currentThread().getName() + " has released the lock and finished creating table for " + n);
    }
}

// This class represents a thread that creates a table for 10
class Thread11 extends Thread {
    Table obj;

    public Thread11(Table o) {
        this.obj = o;
    }

    public void run() {
        System.out.println("Thread " + Thread.currentThread().getName() + " is running...");
        obj.createTable(10);
        System.out.println("Thread " + Thread.currentThread().getName() + " has finished running.");
    }
}

// This class represents a thread that creates a table for 20
class Thread22 extends Thread {
    Table obj;

    public Thread22(Table o) {
        this.obj = o;
    }

    public void run() {
        System.out.println("Thread " + Thread.currentThread().getName() + " is running...");
        obj.createTable(20);
        System.out.println("Thread " + Thread.currentThread().getName() + " has finished running.");
    }
}

public class SynchronizedBlock {
    public static void main(String[] args) {
        System.out.println("Main thread is starting...");
        Table t = new Table();
        Thread11 t1 = new Thread11(t);
        Thread22 t2 = new Thread22(t);
        System.out.println("Starting threads...");
        t1.start();
        t2.start();
        System.out.println("Threads started. Main thread is waiting for them to finish.");
    }
}