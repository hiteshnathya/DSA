package Day_12.Creating;

public class Demo2 implements Runnable{
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
        Demo2 t1=new Demo2();
        Demo2 t2=new Demo2();



        Thread t11=new Thread(t1,"Thread 1");
        Thread t12=new Thread(t2,"Thread 1");


        t11.start();
        System.out.println(t11.getName()+" "+t11.isAlive());
        t11.join();
        System.out.println(t11.getName()+" "+t11.isAlive());
        System.out.println(t12.getName()+" "+t12.isAlive());
        t12.start();


    }
}
