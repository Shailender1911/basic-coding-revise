package recursion;

public class MinimumInAnArray {

    private static int findMinimum(int[] a, int min, int index) {

        // Base case: when index reaches the end of the array
        if (index >= a.length)
            return min;

        // Check if the current element is smaller than the current minimum
        if (a[index] < min) {
            min = a[index];
        }

        // Recurse for the next element
        return findMinimum(a, min, index + 1);
    }

    public static void main(String[] args) {
        int[] a = {10, 20, 20, 5, 50, 15, 30, 45};
        System.out.println(findMinimum(a, Integer.MAX_VALUE, 0));  // Output will be 5
    }
}
