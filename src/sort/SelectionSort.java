package sort;

import java.util.Arrays;

public class SelectionSort {

    private static  void selectionSort(int[] a) {
        int n = a.length;
        for (int i = 0; i < n - 1; i++) {
            int minIdx = i;

            for (int j = i + 1; j < n ; j++) {
                if (a[j] < a[minIdx]) {
                    minIdx = j;
                }
            }

            int temp = a[i];
            a[i] = a[minIdx];
            a[minIdx] = temp;
        }
    }

    private static void printArray(int[] arr) {
        Arrays.stream(arr).forEach(num -> System.out.print(num + " "));
        System.out.println();
    }

    public static void main(String[] args) {


        int [] a = {10,3,24,9,56,30,14,59};
        System.out.println("Before sorting");
        printArray(a);
        selectionSort(a);
        System.out.println("After sorting");
        printArray(a);

    }
}
