# 3Sum

## Problem Statement
Given an integer array `nums`, return all the triplets `[nums[i], nums[j], nums[k]]` such that `i != j`, `j != k`, `i != k`, and `nums[i] + nums[j] + nums[k] == 0`. The solution set must not contain duplicate triplets.

**Example:**
- **Input:** `nums = [-1,0,1,2,-1,-4]`
- **Output:** `[[-1,-1,2],[-1,0,1]]`
- **Explanation:** The triplets sum to 0, and no duplicates are included.

## Approach
The optimal approach involves **sorting the array** and using a **two-pointer technique** to find triplets. Sorting allows us to skip duplicates and use pointers efficiently, achieving O(n²) time complexity.

### Why Sorting and Two Pointers?
- Sorting enables easy duplicate handling and efficient searching for the third element.
- Two pointers reduce the inner loop to O(n), compared to O(n²) for a brute-force approach.

## Pseudocode
```
1. Sort the array.
2. Iterate i from 0 to n-3:
   a. If i > 0 and nums[i] == nums[i-1], skip to avoid duplicates.
   b. Set left = i+1, right = n-1.
   c. While left < right:
      - If nums[i] + nums[left] + nums[right] == 0:
        - Add triplet [nums[i], nums[left], nums[right]] to result.
        - Skip duplicates for left and right.
        - Move left right, right left.
      - If sum < 0, move left right.
      - If sum > 0, move right left.
3. Return result.
```

## Java Solution
```java
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Solution for the 3Sum problem.
 */
public class ThreeSum {

    /**
     * Finds all unique triplets that sum to zero.
     *
     * @param nums Array of integers.
     * @return List of triplets summing to zero.
     * @throws IllegalArgumentException If nums is null.
     */
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length < 3) {
            return result;
        }

        Arrays.sort(nums); // Sort for duplicate handling
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue; // Skip duplicates
            }

            int left = i + 1, right = nums.length - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == 0) {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    while (left < right && nums[left] == nums[left + 1]) left++; // Skip duplicates
                    while (left < right && nums[right] == nums[right - 1]) right--; // Skip duplicates
                    left++;
                    right--;
                } else if (sum < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        ThreeSum solution = new ThreeSum();
        int[] nums = {-1, 0, 1, 2, -1, -4};
        System.out.println("Triplets: " + solution.threeSum(nums));
    }
}
```

## Explanation of the Code
1. **Sorting**: Enables duplicate skipping and efficient pointer movement.
2. **Outer Loop**: Iterates for the first element, skipping duplicates.
3. **Two Pointers**: `left` and `right` find the other two elements, adjusting based on the sum.
4. **Duplicate Handling**: Skips identical elements to ensure unique triplets.
5. **Result Collection**: Stores valid triplets in a list.

## Time Complexity (TC)
- **O(n²)**: Sorting takes O(n log n), and the two-pointer loop takes O(n²).
- Where `n` is the length of the input array.

## Space Complexity (SC)
- **O(1)** (excluding output): Only uses a constant amount of extra space (ignoring sorting space, which depends on the implementation).

## Common Interview Questions
1. **How do you avoid duplicates?**
   - Sorting and skipping identical elements in the outer loop and inner pointers.
2. **Can we solve it without sorting?**
   - Yes, using a HashMap, but it’s more complex and still O(n²) with higher space usage.
3. **What if we need quadruplets?**
   - Extend the approach with another loop, making it O(n³).
4. **What if no triplets exist?**
   - Return an empty list, as handled by the code.
5. **How do you handle large arrays?**
   - The O(n²) approach is generally acceptable, but discuss early termination if `nums[i] > 0`.

## Tips for Interviews
- **Explain Duplicate Handling**: Emphasize sorting and skipping logic.
- **Discuss Trade-offs**: Mention brute-force O(n³) vs. two-pointer approach.
- **Test with Examples**: Walk through a small array like `[-1,0,1]`.
- **Clarify Constraints**: Ask about array size, duplicates, and negative numbers.