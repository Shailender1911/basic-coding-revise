# Linked List Cycle

## Problem Statement
Given the head of a linked list, determine if the linked list has a cycle in it. Return `true` if there is a cycle, otherwise return `false`.

**Example:**
- **Input:** `head = [3,2,0,-4], pos = 1`
- **Output:** `true`
- **Explanation:** The tail connects to the node at index 1, forming a cycle.

## Approach
The optimal approach uses **Floyd’s Cycle-Finding Algorithm** (two-pointer or "tortoise and hare"). A slow pointer moves one step, and a fast pointer moves two steps. If they meet, a cycle exists. This achieves O(n) time and O(1) space.

### Why Floyd’s Algorithm?
- Detects cycles without extra space, unlike a HashSet approach (O(n) space).
- Mathematically guaranteed to find a cycle if one exists.

## Pseudocode
```
1. Initialize slow = head, fast = head.
2. While fast and fast.next are not null:
   a. Move slow one step: slow = slow.next.
   b. Move fast two steps: fast = fast.next.next.
   c. If slow == fast, return true (cycle found).
3. Return false (no cycle).
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
 * Solution for the Linked List Cycle problem.
 */
public class LinkedListCycle {

    /**
     * Detects if a linked list has a cycle.
     *
     * @param head Head of the linked list.
     * @return True if a cycle exists, false otherwise.
     */
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }

        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        LinkedListCycle solution = new LinkedListCycle();
        ListNode head = new ListNode(3);
        head.next = new ListNode(2);
        head.next.next = new ListNode(0);
        head.next.next.next = new ListNode(-4);
        head.next.next.next.next = head.next; // Cycle at pos 1

        System.out.println("Has cycle: " + solution.hasCycle(head)); // true
    }
}
```

## Explanation of the Code
1. **Two Pointers**: `slow` moves one step, `fast` moves two.
2. **Cycle Detection**: If `slow` and `fast` meet, a cycle exists.
3. **Edge Cases**: Handles empty lists and lists with no cycles.
4. **Termination**: Stops if `fast` reaches the end (no cycle).

## Time Complexity (TC)
- **O(n)**: Fast pointer traverses the list, meeting slow in O(n) steps if a cycle exists.
- Where `n` is the number of nodes.

## Space Complexity (SC)
- **O(1)**: Uses only two pointers.

## Common Interview Questions
1. **How does Floyd’s algorithm work?**
   - The fast pointer catches up to the slow pointer in a cycle due to relative speed.
2. **Can we use a HashSet?**
   - Yes, but it requires O(n) space to store visited nodes.
3. **What if we need the cycle’s starting node?**
   - After detecting a cycle, reset one pointer to the head and move both one step until they meet.
4. **What if the list is empty?**
   - Return `false`, as handled by the code.
5. **Why doesn’t it work for directed graphs?**
   - Floyd’s algorithm is specific to linked lists with a single path.

## Tips for Interviews
- **Explain Intuition**: Use the “runner” analogy to describe fast and slow pointers.
- **Draw a Cycle**: Illustrate how pointers meet in a small list.
- **Discuss Alternatives**: Mention HashSet but emphasize O(1) space.
- **Clarify Edge Cases**: Discuss no-cycle and single-node cases.