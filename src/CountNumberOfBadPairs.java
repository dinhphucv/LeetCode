import java.util.HashMap;

public class CountNumberOfBadPairs {
    public static void main(String[] args) {

    }

    public static long countBadPairs(int[] nums) {
        long totalPairs = ((long) nums.length * (nums.length - 1)) / 2;
        long goodPairs = 0;
        HashMap<Integer, Integer> frequencyMap = new HashMap<>();
        int calculation;
        int previousOccurrence;

        for (int i = 0; i < nums.length; i++) {
            calculation = nums[i] - i;
            previousOccurrence = frequencyMap.getOrDefault(calculation, 0);
            goodPairs =  goodPairs + previousOccurrence;
            frequencyMap.put(calculation, previousOccurrence + 1);
        }

        return totalPairs - goodPairs;
    }
}
