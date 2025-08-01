# Longest Common Prefix

## Problem Statement
Write a function to find the longest common prefix string amongst an array of strings. If there is no common prefix, return an empty string `""`.

**Example:**
- **Input:** `strs = ["dog","racecar","car"]`
- **Output:** `""`
- **Explanation:** There is no common prefix among the input strings.

## Approach
The optimal approach compares characters of all strings by taking the first string as a reference and checking against others, stopping when a mismatch occurs. This is simple and achieves O(S) time, where S is the total number of characters.

### Why Use First String?
- Simplifies the logic by reducing comparisons.
- Early termination minimizes unnecessary checks.

## Pseudocode
```
1. If strs is null or empty, return "".
2. If strs has one string, return that string.
3. Take first string as prefix.
4. For each string in strs[1...n-1]:
   a. While prefix length > 0 and string doesn't start with prefix:
      - Reduce prefix by one character.
   b. If prefix is empty, return "".
5. Return prefix.
```

## Java Solution
```java
/**
 * Solution for the Longest Common Prefix problem.
 */
public class LongestCommonPrefix {

    /**
     * Finds the longest common prefix among an array of strings.
     *
     * @param strs Array of strings.
     * @return Longest common prefix.
     */
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        if (strs.length == 1) {
            return strs[0] == null ? "" : strs[0];
        }

        String prefix = strs[0];
        if (prefix == null) {
            return "";
        }

        for (int i = 1; i < strs.length; i++) {
            if (strs[i] == null) {
                return "";
            }
            while (prefix.length() > 0 && !strs[i].startsWith(prefix)) {
                prefix = prefix.substring(0, prefix.length() - 1);
            }
            if (prefix.isEmpty()) {
                return "";
            }
        }

        return prefix;
    }

    public static void main(String[] args) {
        LongestCommonPrefix solution = new LongestCommonPrefix();
        String[] strs = {"dog", "racecar", "car"};
        System.out.println("Prefix: \"" + solution.longestCommonPrefix(strs) + "\"");
    }
}
```

## Explanation of the Code
1. **Input Validation**: Handles null array, empty array, or null strings.
2. **Single String Case**: Returns the only string (or "" if null).
3. **Prefix Reduction**: Starts with the first string and shortens it until it matches all others.
4. **Early Termination**: Returns "" if prefix becomes empty.
5. **Efficiency**: Uses `startsWith` for clean comparison.

## Time Complexity (TC)
- **O(S)**: Where `S` is the total number of characters in all strings. In the worst case, we compare each character of the prefix against each string.
- Typically, `S = n * m`, where `n` is the number of strings and `m` is the average string length.

## Space Complexity (SC)
- **O(1)**: Only uses a constant amount of extra space (excluding input).

## Common Interview Questions
1. **Can we solve it by comparing characters directly?**
   - Yes, iterate through characters of the shortest string and compare across all strings.
2. **What if strings are very long?**
   - The approach is efficient as it stops at the first mismatch.
3. **How do you handle null strings?**
   - Return "" if any string is null, as implemented.
4. **What if all strings are identical?**
   - Return the first string, as it’s the common prefix.
5. **Can we use a trie?**
   - Yes, but it’s overkill for this problem, adding complexity and space.

## Tips for Interviews
- **Simplify Explanation**: Use the first-string approach for clarity.
- **Test with Examples**: Walk through `["flower","flow","flight"]` (output: `"fl"`).
- **Discuss Edge Cases**: Mention empty arrays, single strings, and null inputs.
- **Compare Approaches**: Briefly mention character-by-character or trie-based solutions.