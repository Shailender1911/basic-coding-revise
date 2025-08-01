# Longest Substring Without Repeating Characters

## Problem Statement
Given a string `s`, find the length of the longest substring without repeating characters.

**Example:**
- **Input:** `s = "abcabcbb"`
- **Output:** `3`
- **Explanation:** The answer is `"abc"`, with a length of 3.

## Approach
The optimal approach uses a **sliding window** with a **HashMap** to track the last seen index of each character. This allows us to efficiently adjust the window when a repeat is found, achieving O(n) time complexity.

### Why Sliding Window?
- Avoids checking all possible substrings (O(n²)).
- HashMap enables O(1) lookups to detect repeats and update the window.

## Pseudocode
```
1. Initialize HashMap to store character-to-last-index mappings.
2. Initialize left = 0, maxLength = 0.
3. Iterate right from 0 to n-1:
   a. If s[right] is in HashMap and its index >= left:
      - Update left to HashMap[s[right]] + 1.
   b. Update HashMap with s[right] = right.
   c. Update maxLength = max(maxLength, right - left + 1).
4. Return maxLength.
```

## Java Solution
```java
import java.util.HashMap;
import java.util.Map;

/**
 * Solution for the Longest Substring Without Repeating Characters problem.
 */
public class LongestSubstringWithoutRepeatingCharacters {

    /**
     * Finds the length of the longest substring without repeating characters.
     *
     * @param s Input string.
     * @return Length of the longest substring.
     */
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }

        Map<Character, Integer> charToIndex = new HashMap<>();
        int left = 0, maxLength = 0;

        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            if (charToIndex.containsKey(c) && charToIndex.get(c) >= left) {
                left = charToIndex.get(c) + 1;
            }
            charToIndex.put(c, right);
            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }

    public static void main(String[] args) {
        LongestSubstringWithoutRepeatingCharacters solution = new LongestSubstringWithoutRepeatingCharacters();
        String s = "abcabcbb";
        System.out.println("Length: " + solution.lengthOfLongestSubstring(s)); // 3
    }
}
```

## Explanation of the Code
1. **Sliding Window**: `left` and `right` define the current substring.
2. **HashMap**: Stores the last index of each character.
3. **Window Adjustment**: Moves `left` past the last occurrence of a repeated character.
4. **Max Length Update**: Tracks the longest valid substring.
5. **Edge Cases**: Handles null or empty strings.

## Time Complexity (TC)
- **O(n)**: Single pass through the string with O(1) HashMap operations.
- Where `n` is the length of the input string.

## Space Complexity (SC)
- **O(min(n,m))**: HashMap stores at most `min(n,m)` characters, where `m` is the character set size (e.g., 256 for ASCII).

## Common Interview Questions
1. **What if we need the substring itself?**
   - Track the start and end indices of the max substring and return `s.substring(start, end+1)`.
2. **Can we solve it without extra space?**
   - Brute force (O(n²)) checks all substrings, but it’s inefficient.
3. **How do you handle Unicode characters?**
   - The HashMap approach works for any character set, with space depending on the character set size.
4. **What if the string is very long?**
   - The O(n) approach is efficient, but discuss memory constraints for large character sets.
5. **What if all characters are unique?**
   - The entire string is the answer, returned as `s.length()`.

## Tips for Interviews
- **Explain Sliding Window**: Show how the window shrinks and grows.
- **Walk Through Example**: Use “abcabcbb” to demonstrate pointer movement.
- **Discuss Edge Cases**: Mention empty strings, single characters, and all repeats.
- **Optimize Explanation**: Highlight why HashMap is better than a Set.