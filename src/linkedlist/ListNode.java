package linkedlist;

public class ListNode {
    private int data;
    ListNode next;

    public ListNode(int data) {
        this.data = data;
        this.next = null;
    }

    public ListNode() {
    }

    // Getter for data
    public int getData() {
        return data;
    }

    // Setter for data
    public void setData(int data) {
        this.data = data;
    }

    // Getter for next
    public ListNode getNext() {
        return next;
    }

    // Setter for next
    public void setNext(ListNode next) {
        this.next = next;
    }

    // Function to insert a node at the beginning
    private ListNode insertAtTheBeginning(ListNode head, int data) {
        ListNode newNode = new ListNode(data);
        newNode.next = head;
        head = newNode;
        return head;
    }

    // Function to insert a node at the end
    private ListNode insertAtTheEnd(ListNode head, int data) {
        ListNode newNode = new ListNode(data);
        if (head == null) {
            return newNode;
        }
        ListNode current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = newNode;
        return head;
    }

    // Function to print the list
    private void printList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.println(current.getData());
            current = current.next;
        }
    }

    public static void main(String[] args) {
        ListNode head = null;
        ListNode listNode = new ListNode();

        head = listNode.insertAtTheBeginning(head, 10);
        head = listNode.insertAtTheBeginning(head, 20);
        head = listNode.insertAtTheBeginning(head, 30);
        head = listNode.insertAtTheBeginning(head, 5);

        System.out.println("List after inserting at the beginning:");
        listNode.printList(head);

        head = listNode.insertAtTheEnd(head, 50);
        head = listNode.insertAtTheEnd(head, 60);

        System.out.println("List after inserting at the end:");
        listNode.printList(head);
    }
}
