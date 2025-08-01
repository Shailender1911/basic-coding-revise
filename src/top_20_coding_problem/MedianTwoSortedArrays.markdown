# Median of Two Sorted Arrays

## Problem Statement
Given two sorted arrays `nums1` and `nums2` of size `m` and `n` respectively, return the median of the two sorted arrays. The overall run time complexity should be O(log(m+n)).

**Example:**
- **Input:** `nums1 = [1,3], nums2 = [2]`
- **Output:** `2.0`
- **Explanation:** Merged array = `[1,2,3]`, median is `2.0`.
- **Input:** `nums1 = [1,3,5], nums2 = [2,4,6]`
- **Output:** `3.0`
- **Explanation:** Merged array = `[1,2,3,4,5,6]`, median is `(3+4)/2 = 3.0`.

## Approach
The optimal approach uses **binary search** to find the partition point that divides the merged array into two equal halves, ensuring the left half's elements are less than or equal to the right half's elements. This achieves O(log(m+n)) time complexity by leveraging the sorted nature of the arrays.

### Why Binary Search?
- Merging and sorting the arrays takes O(m+n) time, which doesn't meet the required complexity.
- Binary search reduces the problem to finding the correct partition in the smaller array, cutting the search space in half each time.

## Pseudocode
```
1. Ensure nums1 is the shorter array (m <= n) to minimize binary search range.
2. Perform binary search on nums1 to find partition point i (0 <= i <= m):
   a. Compute j = (m + n + 1) / 2 - i for nums2.
   b. Check if partitions are valid:
      - nums1[i-1] <= nums2[j] and nums2[j-1] <= nums1[i].
   c. If valid, compute median based on total length:
      - If (m+n) is odd, median = max(nums1[i-1], nums2[j-1]).
      - If (m+n) is even, median = (max(nums1[i-1], nums2[j-1]) + min(nums1[i], nums2[j])) / 2.
   d. If nums1[i-1] > nums2[j], search left half (high = i-1).
   e. If nums2[j-1] > nums1[i], search right half (low = i+1).
3. Handle edge cases (e.g., empty arrays).
```

## Java Solution
```java
/**
 * Solution for finding the median of two sorted arrays.
 */
public class MedianTwoSortedArrays {

    /**
     * Finds the median of two sorted arrays.
     *
     * @param nums1 First sorted array.
     * @param nums2 Second sorted array.
     * @return Median of the merged sorted arrays.
     * @throws IllegalArgumentException If both arrays are null.
     */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1 == null && nums2 == null) {
            throw new IllegalArgumentException("Both arrays cannot be null.");
        }
        // Ensure nums1 is the shorter array
        if (nums1 != null && nums2 != null && nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }

        int m = nums1 != null ? nums1.length : 0;
        int n = nums2 != null ? nums2.length : 0;

        // Handle single array case
        if (m == 0 && n > 0) {
            return n % 2 == 0 ? (nums2[n/2-1] + nums2[n/2]) / 2.0 : nums2[n/2];
        }

        int low = 0, high = m;
        while (low <= high) {
            int i = (low + high) / 2; // Partition in nums1
            int j = (m + n + 1) / 2 - i; // Partition in nums2

            // Get left and right elements for both arrays
            int nums1Left = (i == 0) ? Integer.MIN_VALUE : nums1[i-1];
            int nums1Right = (i == m) ? Integer.MAX_VALUE : nums1[i];
            int nums2Left = (j == 0) ? Integer.MIN_VALUE : nums2[j-1];
            int nums2Right = (j == n) ? Integer.MAX_VALUE : nums2[j];

            // Check if partition is valid
            if (nums1Left <= nums2Right && nums2Left <= nums1Right) {
                // Compute median
                if ((m + n) % 2 == 0) {
                    return (Math.max(nums1Left, nums2Left) + Math.min(nums1Right, nums2Right)) / 2.0;
                } else {
                    return Math.max(nums1Left, nums2Left);
                }
            } else if (nums1Left > nums2Right) {
                high = i - 1; // Move left
            } else {
                low = i + 1; // Move right
            }
        }

        throw new IllegalArgumentException("Input arrays are not sorted or invalid.");
    }

    public static void main(String[] args) {
        MedianTwoSortedArrays solution = new MedianTwoSortedArrays();
        int[] nums1 = {1, 3};
        int[] nums2 = {2};
        System.out.println("Median: " + solution.findMedianSortedArrays(nums1, nums2)); // 2.0
    }
}
```

## Explanation of the Code
1. **Input Validation**: Checks for null arrays and swaps if `nums1` is longer to optimize binary search.
2. **Binary Search**: Searches for the partition point `i` in the shorter array, computing `j` for the other array.
3. **Partition Check**: Ensures left elements are less than or equal to right elements across arrays.
4. **Median Calculation**: Handles odd and even total lengths differently.
5. **Edge Cases**: Handles empty arrays and single-element arrays.

## Time Complexity (TC)
- **O(log(min(m,n)))**: Binary search on the shorter array.
- Where `m` and `n` are the lengths of the input arrays.

## Space Complexity (SC)
- **O(1)**: Uses only a constant amount of extra space.

## Common Interview Questions
1. **Why is the time complexity O(log(min(m,n))) instead of O(log(m+n))?**
   - We perform binary search on the shorter array, reducing the search space to `min(m,n)`.
2. **Can we solve it in O(m+n) time?**
   - Yes, by merging the arrays and finding the median, but it doesn’t meet the required O(log(m+n)).
3. **How do you handle empty arrays?**
   - If one array is empty, return the median of the other. If both are empty, throw an exception.
4. **What if the arrays aren’t sorted?**
   - The problem assumes sorted arrays. If unsorted, you’d need to sort them first, making it O(n log n).
5. **How do you handle edge cases like single-element arrays?**
   - The code handles them by checking array lengths and using sentinel values (MIN_VALUE, MAX_VALUE).

## Tips for Interviews
- **Explain Binary Search Intuition**: Discuss how partitioning mimics merging without actually merging.
- **Draw Diagrams**: Illustrate partitions for small arrays (e.g., [1,3] and [2]).
- **Clarify Edge Cases**: Mention empty arrays, single-element arrays, and equal-length arrays.
- **Practice Explaining**: The binary search logic can be tricky to articulate clearly.