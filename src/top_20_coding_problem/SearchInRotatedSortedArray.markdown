# Search in Rotated Sorted Array

## Problem Statement
Given an array `nums` after possible rotation and an integer `target`, return the index of `target` if it is in `nums`, or `-1` if it is not. You must write an algorithm with O(log n) runtime complexity.

**Example:**
- **Input:** `nums = [4,5,6,7,0,1,2], target = 0`
- **Output:** `4`
- **Input:** `nums = [4,5,6,7,0,1,2], target = 3`
- **Output:** `-1`

## Approach
The optimal approach uses **binary search** modified to handle rotation. By identifying the sorted half of the array, we determine if the target lies in that half and adjust the search range, achieving O(log n) time.

### Why Binary Search?
- The array is originally sorted, so even after rotation, one half is always sorted.
- Binary search maintains O(log n) complexity by halving the search space.

## Pseudocode
```
1. Initialize left = 0, right = n-1.
2. While left <= right:
   a. Compute mid = (left + right) / 2.
   b. If nums[mid] == target, return mid.
   c. If nums[left] <= nums[mid] (left half is sorted):
      - If nums[left] <= target < nums[mid], search left (right = mid-1).
      - Else, search right (left = mid+1).
   d. Else (right half is sorted):
      - If nums[mid] < target <= nums[right], search right (left = mid+1).
      - Else, search left (right = mid-1).
3. Return -1.
```

## Java Solution
```java
/**
 * Solution for the Search in Rotated Sorted Array problem.
 */
public class SearchInRotatedSortedArray {

    /**
     * Searches for a target in a rotated sorted array.
     *
     * @param nums   Rotated sorted array of integers.
     * @param target Target value to find.
     * @return Index of target, or -1 if not found.
     * @throws IllegalArgumentException If nums is null.
     */
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }

        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2; // Avoid overflow
            if (nums[mid] == target) {
                return mid;
            }

            if (nums[left] <= nums[mid]) { // Left half is sorted
                if (nums[left] <= target && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else { // Right half is sorted
                if (nums[mid] < target && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        SearchInRotatedSortedArray solution = new SearchInRotatedSortedArray();
        int[] nums = {4, 5, 6, 7, 0, 1, 2};
        int target = 0;
        System.out.println("Index: " + solution.search(nums, target)); // 4
    }
}
```

## Explanation of the Code
1. **Input Validation**: Checks for null or empty array.
2. **Binary Search**: Uses `left`, `right`, and `mid` to narrow the search.
3. **Sorted Half Check**: Determines which half is sorted using `nums[left] <= nums[mid]`.
4. **Target Range**: Adjusts `left` or `right` based on target’s position.
5. **Edge Cases**: Handles single-element arrays and no rotation.

## Time Complexity (TC)
- **O(log n)**: Binary search halves the search space each iteration.
- Where `n` is the length of the input array.

## Space Complexity (SC)
- **O(1)**: Uses only a few variables.

## Common Interview Questions
1. **What if the array isn’t rotated?**
   - The algorithm works as standard binary search.
2. **What if duplicates exist?**
   - Duplicates complicate the sorted half check, requiring a different approach (O(n) worst case).
3. **Can we use linear search?**
   - Yes, but it’s O(n), failing the O(log n) requirement.
4. **How do you handle single-element arrays?**
   - Check if the element is the target, as handled by the code.
5. **What if the target is at the pivot?**
   - The binary search finds it correctly, e.g., `target = 0` in `[4,5,6,7,0,1,2]`.

## Tips for Interviews
- **Explain Sorted Half**: Use [4,5,6,7,0,1,2] to show how one half is sorted.
- **Draw Array**: Illustrate pivot and search range reduction.
- **Discuss Edge Cases**: Mention no rotation, single element, and duplicates.
- **Clarify Complexity**: Emphasize O(log n) requirement.