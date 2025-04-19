package array;

public class MaximumSumSubArray {

    private static  int  maxSumSubArray(int [] arr)
    {
        int maxSum = Integer.MIN_VALUE;
        int currentSum = 0;
        for(int i=0;i<arr.length ;i++)
        {
            currentSum = Math.max(arr[i], currentSum+arr[i]);
            maxSum = Math.max(maxSum,currentSum);
        }

        return  maxSum;
    }

    public static void main(String[] args) {
        int arr[] = {1,2,3,-7,4,5,-1,-7,6};
        System.out.println(maxSumSubArray(arr));
    }































}
