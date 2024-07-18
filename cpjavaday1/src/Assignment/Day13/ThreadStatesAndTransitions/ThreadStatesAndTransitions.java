package Assignment.Day13.ThreadStatesAndTransitions;
public class ThreadStatesAndTransitions {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new MyRunnable());
        System.out.println("Thread state: " + thread.getState()); // NEW

        thread.start();
        System.out.println("Thread state: " + thread.getState()); // RUNNABLE

        Thread.sleep(100); // allow the thread to start
        System.out.println("Thread state: " + thread.getState()); // RUNNABLE

        synchronized (thread) {
            thread.wait(1000); // WAITING
            System.out.println("Thread state: " + thread.getState()); // WAITING
        }

        synchronized (thread) { // added synchronized block
            thread.notify(); // notify the thread to wake up
        }
        System.out.println("Thread state: " + thread.getState()); // RUNNABLE

        thread.join(2000); // TIMED_WAITING
        System.out.println("Thread state: " + thread.getState()); // TIMED_WAITING

        // BLOCKED state is demonstrated by trying to access a synchronized block
        synchronized (thread) {
            System.out.println("Thread state: " + thread.getState()); // BLOCKED
        }

        // TERMINATED state is demonstrated by checking the state after the thread finishes
        thread.join();
        System.out.println("Thread state: " + thread.getState()); // TERMINATED
    }
}

class MyRunnable implements Runnable {
    @Override
    public void run() {
        try {
            Thread.sleep(500); // simulate some work
            System.out.println("Thread is running...");
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}