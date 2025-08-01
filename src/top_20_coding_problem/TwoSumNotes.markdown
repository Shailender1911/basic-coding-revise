# Two Sum Problem

## Problem Statement
Given an array of integers `nums` and an integer `target`, return indices of the two numbers such that they add up to the target.

You may assume that each input would have **exactly one solution**, and you may not use the same element twice.

You can return the answer in any order.

**Example:**
- **Input:** `nums = [2,7,11,15], target = 9`
- **Output:** `[0, 1]`
- **Explanation:** Because `nums[0] + nums[1] = 2 + 7 = 9`, we return `[0, 1]`.

## Approach
The optimal approach uses a **HashMap** to store the numbers and their indices while iterating through the array. For each number, we check if its complement (`target - nums[i]`) exists in the HashMap. This allows us to find the pair in a single pass, achieving O(n) time complexity.

### Why HashMap?
- HashMap provides O(1) average-case time complexity for lookups and insertions.
- It helps us avoid nested loops, which would result in O(n²) time complexity.

## Pseudocode
```
1. Initialize an empty HashMap to store number-to-index mappings.
2. Iterate through the array:
   a. Calculate complement = target - current number.
   b. If complement exists in HashMap, return [HashMap.get(complement), current index].
   c. Otherwise, add current number and its index to HashMap.
3. If no solution is found, return an empty array (though problem guarantees one solution).
```

## Java Solution
Below is the Java implementation following good coding practices, such as:
- Clear variable names.
- Input validation.
- Proper documentation using Javadoc.
- Encapsulation within a class.

```java
import java.util.HashMap;
import java.util.Map;

/**
 * Solution for the Two Sum problem.
 * Finds indices of two numbers in an array that add up to a target sum.
 */
public class TwoSum {

    /**
     * Finds the indices of two numbers that sum up to the target.
     *
     * @param nums   Array of integers.
     * @param target Target sum.
     * @return Array containing the indices of the two numbers.
     * @throws IllegalArgumentException If nums is null or has less than 2 elements.
     */
    public int[] twoSum(int[] nums, int target) {
        // Input validation
        if (nums == null || nums.length < 2) {
            throw new IllegalArgumentException("Array must have at least two elements.");
        }

        // Map to store number-to-index mappings
        Map<Integer, Integer> numToIndex = new HashMap<>();

        // Iterate through the array
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];

            // Check if complement exists in the map
            if (numToIndex.containsKey(complement)) {
                return new int[]{numToIndex.get(complement), i};
            }

            // Add current number and its index to the map
            numToIndex.put(nums[i], i);
        }

        // No solution found (though problem guarantees one)
        return new int[]{};
    }

    /**
     * Main method for testing the solution.
     */
    public static void main(String[] args) {
        TwoSum solution = new TwoSum();
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        int[] result = solution.twoSum(nums, target);
        System.out.printf("Indices: [%d, %d]%n", result[0], result[1]);
    }
}
```

## Explanation of the Code
1. **Class Structure**: The solution is encapsulated in a `TwoSum` class, adhering to object-oriented principles.
2. **Input Validation**: Checks for null or insufficient array length to ensure robustness.
3. **HashMap Usage**: Stores each number and its index. For each number `nums[i]`, we compute `complement = target - nums[i]` and check if it exists in the HashMap.
4. **Single Pass**: The algorithm processes each element once, adding it to the HashMap after checking for the complement to avoid using the same element twice.
5. **Return Value**: Returns an array of two indices when a valid pair is found.

## Time Complexity (TC)
- **O(n)**: We iterate through the array once, and HashMap operations (put and get) have O(1) average-case complexity.
- Where `n` is the length of the input array.

## Space Complexity (SC)
- **O(n)**: The HashMap stores at most `n` key-value pairs in the worst case.

## Common Interview Questions
1. **What if there are multiple solutions?**
   - The problem guarantees exactly one solution, but if multiple solutions were possible, you could modify the code to return all pairs by collecting results in a list.
2. **Can we solve it without extra space?**
   - Yes, using a brute-force approach with nested loops (O(n²) time), but it’s less efficient.
3. **What if the array is sorted?**
   - If sorted, you could use two pointers (left and right) to find the pair in O(n log n) time (including sorting), but the HashMap approach is still optimal for unsorted arrays.
4. **How would you handle duplicate numbers?**
   - The HashMap approach naturally handles duplicates since it stores the latest index for each number, ensuring we don’t use the same element twice.
5. **What if no solution exists?**
   - The problem guarantees a solution, but in a real-world scenario, you’d return an empty array or throw an exception after the loop.

## Tips for Interviews
- **Clarify Assumptions**: Confirm if the array can contain duplicates, negative numbers, or if the solution must be unique.
- **Discuss Trade-offs**: Mention the brute-force O(n²) approach before presenting the HashMap solution to show your thought process.
- **Edge Cases**: Discuss handling null arrays, single-element arrays, or large inputs.
- **Test the Code**: Walk through an example (e.g., `nums = [2,7,11,15], target = 9`) to demonstrate correctness.

This solution is optimal, easy to understand, and aligns with MAANG interview expectations for the Two Sum problem.