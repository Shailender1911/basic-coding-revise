package array.medium;

import java.util.Arrays;

public class RotateArrayByKSteps {

    private void rotateArray(int[] arr, int k) {
        int n = arr.length;
        k = k % n;
        reverse(arr, 0, n - 1);
        reverse(arr, 0, k - 1);
        reverse(arr, k, n - 1);
    }

    private void reverse(int a[], int start, int end) {
        while (start < end) {
            int temp = a[start];
            a[start] = a[end];
            a[end] = temp;
            start++;
            end--;
        }
    }

    public static void main(String[] args) {

        int a[] = {1, 3, 5, 6};
        RotateArrayByKSteps obj = new RotateArrayByKSteps();
        obj.rotateArray(a, 2);

        System.out.println(Arrays.toString(a));

    }
}
