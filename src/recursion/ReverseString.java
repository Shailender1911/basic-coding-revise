package recursion;

public class ReverseString {

    private static String reverse(String str, int length) {
        // Base case: When length is 0, return an empty string
        if (length == 0) {
            return "";
        }

        // Recursive call: Take the last character (str[length - 1])
        // and append the result of the recursive function called on the remaining string
        return str.charAt(length - 1) + reverse(str, length - 1);
    }

    public static void main(String[] args) {
        String input = "hello";
        System.out.println(reverse(input, input.length())); // Output: olleh
    }
}
