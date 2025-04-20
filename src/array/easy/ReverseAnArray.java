package array.easy;

import java.util.Arrays;

public class ReverseAnArray {

    private void reverseArray(int a[]) {

        reverseUsingTwoPointers(a, 0, a.length - 1);

    }

    private void reverseUsingTwoPointers(int a[], int start, int end) {
        while (start < end) {
            int temp = a[start];
            a[start] = a[end];
            a[end] = temp;
            start++;
            end--;

        }
    }

    public static void main(String[] args) {
        int a[] = {1, 2, 3, 4, 5};
        System.out.println("Array Before revers - " + Arrays.toString(a));
        ReverseAnArray obj = new ReverseAnArray();
        obj.reverseArray(a);
        System.out.println("After reverse : " + Arrays.toString(a));

    }
}
