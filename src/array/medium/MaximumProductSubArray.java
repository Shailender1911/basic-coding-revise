package array.medium;

public class MaximumProductSubArray {

    private static int maxProdSubArray(int[] arr) {
        int maxProduct = arr[0];
        int maxEndingHere = arr[0];
        int minEndingHere = arr[0];

        for (int i = 1; i < arr.length; i++) {
            int temp = maxEndingHere;

            maxEndingHere = Math.max(arr[i], Math.max(maxEndingHere * arr[i], minEndingHere * arr[i]));
            minEndingHere = Math.min(arr[i], Math.min(temp * arr[i], minEndingHere * arr[i]));

            maxProduct = Math.max(maxProduct, maxEndingHere);
        }

        return maxProduct;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, -7, 4, 5, -1, -7, 6};
        System.out.println("Maximum Product Subarray: " + maxProdSubArray(arr));
    }
}
