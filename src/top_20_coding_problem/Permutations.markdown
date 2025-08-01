# Permutations

## Problem Statement
Given an array `nums` of distinct integers, return all the possible permutations. You can return the answer in any order.

**Example:**
- **Input:** `nums = [1,2,3]`
- **Output:** `[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]`

## Approach
The optimal approach uses **backtracking** to generate all permutations by swapping elements or building permutations incrementally. This is intuitive and efficient for generating all possible arrangements.

### Why Backtracking?
- Systematically explores all possibilities while avoiding redundant work.
- Naturally handles the requirement to generate all permutations.

## Pseudocode
```
1. Initialize result list to store permutations.
2. Define backtrack function:
   a. If current permutation size equals array length, add to result.
   b. For each number in nums:
      - If number not used:
        - Add number to current permutation.
        - Mark number as used.
        - Recurse.
        - Remove number and unmark.
3. Call backtrack and return result.
```

## Java Solution
```java
import java.util.ArrayList;
import java.util.List;

/**
 * Solution for the Permutations problem.
 */
public class Permutations {

    /**
     * Generates all possible permutations of the input array.
     *
     * @param nums Array of distinct integers.
     * @return List of all permutations.
     * @throws IllegalArgumentException If nums is null.
     */
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null) {
            return result;
        }

        backtrack(nums, new ArrayList<>(), result, new boolean[nums.length]);
        return result;
    }

    private void backtrack(int[] nums, List<Integer> current, List<List<Integer>> result, boolean[] used) {
        if (current.size() == nums.length) {
            result.add(new ArrayList<>(current));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (!used[i]) {
                current.add(nums[i]);
                used[i] = true;
                backtrack(nums, current, result, used);
                current.remove(current.size() - 1);
                used[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        Permutations solution = new Permutations();
        int[] nums = {1, 2, 3};
        System.out.println("Permutations: " + solution.permute(nums));
    }
}
```

## Explanation of the Code
1. **Backtracking**: Builds permutations by adding one number at a time.
2. **Used Array**: Tracks which numbers are in the current permutation.
3. **Base Case**: Adds a copy of the current permutation when it reaches the array length.
4. **Recursive Calls**: Tries each unused number, backtracks by removing it.
5. **Result Collection**: Stores all valid permutations.

## Time Complexity (TC)
- **O(n!)**: Generates all n! permutations.
- Where `n` is the length of the input array.

## Space Complexity (SC)
- **O(n)**: Recursion stack depth and auxiliary space for `current` and `used` arrays.

## Common Interview Questions
1. **What if numbers are not distinct?**
   - Modify the approach to handle duplicates by sorting and skipping identical elements (Permutations II).
2. **Can we optimize further?**
   - Generating all permutations is inherently O(n!), so this is optimal.
3. **How do you handle large arrays?**
   - For large n, the output size (n!) becomes impractical, so clarify constraints.
4. **What if we need k-length permutations?**
   - Modify the base case to stop when the permutation size is k.
5. **Why use backtracking?**
   - It’s systematic and avoids generating invalid permutations.

## Tips for Interviews
- **Explain Backtracking Clearly**: Walk through a small example like `[1,2]`.
- **Discuss Space Usage**: Mention recursion stack and auxiliary arrays.
- **Handle Edge Cases**: Discuss empty arrays or single-element arrays.
- **Practice Variations**: Be ready for Permutations II or k-length permutations.