import java.util.HashMap;

public class MaxSumOfAPairWithEqualSumOfDigits {
    public static void main(String[] args) {
        int[] nums = {279,169,463,252,94,455,423,315,288,64,494,337,409,283,283,477,248,8,89,166,188,186,128};
        System.out.println(maximumSum(nums));
    }

    public static int maximumSum(int[] nums) {
        int maximumSum = -1;
        int digitSum;
        HashMap<Integer, Integer> digitSumMaxIndexMap = new HashMap<>();
        int currentMapIndex;

        for (int i = 0; i < nums.length; i++) {
            digitSum = digitSum(nums[i]);
            if (!digitSumMaxIndexMap.containsKey(digitSum)) {
                digitSumMaxIndexMap.put(digitSum, i);
                continue;
            }

            currentMapIndex = digitSumMaxIndexMap.get(digitSum);
            if (nums[i] > nums[currentMapIndex]) {
                digitSumMaxIndexMap.put(digitSum, i);
            }

            if (nums[currentMapIndex] + nums[i] > maximumSum) {
                maximumSum = nums[currentMapIndex] + nums[i];
            }
        }

        return maximumSum;
    }

    public static int digitSum(int num) {
        int sum = 0;
        while (num > 0) {
            sum = sum + num % 10;
            num = num / 10;
        }
        return sum;
    }
}
