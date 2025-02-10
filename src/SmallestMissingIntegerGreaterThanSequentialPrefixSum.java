import java.util.HashSet;

public class SmallestMissingIntegerGreaterThanSequentialPrefixSum {
    public static void main(String[] args) {

    }

    public static int missingInteger(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        int previous = nums[0];
        int sum = previous;
        set.add(sum);
        boolean stop = false;

        for (int i = 1; i < nums.length; i++) {
            if (!stop) {
                if (nums[i] == previous + 1) {
                    sum = sum + nums[i];
                    previous = nums[i];
                } else {
                    stop = true;
                }
            }
            set.add(nums[i]);
        }

        while (set.contains(sum)) {
            sum = sum + 1;
        }

        return sum;
    }
}
