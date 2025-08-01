# Top K Frequent Elements

## Problem Statement
Given an integer array `nums` and an integer `k`, return the `k` most frequent elements. You may return the answer in any order.

**Example:**
- **Input:** `nums = [1,1,1,2,2,3], k = 2`
- **Output:** `[1,2]`
- **Explanation:** 1 appears 3 times, 2 appears 2 times, 3 appears 1 time.

## Approach
The optimal approach uses a **HashMap** to count frequencies and a **min-heap** (Priority Queue) to keep the top k elements, achieving O(n log k) time. Alternatively, bucket sort can achieve O(n) but is less common in interviews.

### Why HashMap and Min-Heap?
- HashMap efficiently counts frequencies in O(n).
- Min-heap maintains top k elements with O(log k) per operation.

## Pseudocode
```
1. Build HashMap of number-to-frequency.
2. Initialize min-heap of size k.
3. For each entry in HashMap:
   a. Add to heap.
   b. If heap size > k, remove smallest frequency element.
4. Extract k elements from heap to result array.
5. Return result.
```

## Java Solution
```java
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * Solution for the Top K Frequent Elements problem.
 */
public class TopKFrequentElements {

    /**
     * Finds the k most frequent elements in the array.
     *
     * @param nums Input array of integers.
     * @param k    Number of frequent elements to return.
     * @return Array of k most frequent elements.
     * @throws IllegalArgumentException If nums is null or k is invalid.
     */
    public int[] topKFrequent(int[] nums, int k) {
        if (nums == null || k <= 0 || k > nums.length) {
            throw new IllegalArgumentException("Invalid input.");
        }

        // Count frequencies
        Map<Integer, Integer> freqMap = new HashMap<>();
        for (int num : nums) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }

        // Min-heap based on frequency
        PriorityQueue<Map.Entry<Integer, Integer>> minHeap = new PriorityQueue<>(
            (a, b) -> a.getValue() - b.getValue()
        );

        for (Map.Entry<Integer, Integer> entry : freqMap.entrySet()) {
            minHeap.offer(entry);
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }

        // Extract k elements
        int[] result = new int[k];
        for (int i = k - 1; i >= 0; i--) {
            result[i] = minHeap.poll().getKey();
        }

        return result;
    }

    public static void main(String[] args) {
        TopKFrequentElements solution = new TopKFrequentElements();
        int[] nums = {1, 1, 1, 2, 2, 3};
        int k = 2;
        int[] result = solution.topKFrequent(nums, k);
        System.out.print("Top " + k + ": ");
        for (int num : result) {
            System.out.print(num + " ");
        } // 1 2
    }
}
```

## Explanation of the Code
1. **Input Validation**: Checks for null array or invalid k.
2. **Frequency Map**: Counts occurrences of each number.
3. **Min-Heap**: Maintains k elements with highest frequencies.
4. **Result Extraction**: Builds result array from heap.
5. **Edge Cases**: Handles k = 1 or k = unique elements.

## Time Complexity (TC)
- **O(n log k)**: O(n) for HashMap, O(n log k) for heap operations.
- Where `n` is the length of the input array, `k` is the output size.

## Space Complexity (SC)
- **O(n)**: HashMap and heap (up to n entries).

## Common Interview Questions
1. **Can we use bucket sort?**
   - Yes, for O(n) time, but heap is more flexible.
2. **What if k equals the number of unique elements?**
   - Return all unique elements, as handled by the code.
3. **How do you handle ties in frequency?**
   - Any k elements with top frequencies are valid.
4. **What if the array is empty?**
   - Throw an exception or return empty array, as implemented.
5. **Can we sort by frequency?**
   - Yes, but O(n log n), less efficient than heap for large n.

## Tips for Interviews
- **Explain Heap Size**: Clarify why heap is limited to k.
- **Walk Through Example**: Use [1,1,1,2,2,3] to show frequency counting.
- **Discuss Bucket Sort**: Mention O(n) alternative for advanced knowledge.
- **Handle Edge Cases**: Discuss k = 1 and empty arrays.