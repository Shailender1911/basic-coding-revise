package maths;

public class PalindromeNumber {

    private static boolean isAPalindromeNumber(int number) {
        int reversedNumber = ReverseNumber.reverseNumber(number);
        return number == reversedNumber;
    }

    public static void main(String[] args) {
        int number = 123;
        System.out.printf("Is the number %d  is palindrome : %b", number, isAPalindromeNumber(number));
    }
}
