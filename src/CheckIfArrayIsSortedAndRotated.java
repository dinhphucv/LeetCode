public class CheckIfArrayIsSortedAndRotated {
    public static void main(String[] args) {
        int[] nums = {2, 4, 1, 3};
        System.out.println(check(nums));
    }

    public static boolean check(int[] nums) {
        boolean isRotated = false;
        int largestNumber = nums[nums.length - 1];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] > nums[i]) {
                if (!isRotated) {
                    isRotated = true;
                    largestNumber = nums[i - 1];
                    if (nums[i] < largestNumber && nums[i] > nums[0]) {
                        return false;
                    }
                } else {
                    return false;
                }
            } else if (isRotated && (nums[i] > largestNumber || (nums[i] < largestNumber && nums[i] > nums[0]))) {
                return false;
            }
        }

        return true;
    }
}
