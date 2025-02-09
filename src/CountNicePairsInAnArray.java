import java.util.HashMap;

public class CountNicePairsInAnArray {
    public static void main(String[] args) {}

    public static int countNicePairs(int[] nums) {
        long count = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        int calculation;
        int previousOccurrence;
        for (int num : nums) {
            calculation = num - rev(num);
            previousOccurrence = map.getOrDefault(calculation, 0);
            count = count + previousOccurrence;
            map.put(calculation, previousOccurrence + 1);
        }

        return (int) (count % 1000000007);
    }

    public static int rev(int num) {
        int reverse = 0;
        while (num > 0) {
            reverse = reverse * 10 + num % 10;
            num = num / 10;
        }
        return reverse;
    }
}
