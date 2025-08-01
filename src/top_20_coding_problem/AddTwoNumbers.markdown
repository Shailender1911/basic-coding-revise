# Add Two Numbers

## Problem Statement
You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order, and each node contains a single digit. Add the two numbers and return the sum as a linked list.

**Example:**
- **Input:** `l1 = [2,4,3], l2 = [5,6,4]`
- **Output:** `[7,0,8]`
- **Explanation:** `342 + 465 = 807`.

## Approach
The optimal approach simulates **elementary addition**, processing digits from both lists, handling carry, and building the result list. This is straightforward and achieves O(max(n,m)) time.

### Why Simulate Addition?
- Matches the problem’s reverse-order storage.
- Handles varying list lengths and carries naturally.

## Pseudocode
```
1. Initialize dummy node for result list, curr = dummy, carry = 0.
2. While l1 or l2 is not null or carry > 0:
   a. Get x = l1.val if l1 exists, else 0.
   b. Get y = l2.val if l2 exists, else 0.
   c. Compute sum = x + y + carry.
   d. Update carry = sum / 10.
   e. Create new node with sum % 10.
   f. Move l1, l2, and curr pointers.
3. Return dummy.next.
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
 * Solution for the Add Two Numbers problem.
 */
public class AddTwoNumbers {

    /**
     * Adds two numbers represented as linked lists.
     *
     * @param l1 First linked list.
     * @param l2 Second linked list.
     * @return Sum as a linked list.
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        int carry = 0;

        while (l1 != null || l2 != null || carry > 0) {
            int x = (l1 != null) ? l1.val : 0;
            int y = (l2 != null) ? l2.val : 0;
            int sum = x + y + carry;
            carry = sum / 10;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            l1 = (l1 != null) ? l1.next : null;
            l2 = (l2 != null) ? l2.next : null;
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        AddTwoNumbers solution = new AddTwoNumbers();
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);
        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);

        ListNode result = solution.addTwoNumbers(l1, l2);
        while (result != null) {
            System.out.print(result.val + " ");
            result = result.next;
        } // 7 0 8
    }
}
```

## Explanation of the Code
1. **Dummy Node**: Simplifies list construction.
2. **Carry Handling**: Tracks carry for each digit addition.
3. **Digit Processing**: Adds digits from both lists, using 0 for exhausted lists.
4. **Result Building**: Creates new nodes for each digit.
5. **Edge Cases**: Handles different lengths and final carry.

## Time Complexity (TC)
- **O(max(n,m))**: Traverses the longer list once.
- Where `n` and `m` are the lengths of the input lists.

## Space Complexity (SC)
- **O(max(n,m))**: Space for the output list.

## Common Interview Questions
1. **What if digits are stored in forward order?**
   - Reverse the lists first or use recursion, but it’s a different problem.
2. **How do you handle overflow?**
   - The problem assumes valid integers, so no overflow occurs.
3. **What if one list is empty?**
   - Treat it as 0 and process the other list with carry.
4. **Can we reuse input lists?**
   - Better to create a new list to avoid modifying inputs.
5. **What if we need to handle negative numbers?**
   - Requires additional logic to track signs.

## Tips for Interviews
- **Explain Carry Logic**: Walk through an example like `342 + 465`.
- **Use Diagrams**: Show how nodes are linked.
- **Discuss Edge Cases**: Mention different lengths and carry propagation.
- **Clarify Input Format**: Confirm reverse-order storage.