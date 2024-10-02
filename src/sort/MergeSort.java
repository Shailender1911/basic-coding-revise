package sort;

public class MergeSort {

    // Main function to sort an array using Merge Sort
    public void mergeSort(int[] arr, int low, int high) {
        if (low < high) {
            // Calculate the middle point
            int mid = low + (high - low) / 2;

            // Recursively sort first half and second half
            mergeSort(arr, low, mid);
            mergeSort(arr, mid + 1, high);

            // Merge the sorted halves
            merge(arr, low, mid, high);
        }
    }

    // Function to merge two sorted subarrays
    public void merge(int[] arr, int low, int mid, int high) {
        // Create a temporary array to hold merged subarray
        int[] temp = new int[high - low + 1];

        int left = low;       // Start of the first subarray (left part)
        int right = mid + 1;  // Start of the second subarray (right part)
        int k = 0;            // Index for temp array

        // Merge the two subarrays into temp
        while (left <= mid && right <= high) {
            if (arr[left] <= arr[right]) {
                temp[k] = arr[left];
                left++;
            } else {
                temp[k] = arr[right];
                right++;
            }
            k++;
        }

        // Copy remaining elements of the left subarray (if any)
        while (left <= mid) {
            temp[k] = arr[left];
            left++;
            k++;
        }

        // Copy remaining elements of the right subarray (if any)
        while (right <= high) {
            temp[k] = arr[right];
            right++;
            k++;
        }

        // Copy the merged elements back to the original array
        for (k = 0; k < temp.length; k++) {
            arr[low + k] = temp[k];  // Copy back to the correct position
        }
    }

    // Utility function to print the array
    public void printArray(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    // Driver function
    public static void main(String[] args) {
        MergeSort sorter = new MergeSort();

        int[] arr = {12, 11, 13, 11,5,3,4,2,13, 6, 7};
        System.out.println("Given Array:");
        sorter.printArray(arr);

        sorter.mergeSort(arr, 0, arr.length - 1);

        System.out.println("\nSorted Array:");
        sorter.printArray(arr);
    }
}
