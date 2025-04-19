package linkedlist;

public class PalindromeLinkedList {

    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }

        // Find the middle of the list
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // Reverse the second half
        ListNode prev = null;
        ListNode curr = slow;
        while (curr != null) {
            ListNode nextNode = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextNode;
        }

        // Compare first and reversed second half
        ListNode first = head;
        ListNode second = prev;
        while (second != null) {
            if (first.getData() != second.getData()) {
                return false;
            }
            first = first.next;
            second = second.next;
        }

        return true;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(10);
        head.next = new ListNode(20);
        head.next.next = new ListNode(30);
        head.next.next.next = new ListNode(20);
        head.next.next.next.next = new ListNode(30);

        PalindromeLinkedList obj = new PalindromeLinkedList();
        boolean isPalindrome = obj.isPalindrome(head);

        System.out.println("The given linked list is palindrome: " + isPalindrome);
    }
}

