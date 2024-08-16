public class BinarySearch {

    public static int binarySearch(int arr[], int key) {
        int low = 0;
        int high = arr.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] == key)
                return mid;
            if (arr[mid] < key) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int arr[] = {10, 20, 35, 60, 70, 100};
        int key = 75;
        int result = binarySearch(arr, key);
        System.out.println("Index of key " + key + "  - --" + result);

    }
}
