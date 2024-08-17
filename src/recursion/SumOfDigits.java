package recursion;

public class SumOfDigits {

    private static int sumOfDigitsRecursive(int number, int sum) {

        if (number == 0)
            return sum;
        int digit = number % 10;
        int remaining = number / 10;
        sum = sum + digit;
        return sumOfDigitsRecursive(remaining, sum);
    }

    public static void main(String[] args) {
        System.out.println(sumOfDigitsRecursive(123456, 0));
    }
}
