public class MaximumAscendingSubarraySum {
    public static void main(String[] args) {
        int[] nums = {12,17,15,13,10,11,12};
        System.out.println(maxAscendingSum(nums));
    }

    public static int maxAscendingSum(int[] nums) {
        int max = 0;
        int currentSum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] >= nums[i - 1]) {
                currentSum = currentSum + nums[i];
                continue;
            }
            if (currentSum > max) {
                max = currentSum;
            }
            currentSum = nums[i];
        }
        return Math.max(max, currentSum);
    }
}
