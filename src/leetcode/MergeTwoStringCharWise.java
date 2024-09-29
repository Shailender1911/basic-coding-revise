package leetcode;

public class MergeTwoStringCharWise {
    public static void main(String[] args) {
        String str1 = "Hello";
        String str2 = "World";

        // Merging two strings
        String mergedString = mergeStrings(str1, str2);

        System.out.println("Merged String: " + mergedString);
    }

    public static String mergeStrings(String s1, String s2) {
        StringBuilder merged = new StringBuilder();
        int length1 = s1.length();
        int length2 = s2.length();
        int maxLength = Math.max(length1, length2);

        // Merging characters from both strings alternately
        for (int i = 0; i < maxLength; i++) {
            if (i < length1) {
                merged.append(s1.charAt(i));
            }
            if (i < length2) {
                merged.append(s2.charAt(i));
            }
        }
        return merged.toString();
    }
}
