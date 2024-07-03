package Day1;

public class LinkList {
        public static void main(String[] args) {
            LinkList list = new LinkList();

            System.out.println("inserting the values");

            list = insert(list, 123);
            list = insert(list, 456);
            list = insert(list, 555);
            list = insert(list, 678);
            list = insert(list, 909);

            printlist(list);

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

    //------------------------------------------------------------------------------------------
        public static LinkList insert(LinkList list, int data) {
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
//----------------------------------------------------------------
        public void insertAtBeginning(int data){
            Node node1=new Node(data);
            node1.next=head;
            head=node1;
        }
//----------------------------------------------------------------
        public void insertAtEnd(int data){
            Node node1=new Node(data);
            if (head==null){
                head=node1;
                return;
            }
            Node last=head;
            while (last.next!=null){
                last=last.next;
            }
            last.next=node1;
        }
//-----------------------------------------------------------------
public void insertAtPosition(int new_data, int position) {
    Node new_node = new Node(new_data);
    if (position == 0) {
        insertAtBeginning(new_data);
        return;
    }
    Node current = head;
    for (int i = 0; current != null && i < position - 1; i++) {
        current = current.next;
    }
    if (current == null) {
        System.out.println("Position out of bounds");
        return;
    }
    new_node.next = current.next;
    current.next = new_node;
}












    public static void printlist(LinkList list) {

            Node currentNode = list.head;
            System.out.printf("Linked List: ");

            while (currentNode != null) {
                System.out.println(currentNode.data + "  ");

                currentNode = currentNode.next;
            }

        }

    }

