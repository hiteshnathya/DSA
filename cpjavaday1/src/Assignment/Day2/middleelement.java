package Assignment.Day2;

public class middleelement {
    public static void main(String[] args) {
        middleelement list=new middleelement();
        list.addNode(1);
        list.addNode(2);
        list.addNode(3);
        list.addNode(4);
        list.addNode(5);

        list.findMiddle();

    }
    Node head;

    public void addNode(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
        } else {
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
        }
        System.out.println("Added node with data: " + data);
    }

    public void findMiddle() {
        if (head == null) {
            System.out.println("The list is empty");
            return;
        }

        Node slow = head;
        Node fast = head;
        int position = 0;

        System.out.println("\nFinding middle element:");
        while (fast != null && fast.next != null) {
            System.out.println("Step " + position + ": Slow pointer at " + slow.data + ", Fast pointer at " + fast.data);
            slow = slow.next;
            fast = fast.next.next;
            position++;
        }

        System.out.println("Middle element is: " + slow.data);
    }



}

class Node {
    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }
}