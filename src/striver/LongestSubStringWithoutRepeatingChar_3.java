package striver;

import java.util.HashSet;
import java.util.Set;

class LongestSubStringWithoutRepeatingChar_3 {
    public int lengthOfLongestSubstring(String s) {
        int left =0;

        int maxLength = 0;

        Set<Character> charSet = new HashSet<>();
        for(int right =0;right<s.length();right++)
        {
            while(charSet.contains(s.charAt(right)))
             {
                charSet.remove(s.charAt(left));
                left++;
            }

            charSet.add(s.charAt(right));
            maxLength = Math.max(maxLength, right-left+1);
        }

        return maxLength;
    }

    public static void main(String[] args) {
        LongestSubStringWithoutRepeatingChar_3 obj = new LongestSubStringWithoutRepeatingChar_3();
        String s = "abcabcbb";
        int result = obj.lengthOfLongestSubstring(s);
        System.out.println("Length of the longest substring without repeating characters: " + result); // Output: 3
        // add 3 more examples
        String s1 = "aabcdefqaabcdefaapqrsatu";
        int result1 = obj.lengthOfLongestSubstring(s1);
        System.out.println("Length of the longest substring without repeating characters: " + result1); // Output: 1
        String s2 = "pwwkew";
        int result2 = obj.lengthOfLongestSubstring(s2);
        System.out.println("Length of the longest substring without repeating characters: " + result2); // Output: 3

    }
}