# Product of Array Except Self

## Problem Statement
Given an integer array `nums`, return an array `answer` such that `answer[i]` is equal to the product of all the elements of `nums` except `nums[i]`. The product of any prefix or suffix of `nums` is guaranteed to fit in a 32-bit integer. You must write an algorithm that runs in O(n) time and without using the division operation.

**Example:**
- **Input:** `nums = [1,2,3,4]`
- **Output:** `[24,12,8,6]`
- **Explanation:** `answer[0] = 2*3*4 = 24`, `answer[1] = 1*3*4 = 12`, etc.

## Approach
The optimal approach uses **two passes** to compute the product of all elements to the left and right of each index without division. First, compute left products, then multiply by right products in a second pass, achieving O(n) time and O(1) space (excluding output).

### Why Two Passes?
- Avoids division, which could cause issues with zeros.
- Uses the output array to store intermediate results, minimizing space.

## Pseudocode
```
1. Initialize answer array with 1s.
2. First pass (left to right):
   a. For each i, answer[i] = product of all elements to the left of i.
3. Second pass (right to left):
   a. Maintain rightProduct = 1.
   b. For each i, answer[i] *= rightProduct; update rightProduct *= nums[i].
4. Return answer.
```

## Java Solution
```java
/**
 * Solution for the Product of Array Except Self problem.
 */
public class ProductOfArrayExceptSelf {

    /**
     * Computes the product of all elements except self for each index.
     *
     * @param nums Input array of integers.
     * @return Array where each element is the product of all others.
     * @throws IllegalArgumentException If nums is null or empty.
     */
    public int[] productExceptSelf(int[] nums) {
        if (nums == null || nums.length == 0) {
            throw new IllegalArgumentException("Array cannot be null or empty.");
        }

        int n = nums.length;
        int[] answer = new int[n];

        // First pass: Compute left products
        answer[0] = 1;
        for (int i = 1; i < n; i++) {
            answer[i] = answer[i - 1] * nums[i - 1];
        }

        // Second pass: Multiply by right products
        int rightProduct = 1;
        for (int i = n - 1; i >= 0; i--) {
            answer[i] *= rightProduct;
            rightProduct *= nums[i];
        }

        return answer;
    }

    public static void main(String[] args) {
        ProductOfArrayExceptSelf solution = new ProductOfArrayExceptSelf();
        int[] nums = {1, 2, 3, 4};
        int[] result = solution.productExceptSelf(nums);
        System.out.print("Result: ");
        for (int num : result) {
            System.out.print(num + " ");
        } // 24 12 8 6
    }
}
```

## Explanation of the Code
1. **Input Validation**: Checks for null or empty array.
2. **First Pass**: `answer[i]` stores the product of all elements to the left of `i`.
3. **Second Pass**: Multiplies each `answer[i]` by the product of all elements to the right, updating `rightProduct`.
4. **Edge Cases**: Handles arrays of length 2 or more naturally.
5. **No Division**: Uses only multiplication to compute products.

## Time Complexity (TC)
- **O(n)**: Two passes through the array.
- Where `n` is the length of the input array.

## Space Complexity (SC)
- **O(1)**: Uses only the output array and a single variable (excluding output).

## Common Interview Questions
1. **Why avoid division?**
   - Division can cause issues with zeros and requires handling edge cases separately.
2. **What if the array has zeros?**
   - The two-pass approach works regardless of zeros, as it computes products directly.
3. **Can we use extra space?**
   - Yes, with two arrays for left and right products, but O(1) is optimal.
4. **What if the product overflows?**
   - The problem guarantees products fit in a 32-bit integer.
5. **How do you handle an array of length 2?**
   - The solution works by swapping the two elements’ values.

## Tips for Interviews
- **Explain Intuition**: Use [1,2,3,4] to show how left and right products combine.
- **Draw Arrays**: Illustrate the two passes with arrows.
- **Discuss Edge Cases**: Mention arrays with zeros or length 2.
- **Highlight O(1) Space**: Emphasize the clever use of the output array.