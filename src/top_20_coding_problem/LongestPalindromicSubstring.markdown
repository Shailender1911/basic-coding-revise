# Longest Palindromic Substring

## Problem Statement
Given a string `s`, return the longest palindromic substring in `s`.

**Example:**
- **Input:** `s = "babad"`
- **Output:** `"bab"`
- **Explanation:** `"aba"` is also valid.
- **Input:** `s = "cbbd"`
- **Output:** `"bb"`

## Approach
The optimal approach uses the **expand around center** method, checking for palindromes by expanding from each possible center (both odd and even lengths). This achieves O(n²) time and O(1) space.

### Why Expand Around Center?
- Avoids dynamic programming’s O(n²) space.
- Simple and intuitive for finding palindromes.

## Pseudocode
```
1. Initialize start = 0, maxLength = 0.
2. For each i from 0 to n-1:
   a. Expand around i for odd-length palindrome (left = i, right = i).
   b. Expand around i,i+1 for even-length palindrome (left = i, right = i+1).
   c. Update start and maxLength if a longer palindrome is found.
3. Return s.substring(start, start + maxLength).
```

## Java Solution
```java
/**
 * Solution for the Longest Palindromic Substring problem.
 */
public class LongestPalindromicSubstring {

    /**
     * Finds the longest palindromic substring in the input string.
     *
     * @param s Input string.
     * @return Longest palindromic substring.
     */
    public String longestPalindrome(String s) {
        if (s == null || s.isEmpty()) {
            return "";
        }

        int start = 0, maxLength = 0;
        for (int i = 0; i < s.length(); i++) {
            // Odd-length palindrome
            int len1 = expandAroundCenter(s, i, i);
            // Even-length palindrome
            int len2 = expandAroundCenter(s, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > maxLength) {
                maxLength = len;
                start = i - (len - 1) / 2;
            }
        }

        return s.substring(start, start + maxLength);
    }

    private int expandAroundCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1; // Length of palindrome
    }

    public static void main(String[] args) {
        LongestPalindromicSubstring solution = new LongestPalindromicSubstring();
        String s = "babad";
        System.out.println("Longest Palindrome: " + solution.longestPalindrome(s)); // bab
    }
}
```

## Explanation of the Code
1. **Input Validation**: Returns empty string for null or empty input.
2. **Center Expansion**: Checks odd (i,i) and even (i,i+1) palindromes.
3. **Length Tracking**: Updates `start` and `maxLength` for the longest palindrome.
4. **Substring Extraction**: Returns the palindrome using computed indices.
5. **Edge Cases**: Handles single characters and empty strings.

## Time Complexity (TC)
- **O(n²)**: Each of n centers may expand up to O(n).
- Where `n` is the length of the input string.

## Space Complexity (SC)
- **O(1)**: Uses only a few variables.

## Common Interview Questions
1. **Can we use dynamic programming?**
   - Yes, but it’s O(n²) time and space, less efficient in space.
2. **What if multiple palindromes have the same length?**
   - Return any, as implemented (first found).
3. **How do you handle empty strings?**
   - Return "", as implemented.
4. **Can we optimize further?**
   - Manacher’s algorithm is O(n), but complex for interviews.
5. **What if we need the count of palindromes?**
   - Modify to track all palindromes during expansion.

## Tips for Interviews
- **Explain Center Expansion**: Use “babad” to show odd and even checks.
- **Draw String**: Illustrate expansion with pointers.
- **Discuss Edge Cases**: Mention single characters and no palindromes.
- **Mention Manacher’s**: Briefly note it for advanced knowledge.