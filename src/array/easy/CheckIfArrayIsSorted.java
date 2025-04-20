package array.easy;

public class CheckIfArrayIsSorted {

    private static boolean isArraySorted(int[] a) {
        for (int i = 0; i < a.length - 1; i++) {
            if (a[i] > a[i + 1]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] a = {10, 200, 30, 40};  // Not sorted
        System.out.println(isArraySorted(a));  // Output: false

        int[] b = {1, 2, 3, 4};  // Sorted
        System.out.println(isArraySorted(b));  // Output: true
    }
}
