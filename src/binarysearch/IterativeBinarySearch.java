package binarysearch;

public class IterativeBinarySearch {

    private static int binarySearch(int[] arr, int k, int size) {
        int left = 0;
        int right = size - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == k) {
                return mid;
            }

            if (arr[mid] < k) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] a = {10, 20, 30, 50, 60};
        int size = a.length;
        System.out.println(binarySearch(a, 200, size));  // Output should be -1 since 200 is not in the array
        System.out.println(binarySearch(a, 50, size));   // Output should be 3 since 50 is at index 3
    }
}
