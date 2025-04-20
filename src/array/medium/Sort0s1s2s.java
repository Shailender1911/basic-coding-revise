package array.medium;

import java.util.Arrays;

public class Sort0s1s2s {

    private void sort0To2(int[] a) {
        int low = 0, mid = 0, high = a.length - 1;

        while (mid <= high) {
            if (a[mid] == 0) {
                // Swap a[low] and a[mid], then increment low and mid
                swap(a, low, mid);
                low++;
                mid++;
            } else if (a[mid] == 1) {
                // Move mid pointer
                mid++;
            } else {
                // Swap a[mid] and a[high], then decrement high
                swap(a, mid, high);
                high--;
            }
        }
    }

    private void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static void main(String[] args) {
        int a[] = {2, 0, 1, 0, 2, 1, 0, 1, 0, 2, 1};
        System.out.println("Before sorting: " + Arrays.toString(a));

        Sort0s1s2s obj = new Sort0s1s2s();
        obj.sort0To2(a);

        System.out.println("After sorting: " + Arrays.toString(a));
    }
}








