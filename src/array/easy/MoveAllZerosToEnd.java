package array.easy;

import java.util.Arrays;

public class MoveAllZerosToEnd {

    private static void moveZeroToEnd(int[] a) {
        int n = a.length;
        int nonZeroIndex = 0;

        // Move all non-zero elements to the front
        for (int i = 0; i < n; i++) {
            if (a[i] != 0) {
                a[nonZeroIndex++] = a[i];
            }
        }

        // Fill remaining positions with zero
        while (nonZeroIndex < n) {
            a[nonZeroIndex++] = 0;
        }
    }

    public static void main(String[] args) {
        int[] arr = {0, 1, 0, 3, 12};
        moveZeroToEnd(arr);
        System.out.println(Arrays.toString(arr)); // [1, 3, 12, 0, 0]
    }
}
