package practice;

public class MaximumConsecutiveOnes {

        public static int findMaxConsecutiveOnes(int[] nums) {
            int max = 0;
            int count = 0;

            for (int num : nums) {
                if (num == 1) {
                    count++;
                    max = Math.max(max, count);
                } else {
                    count = 0;
                }
            }

            return max;
        }

        public static void main(String[] args) {
            int[] nums = {1, 1, 0, 1, 1, 1,0,1,1,1,1,1};
            int result = findMaxConsecutiveOnes(nums);
            System.out.println("Maximum Consecutive Ones: " + result);
        }
}
