package maths;

public class CountDigit {
    private static int countDigit(int digit) {
        int count = 0;
        while (digit > 0) {
            count =count+1;
            digit = digit /10;
        }
        return  count;
    }

    public static void main(String[] args) {
        int n = 12345;
        System.out.printf("Count of digit for numers %d is : %d", n, countDigit(n));
    }
}
