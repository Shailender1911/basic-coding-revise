package array.medium;

import java.util.Arrays;

public class MergeTwoSortedArray {

    private void mergeTwoSortedArrays(int num1[], int num2[]) {
        int i = 0, j = 0;

        // Traverse through num1 and num2 until the end of num1 or num2
        while (i < num1.length && j < num2.length) {
            if (num1[i] > num2[j]) {
                // Swap num1[i] and num2[j]
                int temp = num1[i];
                num1[i] = num2[j];
                num2[j] = temp;
                // Now, to maintain sorted order in num2, sort the second array
                Arrays.sort(num2);
            }
            i++;
        }

        // Print the merged arrays
        System.out.println("Array 1 after merge: " + Arrays.toString(num1));
        System.out.println("Array 2 after merge: " + Arrays.toString(num2));
    }

    public static void main(String[] args) {
        int num1[] = {1, 5, 9, 10};
        int num2[] = {2, 3, 8, 11};

        MergeTwoSortedArray obj = new MergeTwoSortedArray();
        obj.mergeTwoSortedArrays(num1, num2);
    }
}
