package practice;

public class SecondLargestElementInArray {

        public static int secondLargestElement(int[] arr) {
            int largest = Integer.MIN_VALUE;
            int secondLargest = Integer.MIN_VALUE;

            for (int i = 0; i < arr.length; i++) {
                if (arr[i] > largest) {
                    secondLargest = largest;
                    largest = arr[i];
                } else if (arr[i] > secondLargest && arr[i] != largest) {
                    secondLargest = arr[i];
                }
            }

            return secondLargest;
        }

        public static void main(String[] args) {
            int[] arr = {10, 2, 3, 4, 5, 6};
            int result = secondLargestElement(arr);
            System.out.println("Second Largest Element: " + result);
        }
}
