package recursion;

public class CountOccurrences {

    public static int countOccurrences(int[] arr, int x, int index) {
        // Base case: If the index is out of bounds, return 0
        if (index == arr.length)
            return 0;


        // Recursive case: Check if the current element is equal to x
        if (arr[index] == x) {
            // If it is, add 1 to the count and continue to the next element
            return 1 + countOccurrences(arr, x, index + 1);
        } else {
            // If it isn't, just continue to the next element
            return countOccurrences(arr, x, index + 1);
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 2, 2, 5, 2};
        int target = 2;

        // Start the recursion with index 0
        int count = countOccurrences(arr, target, 0);

        System.out.println("Number " + target + " occurs " + count + " times in the array.");
    }
}
