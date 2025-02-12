import java.util.HashMap;

public class MaxSumOfAPairWithEqualSumOfDigits {
    public static void main(String[] args) {
        int[] nums = {279,169,463,252,94,455,423,315,288,64,494,337,409,283,283,477,248,8,89,166,188,186,128};
        System.out.println(maximumSum(nums));
    }

    public static int maximumSum(int[] nums) {
        int maximumSum = -1;
        int digitSum;
        int num;

        // this HashMap is used to map the digitSum to the index of the biggest number which the sum of all digit equal to digitSum.
        HashMap<Integer, Integer> digitSumMaxIndexMap = new HashMap<>();
        int currentMapIndex;

        // looping through the array.
        for (int i = 0; i < nums.length; i++) {
            num = nums[i];
            digitSum = digitSum(num);

            // if the digitSum is not in the map, map the sum of all digit to i, which is the first number has that digitSum, so the biggest.
            if (!digitSumMaxIndexMap.containsKey(digitSum)) {
                digitSumMaxIndexMap.put(digitSum, i);
                continue;
            }

            // save the currentMapIndex and check if current nums[i] is greater than previous biggest number with same digitSum and if update.
            currentMapIndex = digitSumMaxIndexMap.get(digitSum);
            if (num > nums[currentMapIndex]) {
                digitSumMaxIndexMap.put(digitSum, i);
            }

            // check if the sum of num[i] and previous biggest number is greater than current maximumSum and update.
            if (nums[currentMapIndex] + num > maximumSum) {
                maximumSum = nums[currentMapIndex] + num;
            }
        }

        return maximumSum;
    }

    public static int digitSum(int num) {
        int sum = 0;

        // modulo the number by 10 to get the last digit and divide by 10 to get rid of that digit to move to the next digit
        while (num > 0) {
            sum = sum + num % 10;
            num = num / 10;
        }
        return sum;
    }
}
