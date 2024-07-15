package Assignment.Day13;

class ProducerConsumer {
    public static void main(String[] args) {
        ProducerConsumer pc = new ProducerConsumer();
        Producer producer = new Producer(pc, 10);
        Consumer consumer = new Consumer(pc, 10);

        producer.start();
        consumer.start();
    }
    private int data = -1;
    private boolean isAvailable = false;

    public synchronized void produce(int data) {
        while (isAvailable) {
            try {
                wait(); // wait until the consumer consumes the data
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.data = data;
        isAvailable = true;
        notify(); // notify the consumer that data is available
    }

    public synchronized int consume() {
        while (!isAvailable) {
            try {
                wait(); // wait until the producer produces the data
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        int data = this.data;
        isAvailable = false;
        notify(); // notify the producer that data has been consumed
        return data;
    }
}

class Producer extends Thread {
    private ProducerConsumer pc;
    private int count;

    public Producer(ProducerConsumer pc, int count) {
        this.pc = pc;
        this.count = count;
    }

    @Override
    public void run() {
        for (int i = 0; i < count; i++) {
            pc.produce(i);
            System.out.println("Produced: " + i);
        }
    }
}

class Consumer extends Thread {
    private ProducerConsumer pc;
    private int count;

    public Consumer(ProducerConsumer pc, int count) {
        this.pc = pc;
        this.count = count;
    }

    @Override
    public void run() {
        for (int i = 0; i < count; i++) {
            int data = pc.consume();
            System.out.println("Consumed: " + data);
        }
    }
}
