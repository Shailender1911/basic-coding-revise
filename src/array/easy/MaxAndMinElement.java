package array.easy;

public class MaxAndMinElement {
    // Find the maximum and minimum element in an unsorted array

    int[] findMaxAndMin(int a[]) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < a.length; i++) {
            if (a[i] > max) {
                max = a[i];
            }
            if (a[i] < min) {
                min = a[i];
            }
        }

        return new int[] {min, max};
    }

    public static void main(String[] args) {
        MaxAndMinElement obj = new MaxAndMinElement();
        int[] arr = {3, 1, 5, 9, -2, 7};

        int[] result = obj.findMaxAndMin(arr);
        System.out.println("Min: " + result[0]);
        System.out.println("Max: " + result[1]);
    }
}
