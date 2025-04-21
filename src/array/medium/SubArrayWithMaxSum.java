package array.medium;

import java.util.Arrays;

public class SubArrayWithMaxSum {

    private int[] maxSumArrayWithSubarray(int[] nums) {
        int maxSoFar = nums[0];
        int currentSum = nums[0];

        int start = 0;
        int end = 0;
        int tempStart = 0;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > currentSum + nums[i]) {
                currentSum = nums[i];
                tempStart = i;
            } else {
                currentSum += nums[i];
            }

            if (currentSum > maxSoFar) {
                maxSoFar = currentSum;
                start = tempStart;
                end = i;
            }
        }

        // Extract the actual subarray
        return Arrays.copyOfRange(nums, start, end + 1);
    }

    public static void main(String[] args) {
        SubArrayWithMaxSum obj = new SubArrayWithMaxSum();
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int[] subarray = obj.maxSumArrayWithSubarray(nums);

        System.out.println("Subarray with Maximum Sum: " + Arrays.toString(subarray));
        int maxSum = Arrays.stream(subarray).sum();
        System.out.println("Maximum Sum: " + maxSum);
    }
}
