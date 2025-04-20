package array.easy;

public class SecondLargestElementInArray {

    private int findSecondLargestElement(int[] a) {
        int largest = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE;
        for (int i = 0; i < a.length; i++) {
            if (a[i] > largest) {
                secondLargest = largest;
                largest = a[i];

            }
            else if (a[i] > secondLargest && a[i] != largest) {
                secondLargest = a[i];
            }
        }
        return secondLargest;
    }

    public static void main(String[] args) {
        SecondLargestElementInArray obj = new SecondLargestElementInArray();
        int a[] = {10, 20, 5, 30, 40, 20, 35};
        System.out.println(obj.findSecondLargestElement(a));
    }
}
