# Merge k Sorted Lists

## Problem Statement
You are given an array of `k` linked lists, each sorted in ascending order. Merge all the linked lists into one sorted linked list and return it.

**Example:**
- **Input:** `lists = [[1,4,5],[1,3,4],[2,6]]`
- **Output:** `[1,1,2,3,4,4,5,6]`
- **Explanation:** Merges the lists into a single sorted list.

## Approach
The optimal approach uses a **min-heap** (Priority Queue) to efficiently select the smallest node among the heads of the `k` lists, achieving O(n log k) time, where `n` is the total number of nodes.

### Why Min-Heap?
- Always gives the smallest element in O(log k) time.
- Avoids repeatedly scanning all lists (O(nk) time).

## Pseudocode
```
1. Initialize a min-heap with the heads of all non-null lists.
2. Initialize dummy node for result list, curr = dummy.
3. While heap is not empty:
   a. Pop smallest node from heap.
   b. Add node to result list.
   c. If node has a next node, add it to heap.
   d. Move curr pointer.
4. Return dummy.next.
```

## Java Solution
```java
import java.util.PriorityQueue;

/**
 * Definition for singly-linked list.
 */
class ListNode {
    int val;
    ListNode next;
    ListNode(int val) { this.val = val; }
}

/**
 * Solution for the Merge k Sorted Lists problem.
 */
public class MergeKSortedLists {

    /**
     * Merges k sorted linked lists into one sorted list.
     *
     * @param lists Array of sorted linked lists.
     * @return Head of the merged sorted list.
     */
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }

        PriorityQueue<ListNode> minHeap = new PriorityQueue<>((a, b) -> a.val - b.val);
        for (ListNode node : lists) {
            if (node != null) {
                minHeap.offer(node);
            }
        }

        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;

        while (!minHeap.isEmpty()) {
            ListNode node = minHeap.poll();
            curr.next = node;
            curr = curr.next;
            if (node.next != null) {
                minHeap.offer(node.next);
            }
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        MergeKSortedLists solution = new MergeKSortedLists();
        ListNode[] lists = new ListNode[3];
        lists[0] = new ListNode(1);
        lists[0].next = new ListNode(4);
        lists[0].next.next = new ListNode(5);
        lists[1] = new ListNode(1);
        lists[1].next = new ListNode(3);
        lists[1].next.next = new ListNode(4);
        lists[2] = new ListNode(2);
        lists[2].next = new ListNode(6);

        ListNode result = solution.mergeKLists(lists);
        while (result != null) {
            System.out.print(result.val + " ");
            result = result.next;
        } // 1 1 2 3 4 4 5 6
    }
}
```

## Explanation of the Code
1. **Min-Heap**: Stores nodes, sorted by value.
2. **Initialization**: Adds heads of non-null lists to the heap.
3. **Merging**: Pops smallest node, adds to result, and pushes its next node.
4. **Dummy Node**: Simplifies result list construction.
5. **Edge Cases**: Handles empty or null lists.

## Time Complexity (TC)
- **O(n log k)**: Each of `n` nodes is pushed and popped from a heap of size `k`, with O(log k) per operation.
- Where `n` is the total number of nodes, `k` is the number of lists.

## Space Complexity (SC)
- **O(k)**: Heap stores at most `k` nodes.

## Common Interview Questions
1. **Can we merge pairwise?**
   - Yes, but it’s O(n log k) with more overhead than a heap.
2. **What if some lists are empty?**
   - The heap skips null nodes, as implemented.
3. **How do you handle very large k?**
   - The heap approach scales well, but discuss memory for large `k`.
4. **Can we solve it without a heap?**
   - Yes, by merging lists sequentially (O(nk)), but it’s less efficient.
5. **What if lists are not sorted?**
   - The problem assumes sorted lists. Otherwise, sort each list first.

## Tips for Interviews
- **Explain Heap Usage**: Clarify why a min-heap is efficient.
- **Walk Through Example**: Show how nodes are processed for `[[1,4,5],[1,3,4]]`.
- **Discuss Alternatives**: Mention pairwise merging or divide-and-conquer.
- **Handle Edge Cases**: Discuss empty lists and single lists.