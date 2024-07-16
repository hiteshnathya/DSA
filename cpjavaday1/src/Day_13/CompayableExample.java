package Day_13;

import java.util.concurrent.CompletableFuture;

public class CompayableExample {

    public static void main(String[] args) throws InterruptedException {
        CompletableFuture.supplyAsync(()->"This ").thenApply(r->r+" is").
                thenApply(r->r+" Java world").thenAccept(System.out::println);
        Thread.sleep(2000);


    }


}
