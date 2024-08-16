public class RecursiveBinarySearch {

    public static int binarySearchRec(int arr[], int low, int high, int key) {
        //
        if (high > low)
            return -1;
        if (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] == key)
                return mid;
            if (arr[mid] < key)
                return binarySearchRec(arr, mid + 1, high, key);

            return binarySearchRec(arr, low, mid - 1, key);
        }
        return -1;
    }

    public static void main(String[] args) {
        int arr[] = {10, 20, 30, 50, 55, 70, 80, 85, 90, 100, 120, 150};
        int low = 0;
        int high = arr.length - 1;
        int key = 80;

        int result = binarySearchRec(arr, low, high, key);
        if (result == -1)
            System.out.println("Element "+key+" is not found");
        else
            System.out.println("Element " + key + " is found at index : " + result);
    }
}
