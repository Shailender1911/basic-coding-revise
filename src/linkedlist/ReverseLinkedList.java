package linkedlist;

public class ReverseLinkedList {

    private ListNode reverseLinkedList(ListNode head) {
        if (head == null || head.next == null) {
            System.out.println("List is either null or has only one element");
            return head;  // Added return statement
        }

        ListNode current = head;
        ListNode prev = null;

        while (current != null) {
            ListNode nextNode = current.next;
            current.next = prev;
            prev = current;
            current = nextNode;
        }
        return prev;
    }

    public static void main(String[] args) {
        // Create the list: 10 -> 20 -> 30 -> 40
        ListNode head = new ListNode(10);
        head.next = new ListNode(20);
        head.next.next = new ListNode(30);
        head.next.next.next = new ListNode(40);

        System.out.println("Original list:");
        printList(head);  // Print original list

        ReverseLinkedList obj = new ReverseLinkedList();
        ListNode reversedList = obj.reverseLinkedList(head);

        System.out.println("\nReversed list:");
        printList(reversedList);  // Print reversed list
    }

    // Helper method to print the list (assuming ListNode doesn't have printList)
    private static void printList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.getData() + " ");
            current = current.next;
        }
        System.out.println();
    }
}
//
//// Basic ListNode implementation
//class ListNode {
//    int val;
//    ListNode next;
//
//    ListNode() {}
//    ListNode(int val) { this.val = val; }
//    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
//}