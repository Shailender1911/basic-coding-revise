# Trapping Rain Water

## Problem Statement
Given `n` non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it can trap after rain.

**Example:**
- **Input:** `height = [0,0,2,1,0,1,3,2,2,1]`
- **Output:** `6`
- **Explanation:** The elevation map traps 6 units of water.

## Approach
The optimal approach uses **two pointers** to traverse the array from both ends, keeping track of the maximum heights on the left and right. Water trapped at a position depends on the minimum of the left and right maxima minus the height at that position. This achieves O(n) time complexity with O(1) space.

### Why Two Pointers?
- Computing max left and right for each position using arrays takes O(n) space.
- Two pointers reduce space to O(1) by processing the array in one pass.

## Pseudocode
```
1. Initialize left = 0, right = n-1, leftMax = 0, rightMax = 0, water = 0.
2. While left < right:
   a. If leftMax <= rightMax:
      - Update leftMax = max(leftMax, height[left]).
      - Add water += leftMax - height[left].
      - Move left pointer right.
   b. Else:
      - Update rightMax = max(rightMax, height[right]).
      - Add water += rightMax - height[right].
      - Move right pointer left.
3. Return water.
```

## Java Solution
```java
/**
 * Solution for the Trapping Rain Water problem.
 */
public class TrappingRainWater {

    /**
     * Computes the amount of water trapped in the elevation map.
     *
     * @param height Array of non-negative integers representing heights.
     * @return Total units of water trapped.
     * @throws IllegalArgumentException If height is null.
     */
    public int trap(int[] height) {
        if (height == null || height.length < 3) {
            return 0; // No water can be trapped
        }

        int left = 0, right = height.length - 1;
        int leftMax = 0, rightMax = 0;
        int water = 0;

        while (left < right) {
            if (leftMax <= rightMax) {
                leftMax = Math.max(leftMax, height[left]);
                water += leftMax - height[left];
                left++;
            } else {
                rightMax = Math.max(rightMax, height[right]);
                water += rightMax - height[right];
                right--;
            }
        }

        return water;
    }

    public static void main(String[] args) {
        TrappingRainWater solution = new TrappingRainWater();
        int[] height = {0, 0, 2, 1, 0, 1, 3, 2, 2, 1};
        System.out.println("Water trapped: " + solution.trap(height)); // 6
    }
}
```

## Explanation of the Code
1. **Input Validation**: Returns 0 for null or arrays with fewer than 3 elements.
2. **Two Pointers**: `left` and `right` start at the ends, moving inward based on the smaller of `leftMax` or `rightMax`.
3. **Water Calculation**: Adds `leftMax - height[left]` or `rightMax - height[right]` to the total water.
4. **Max Updates**: Updates `leftMax` or `rightMax` as pointers move.

## Time Complexity (TC)
- **O(n)**: Single pass through the array with two pointers.
- Where `n` is the length of the input array.

## Space Complexity (SC)
- **O(1)**: Uses only a constant amount of extra space.

## Common Interview Questions
1. **Can we solve it with O(n) space?**
   - Yes, by precomputing max left and right arrays, but the two-pointer approach is more space-efficient.
2. **What if all heights are equal?**
   - No water can be trapped, as there are no boundaries to hold water.
3. **How do negative heights affect the solution?**
   - The problem assumes non-negative heights. Negative heights would require adjusting the logic to consider a baseline.
4. **Why process the smaller max first?**
   - It ensures we’re always computing water based on the limiting boundary, avoiding incorrect calculations.
5. **What if the array is empty or has one element?**
   - No water can be trapped, so return 0.

## Tips for Interviews
- **Visualize with Diagrams**: Draw the elevation map and show how water is trapped.
- **Explain Pointer Movement**: Clarify why we move the pointer with the smaller max.
- **Discuss Trade-offs**: Mention the O(n) space approach before presenting the O(1) solution.
- **Handle Edge Cases**: Discuss empty arrays, flat arrays, and single peaks.