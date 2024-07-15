package Day_12.executers;

import org.w3c.dom.ls.LSOutput;

import java.sql.SQLOutput;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class SES {

    public static void main(String[] args) {
        //with lambda
//        ScheduledExecutorService sch= Executors.newScheduledThreadPool(1);
//        Runnable task=()-> System.out.println(" Schedule task "+System.currentTimeMillis());
//        sch.scheduleAtFixedRate(task,0,3, TimeUnit.SECONDS);
//        sch.schedule(()->sch.shutdown(),10,TimeUnit.SECONDS);

        // fixed rate (Task to run repeteadely at a fix rate
        ScheduledExecutorService executor= Executors.newScheduledThreadPool(1);
        Runnable task=new Runnable() {
            @Override
            public void run() {
                System.out.println(" Task Executed at : "+ System.currentTimeMillis());

            }
        };
        executor.scheduleAtFixedRate(task,0,3, TimeUnit.SECONDS);
        executor.schedule(()->executor.shutdown(),10,TimeUnit.SECONDS);


        Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() {
            @Override
            public void run() {

            }
        }));




    }
}
