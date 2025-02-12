import java.util.HashMap;
import java.util.HashSet;

public class NumberOfEquivalentDominoPairs {
    public static void main(String[] args) {

    }

    public static int numEquivDominoPairs(int[][] dominoes) {
        int count = 0;
        HashMap<Integer, HashMap<Integer, Integer>> firstSecondFrequencyMap = new HashMap<>();
        int first;
        int second;
        int previousCount;
        for (int[] domino : dominoes) {
            first = domino[0];
            second = domino[1];

            if (!firstSecondFrequencyMap.containsKey(first)) {
                firstSecondFrequencyMap.put(first, new HashMap<>());
            }
            firstSecondFrequencyMap.get(first).put(second, firstSecondFrequencyMap.get(first).getOrDefault(second, 0) + 1);

            previousCount = firstSecondFrequencyMap.get(first).get(second) - 1;
            if (firstSecondFrequencyMap.containsKey(second) && first != second) {
                previousCount = previousCount + firstSecondFrequencyMap.get(second).getOrDefault(first, 0);
            }

            count = count + previousCount;
        }

        return count;
    }
}
