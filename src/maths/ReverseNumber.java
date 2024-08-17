package maths;

public class ReverseNumber {

    public static int reverseNumber(int number) {
        int reverseNumber = 0;
        while (number > 0) {
            int lastDigit;
            lastDigit = number % 10;
            number = number / 10;
            reverseNumber = (reverseNumber * 10) + lastDigit;

        }
        return reverseNumber;
    }

    public static void main(String[] args) {
        int number = 9876;
        System.out.printf("Reverse of Number %d :  is : %d", number, reverseNumber(number));
    }
}
