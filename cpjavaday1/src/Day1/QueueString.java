package Day1;

public class QueueString {

        public static void main(String[] args) {
            QueueString newqueue = new QueueString();
            newqueue.enQueue("Hitesh");
            newqueue.enQueue("Vinay");
            newqueue.enQueue("Ram");
            newqueue.enQueue("Bharat");
            newqueue.enQueue("Jassy");

            System.out.println("Display the Queue");
            newqueue.Display();
            newqueue.deQueue();
            newqueue.deQueue();
            System.out.println();
            System.out.println("Display Queue after deQueue() perform ");
            System.out.println();
            newqueue.Display();
            System.out.println();
            newqueue.peak();
        }

        int queuelength = 5;
        String elements[] = new String[queuelength];
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

        void enQueue(String ElementValue) {
            if (isfull()) {
                System.out.println("Queue is already full");
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
                System.out.println("No element in Queue");
            } else if (front == back) {
                front = -1;
                back = -1;
            } else {
                front++;
            }
        }

        void Display() {
            if (isEmpty()) {
                System.out.println("Queue is empty");
            } else {
                for (int i = front; i <= back; i++) {
                    System.out.println(elements[i]);
                }
            }
        }

        void peak() {
            System.out.println("Front value is = " + elements[front]);
        }

    }




