package src.maths;

public class ArmstrongNumber {

    private static boolean isArmstrongNumber(int number) {
        int result = 0;
        int temp = number;
        while (number > 0) {
            int digit = number % 10;
            result = result + (digit * digit * digit);
            number = number / 10;
        }
        return result == temp;
    }

    public static void main(String[] args) {
        int number =371;
        System.out.printf("The number %d is Armstrong  Number:  %b:",number,isArmstrongNumber(number));
    }
}
