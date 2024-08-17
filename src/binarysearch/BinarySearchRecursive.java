package binarysearch;

public class BinarySearchRecursive {

    private static int binarySearchRecursive(int[] a, int k, int left, int right) {
        // Base case: If the range is invalid, return -1
        if (left > right) {
            return -1;
        }

        int mid = left + (right - left) / 2;

        // Check if the middle element is the target
        if (a[mid] == k) {
            return mid;
        }

        // Recur on the right half if the middle element is less than the target
        if (a[mid] < k) {
            return binarySearchRecursive(a, k, mid + 1, right);
        }

        // Recur on the left half if the middle element is greater than the target
        return binarySearchRecursive(a, k, left, mid - 1);
    }

    public static void main(String[] args) {
        int[] a = {10, 20, 30, 50, 60};
        System.out.println(binarySearchRecursive(a, 200, 0, a.length - 1));  // Output should be -1 since 200 is not in the array
        System.out.println(binarySearchRecursive(a, 50, 0, a.length - 1));   // Output should be 3 since 50 is at index 3
    }
}
