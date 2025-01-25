package practice.array;

public class MaximumConsecutiveSumArray {

    private static int  maximumConsecutiveSum(int a[] )
    {
        int maxSum = Integer.MIN_VALUE;
        int currentSum = Integer.MIN_VALUE;

        for(int i =0;i< a.length;i++)
        {
            currentSum = Math.max(a[i], currentSum+a[i]);
            maxSum = Math.max(maxSum, currentSum);
        }

        return maxSum;

    }

    public static void main(String[] args) {

        int a[] = {1,2,-3,-2,5};
        int result = maximumConsecutiveSum(a);
        System.out.println("Maximum Consecutive Sum: " + result);
    }

}
