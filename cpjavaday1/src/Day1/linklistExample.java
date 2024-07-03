package Day1;

public class linklistExample {
    public static void main(String[] args) {
        linklistExample list = new linklistExample();

        System.out.println("inserting the values");

        list = insert(list, 123);
        list = insert(list, 456);
        list = insert(list, 555);
        list = insert(list, 678);
        list = insert(list, 909);

        printlist(list);

    }


    public static linklistExample insert(linklistExample list, int data) {
        Node node1 = new Node(data);
        node1.next = null;

        if (list.head == null) {
            list.head = node1;
        } else {
            Node last = list.head;
            while (last.next != null) {
                last = last.next;
            }
            last.next = node1;
        }
        return list;
    }

    Node head;

    static class Node {
        int data;
        Node next;

        Node(int d) {
            data = d;
            next = null;
        }
    }


    public static void printlist(linklistExample list) {

        Node currentNode = list.head;
        System.out.printf("Linked List: ");

        while (currentNode != null) {
            System.out.println(currentNode.data + "  ");

            currentNode = currentNode.next;
        }

    }

}
