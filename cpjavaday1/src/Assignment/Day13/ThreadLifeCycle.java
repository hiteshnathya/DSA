package Assignment.Day13;
public class ThreadLifeCycle {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new MyRunnable());
        System.out.println("Thread state: " + thread.getState()); // NEW

        thread.start();
        System.out.println("Thread state: " + thread.getState()); // RUNNABLE

        Thread.sleep(100); // give the thread some time to run
        System.out.println("Thread state: " + thread.getState()); // RUNNABLE

        synchronized (thread) {
            thread.wait(1000); // WAITING
            System.out.println("Thread state: " + thread.getState()); // WAITING
        }

        thread.notify(); // notify the thread to wake up
        System.out.println("Thread state: " + thread.getState()); // RUNNABLE

        thread.join(); // wait for the thread to finish
        System.out.println("Thread state: " + thread.getState()); // TERMINATED
    }
}

class MyRunnable implements Runnable {
    @Override
    public void run() {
        try {
            Thread.sleep(500); // TIMED_WAITING
            System.out.println("Thread is running...");
            synchronized (Thread.currentThread()) {
                Thread.currentThread().wait(); // WAITING
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}