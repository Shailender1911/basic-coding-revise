# Maximum Subarray

## Problem Statement
Given an integer array `nums`, find the subarray with the largest sum and return its sum.

**Example:**
- **Input:** `nums = [-2,1,-3,4,-1,2,1,-5,4]`
- **Output:** `6`
- **Explanation:** The subarray `[4,-1,2,1]` has the largest sum `6`.

## Approach
The optimal approach uses **Kadane’s Algorithm**, which iterates through the array, maintaining the maximum sum ending at each index and updating the global maximum. This achieves O(n) time and O(1) space.

### Why Kadane’s Algorithm?
- Efficiently handles negative sums by resetting when they reduce the total.
- Avoids checking all subarrays (O(n²)).

## Pseudocode
```
1. Initialize maxSum = nums[0], currSum = nums[0].
2. For each i from 1 to n-1:
   a. currSum = max(nums[i], currSum + nums[i]).
   b. maxSum = max(maxSum, currSum).
3. Return maxSum.
```

## Java Solution
```java
/**
 * Solution for the Maximum Subarray problem.
 */
public class MaximumSubarray {

    /**
     * Finds the maximum sum of a contiguous subarray.
     *
     * @param nums Input array of integers.
     * @return Maximum subarray sum.
     * @throws IllegalArgumentException If nums is null or empty.
     */
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            throw new IllegalArgumentException("Array cannot be null or empty.");
        }

        int maxSum = nums[0];
        int currSum = nums[0];

        for (int i = 1; i < nums.length; i++) {
            currSum = Math.max(nums[i], currSum + nums[i]);
            maxSum = Math.max(maxSum, currSum);
        }

        return maxSum;
    }

    public static void main(String[] args) {
        MaximumSubarray solution = new MaximumSubarray();
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println("Max Sum: " + solution.maxSubArray(nums)); // 6
    }
}
```

## Explanation of the Code
1. **Input Validation**: Checks for null or empty array.
2. **Kadane’s Logic**: `currSum` tracks the maximum sum ending at `i`, resetting if negative.
3. **Max Update**: `maxSum` stores the global maximum.
4. **Initialization**: Starts with `nums[0]` to handle single-element arrays.
5. **Edge Cases**: Works for all-negative arrays and single elements.

## Time Complexity (TC)
- **O(n)**: Single pass through the array.
- Where `n` is the length of the input array.

## Space Complexity (SC)
- **O(1)**: Uses only two variables.

## Common Interview Questions
1. **What if all numbers are negative?**
   - Returns the largest single number, as handled by the code.
2. **Can we find the subarray itself?**
   - Track start and end indices when updating `maxSum`.
3. **What if the array has one element?**
   - Returns that element, as initialized with `nums[0]`.
4. **Can we use divide-and-conquer?**
   - Yes, but it’s O(n log n) and more complex.
5. **How do you handle empty arrays?**
   - Throw an exception or return a problem-specific value.

## Tips for Interviews
- **Explain Kadane’s Intuition**: Show how it “resets” for negative sums.
- **Walk Through Example**: Use [-2,1,-3,4,-1,2,1] to demonstrate.
- **Discuss Edge Cases**: Mention all-negative and single-element arrays.
- **Compare Approaches**: Briefly mention brute-force O(n²).