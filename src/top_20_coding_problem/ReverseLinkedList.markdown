# Reverse Linked List

## Problem Statement
Given the head of a singly linked list, reverse the list, and return the reversed list.

**Example:**
- **Input:** `head = [1,2,3,4,5]`
- **Output:** `[5,4,3,2,1]`

## Approach
The optimal approach uses an **iterative method** to reverse the list by adjusting pointers, achieving O(n) time and O(1) space. A recursive solution is also possible but uses O(n) stack space.

### Why Iterative?
- Constant space usage compared to recursive’s stack space.
- Simple and intuitive for interviews.

## Pseudocode
```
1. Initialize prev = null, curr = head.
2. While curr is not null:
   a. Save next node: next = curr.next.
   b. Reverse link: curr.next = prev.
   c. Move pointers: prev = curr, curr = next.
3. Return prev (new head).
```

## Java Solution
```java
/**
 * Definition for singly-linked list.
 */
class ListNode {
    int val;
    ListNode next;
    ListNode(int val) { this.val = val; }
}

/**
 * Solution for the Reverse Linked List problem.
 */
public class ReverseLinkedList {

    /**
     * Reverses a singly linked list.
     *
     * @param head Head of the linked list.
     * @return Head of the reversed list.
     */
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;

        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }

    public static void main(String[] args) {
        ReverseLinkedList solution = new ReverseLinkedList();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        ListNode reversed = solution.reverseList(head);
        while (reversed != null) {
            System.out.print(reversed.val + " ");
            reversed = reversed.next;
        } // 5 4 3 2 1
    }
}
```

## Explanation of the Code
1. **Pointer Manipulation**: Uses `prev`, `curr`, and `next` to reverse links.
2. **Iterative Loop**: Processes each node, updating `next` pointers.
3. **Edge Cases**: Handles empty lists and single-node lists naturally.
4. **Return Value**: `prev` becomes the new head.

## Time Complexity (TC)
- **O(n)**: Traverses the list once.
- Where `n` is the number of nodes.

## Space Complexity (SC)
- **O(1)**: Uses only a few pointers.

## Common Interview Questions
1. **Can we solve it recursively?**
   - Yes, but it uses O(n) stack space.
2. **What if the list has a cycle?**
   - The problem assumes no cycles. With cycles, the algorithm would loop indefinitely.
3. **How do you handle a single node?**
   - Returns the node itself, as it’s already reversed.
4. **What if we need to reverse in groups of k?**
   - That’s a different problem (Reverse Nodes in k-Group), requiring additional logic.
5. **How do you test the solution?**
   - Check empty list, single node, two nodes, and a longer list.

## Tips for Interviews
- **Draw the List**: Illustrate pointer changes for a small list like `1->2->3`.
- **Explain Each Step**: Clarify why `next` is saved before reversing.
- **Discuss Recursive vs. Iterative**: Highlight space trade-offs.
- **Handle Edge Cases**: Mention empty and single-node lists.