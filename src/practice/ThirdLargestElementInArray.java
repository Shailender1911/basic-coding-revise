package practice;

public class ThirdLargestElementInArray {

        public static int thirdLargestElement(int[] arr) {
            int first = Integer.MIN_VALUE;
            int second = Integer.MIN_VALUE;
            int third = Integer.MIN_VALUE;

            for (int i = 0; i < arr.length; i++) {
                if (arr[i] > first) {
                    third = second;
                    second = first;
                    first = arr[i];
                } else if (arr[i] > second && arr[i] != first) {
                    third = second;
                    second = arr[i];
                } else if (arr[i] > third && arr[i] != second && arr[i] != first) {
                    third = arr[i];
                }
            }

            return third;
        }

        public static void main(String[] args) {
            int[] arr = {10, 2, 3, 4, 5, 6};
            int result = thirdLargestElement(arr);
            System.out.println("Third Largest Element: " + result);
        }
}
