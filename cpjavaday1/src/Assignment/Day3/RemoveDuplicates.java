package Assignment.Day3;

class Node{

    int key;
    Node left,right;

    Node next;


    public Node(int key) {
        this.key = key;
        this.next = null;
        this.left = null;
        this.right = null;
    }
}

public class RemoveDuplicates {

    public static Node removeDuplicates(Node head) {
        Node current = head;
        while (current != null && current.next != null) {
            if (current.key == current.next.key) {
                System.out.println("Removing duplicate: " + current.next.key);
                current.next = current.next.next;
            } else {
                current = current.next;
            }
        }
        return head;
    }

    public static void printList(Node head) {
        while (head != null) {
            System.out.print(head.key + " ");
            head = head.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(1);
        head.next.next = new Node(2);
        head.next.next.next = new Node(2);
        head.next.next.next.next = new Node(3);
        head.next.next.next.next.next = new Node(3);
        head.next.next.next.next.next.next = new Node(4);

        System.out.println("Original List:");
        printList(head);

        System.out.println("Removing duplicates...");
        head = removeDuplicates(head);

        System.out.println("List after removing duplicates:");
        printList(head);
    }


}
