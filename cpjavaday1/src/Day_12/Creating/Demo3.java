package Day_12.Creating;

public class Demo3 implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i <=5; i++)
        {
            System.out.println(Thread.currentThread()+"  ------    "+i+" ");
            try {
                Thread.sleep(2000);

            }catch (InterruptedException e)
            {
                System.out.println(" Thread Interrupted ");
            }

        }

    }
    public static void main(String[] args) throws InterruptedException {
        Demo3 t1=new Demo3();
        Demo3 t2=new Demo3();


        Thread t11=new Thread(t1,"Thread 1");
        Thread t12=new Thread(t2,"Thread 2");

        // Thread operations
        System.out.println("Before starting threads:");
        System.out.println("t11.isAlive(): " + t11.isAlive());
        System.out.println("t12.isAlive(): " + t12.isAlive());

        // Set priority for threads
        t11.setPriority(Thread.MAX_PRIORITY); // Set highest priority for t11
        t12.setPriority(Thread.NORM_PRIORITY); // Set normal priority for t12

        t11.start();
        t12.start();

        System.out.println("After starting threads:");
        System.out.println("t11.isAlive(): " + t11.isAlive());
        System.out.println("t12.isAlive(): " + t12.isAlive());

        // Wait for t11 to finish
        t11.join();
        System.out.println("t11 finished");

        // Check if t11 is alive after joining
        System.out.println("t11.isAlive(): " + t11.isAlive());

        // Wait for t12 to finish
        t12.join();
        System.out.println("t12 finished");

        // Check if t12 is alive after joining
        System.out.println("t12.isAlive(): " + t12.isAlive());

        // Check if main thread is alive
        System.out.println("Main thread is alive: " + Thread.currentThread().isAlive());


        // Stop threads (Note: This method is deprecated)
        // t11.stop();
        // t12.stop();

        // Yield the current thread
        Thread.currentThread().yield();
        System.out.println("Main thread yielded");

        // Check if threads are alive after yielding
        System.out.println("t11.isAlive(): " + t11.isAlive());
        System.out.println("t12.isAlive(): " + t12.isAlive());
    }


}
