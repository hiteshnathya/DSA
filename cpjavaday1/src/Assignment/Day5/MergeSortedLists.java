package Assignment.Day5;

public class MergeSortedLists {
    public static void main(String[] args) {
        // Create the two sorted linked lists
        Node head1 = new Node(1);
        head1.next = new Node(3);
        head1.next.next = new Node(5);

        Node head2 = new Node(2);
        head2.next = new Node(4);
        head2.next.next = new Node(6);
        System.out.println("---------------");
        System.out.println("List 1 is : ");
        printList(head1);
        System.out.println("---------------");
        System.out.println("List 2 is : ");
        printList(head2);
        System.out.println("---------------");


        // Merge the lists
        Node mergedHead = mergeLists(head1, head2);
        // Print the merged list
        System.out.println();

        System.out.print("Merged List: ");
        printList(mergedHead);
    }

    public static Node mergeLists(Node head1, Node head2) {
        // If both lists are empty, return null
        if (head1 == null && head2 == null) {
            System.out.println("Both lists are empty, returning null");
            return null;
        }

        // Initialize the merged list head
        Node mergedHead = null;

        // If list 1 is empty, return list 2
        if (head1 == null) {
            System.out.println("List 1 is empty, returning List 2");
            mergedHead = head2;
        }
        // If list 2 is empty, return list 1
        else if (head2 == null) {
            System.out.println("List 2 is empty, returning List 1");
            mergedHead = head1;
        }
        // Merge the lists
        else {
            System.out.println("\nMerging lists...");
            // Compare the data of the two nodes
            if (head1.data <= head2.data) {
                System.out.println("head1.data (" + head1.data + ") <= head2.data (" + head2.data + ")");
                mergedHead = head1;
                mergedHead.next = mergeLists(head1.next, head2);
            } else {
                System.out.println("head1.data (" + head1.data + ") > head2.data (" + head2.data + ")");
                mergedHead = head2;
                mergedHead.next = mergeLists(head1, head2.next);
            }
        }

        return mergedHead;
    }

    public static void printList(Node head) {
        while (head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }
        System.out.println();
    }
}
class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}