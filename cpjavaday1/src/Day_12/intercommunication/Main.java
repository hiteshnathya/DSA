package Day_12.intercommunication;

class Share {
    private int item;
    private boolean isAvailable = false;

    public synchronized void add(int item) {
        System.out.println("Producer is trying to add item " + item);
        while (isAvailable) {
            try {
                System.out.println("Producer is waiting because item is available");
                wait();
            } catch (Exception e) {
                System.out.println("Interrupted");
            }
        }
        this.item = item;
        isAvailable = true;
        System.out.println("Producer added item " + item);
        notify();
        System.out.println("Producer notified");
    }

    public synchronized int retrieve() {
        System.out.println("Consumer is trying to retrieve item");
        while (!isAvailable) {
            try {
                System.out.println("Consumer is waiting because item is not available");
                wait();
            } catch (Exception e) {
                System.out.println("Interrupted");
            }
        }
        isAvailable = false;
        System.out.println("Consumer retrieved item " + item);
        notify();
        System.out.println("Consumer notified");
        return item;
    }
}

class Producer extends Thread {
    private Share share;

    public Producer(Share share) {
        this.share = share;
    }

    public void run() {
        for (int i = 0; i <= 6; i++) {
            share.add(i);
            System.out.println("Produced " + i);
            try {
                Thread.sleep(1000); // add a delay to see the output clearly
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Consumer extends Thread {
    private Share share;

    public Consumer(Share share) {
        this.share = share;
    }

    public void run() {
        for (int i = 0; i <= 6; i++) {
            int item = share.retrieve();
            System.out.println("Consumed " + item);
            System.out.println();
            try {
                Thread.sleep(1000); // add a delay to see the output clearly
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

public class Main {

    public static void main(String[] args) {
        Share share = new Share();
        Producer producer = new Producer(share);
        Consumer consumer = new Consumer(share);

        producer.start();
        System.out.println();
        consumer.start();
    }
}