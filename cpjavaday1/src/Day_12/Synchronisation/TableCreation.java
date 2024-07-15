package Day_12.Synchronisation;

// This class represents the main class for table creation
class TableCreation {
    public static void main(String[] args) {
        // Create an instance of TableCreation
        TableCreation object = new TableCreation();

        // Create two threads that will call the creationtable method
        Thread1 t1 = new Thread1(object);
        System.out.println();
        Thread2 t2 = new Thread2(object);
        // Print a message to indicate that threads are starting
        System.out.println("Starting threads...");

        // Start both threads
        t2.start();
        t1.start();


        // Print a message to indicate that threads have started
        System.out.println("Threads started.");
    }

    // This method is synchronized, meaning only one thread can execute it at a time
    synchronized public void creationtable(int n) {
        // Print a message to indicate which thread is creating the table
        System.out.println("Thread " + Thread.currentThread().getName() + " is creating table for " + n);

        // Create a table for the given number
        for (int i = 0; i <= 10; i++) {
            System.out.println(n + " * " + i + "=" + n * i);

            // Pause the thread for 2 seconds
            try {
                Thread.sleep(1000);
            } catch (Exception e) {
                System.out.println(" Thread interruption");
            }
        }

        // Print a message to indicate that the thread has finished creating the table
        System.out.println("Thread " + Thread.currentThread().getName() + " finished creating table for " + n);
    }
}

// This class represents a thread that calls the creationtable method
class Thread1 extends Thread {
    TableCreation obj;

    // Constructor to initialize the TableCreation object
    public Thread1(TableCreation o) {
        this.obj = o;
    }

    // This method is called when the thread is started
    public void run() {
        // Print a message to indicate that the thread is running
        System.out.println("Thread " + Thread.currentThread().getName() + " is running...");

        // Call the creationtable method with the argument 20
        obj.creationtable(50);

        // Print a message to indicate that the thread has finished running
        System.out.println("Thread " + Thread.currentThread().getName() + " finished running.");
    }
}

class Thread2 extends Thread {
    TableCreation obj;

    public Thread2(TableCreation o) {
        this.obj = o;
    }

    // This method is called when the thread is started
    public void run() {
        // Print a message to indicate that the thread is running
        System.out.println("Thread " + Thread.currentThread().getName() + " is running...");

        // Call the creationtable method with the argument 20
        obj.creationtable(20);

        // Print a message to indicate that the thread has finished running
        System.out.println("Thread " + Thread.currentThread().getName() + " finished running.");
    }
}


//
//
//package Day_12.Synchronisation;
//
//class TableCreation
//{
//    public static void main(String args[])
//    {
//        TableCreation object = new TableCreation();
//        Thread1 t1 = new Thread1(object);
//        Thread2 t2 = new Thread2(object);
//        t1.start();
//        t2.start();
//    }
//
//    synchronized public void  createTable(int n)
//    {
//        for(int i=1;i<=5;i++)
//        {
//            System.out.println(n+ " * "+ i+ " = "+ n*i);
//            try
//            {
//                Thread.sleep(2000);
//            }
//            catch(Exception e)
//            {
//                System.out.println("Thread Interrupted");
//            }
//        }
//    }
//}
//class Thread1 extends Thread
//{
//    TableCreation obj;
//    public Thread1(TableCreation o)
//    {
//        this.obj = o;
//    }
//    public void run()
//    {
//        obj.createTable(10);
//    }
//}
//class Thread2 extends Thread
//{
//    TableCreation obj;
//    public Thread2(TableCreation o)
//    {
//        this.obj = o;
//    }
//    public void run()
//    {
//        obj.createTable(20);
//    }
//}
//




