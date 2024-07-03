package Day1;

public class queue {
    public static void main(String[] args) {
        queue newqueue = new queue();
        newqueue.enQueue(20);
        newqueue.enQueue(30);
        newqueue.enQueue(40);
        newqueue.enQueue(50);
        newqueue.enQueue(60);

        System.out.println(" Display the Queue");
        newqueue.Display();

        newqueue.deQueue();
        newqueue.deQueue();

        System.out.println(" Display Queue after deQeque() perform ");
        newqueue.Display();
        System.out.println();
        newqueue.peak();

        System.out.println(" After deQueue ");
        System.out.println(" Maximum value in the Day1.queue is " + newqueue.FindMax());
        System.out.println(" Minimum value in the Day1.queue is " + newqueue.FindMin());


    }

    int queuelength = 5;
    int elements[] = new int[queuelength];
    int front = -1;
    int back = -1;

    boolean isfull() {
        if (back == queuelength - 1) {
            return true;

        } else {
            return false;
        }
    }

    boolean isEmpty() {
        if (front == -1 && back == -1) {
            return true;
        } else {
            return false;

        }
    }

    void enQueue(int ElementValue) {
        if (isfull()) {
            System.out.println(" Queue ia already full");
        } else if (front == -1 && back == -1) {
            front = 0;
            back = 0;
            elements[back] = ElementValue;
        } else {
            back++;
            elements[back] = ElementValue;
        }
    }

    void deQueue() {
        if (isEmpty()) {
            System.out.println(" No element in Queue");
        } else if (front == back) {
            front = -1;
            back = -1;
        } else {
            front++;
        }
    }

    void Display() {


        if (isEmpty()) {
            System.out.println(" Queue is empty");
        } else {
            for (int i = 0; i <= back; i++) {
                System.out.println(elements[i]);
            }
        }
    }

    public int FindMin() {
        if (isEmpty()) {
            System.out.println("Queue is empty!");
            return -1; // Or throw an exception
        }
        int min = elements[front];
        for (int i = front + 1; i <= back; i++) {
            if (elements[i] < min) {
                min = elements[i];
            }
        }
        return min;
    }

    // Find maximum value in the Day1.queue
    public int FindMax() {
        if (isEmpty()) {
            System.out.println("Queue is Already empty!");
            return -1; // Or throw an exception
        }
        int max = elements[front];
        for (int i = front + 1; i <= back; i++) {
            if (elements[i] > max) {
                max = elements[i];
            }
        }
        return max;
    }

    void peak() {
        System.out.println(" Front value is = " + elements[front]);
    }

}
