import java.util.HashMap;

public class NumberOfEquivalentDominoPairs {
    public static void main(String[] args) {

    }

    public static int numEquivDominoPairs(int[][] dominoes) {
        int count = 0;
        HashMap<Integer, Integer> keyFrequencies = new HashMap<>();
        int first, second, key, previousFrequencies = 0;

        for (int[] domino : dominoes) {
            first = domino[0];
            second = domino[1];
            // interpret 2 numbers as a single key (min * 10 + max) 36 instead of 3 and 6
            key = Math.min(first, second) * 10 + Math.max(first, second);

            // get previous frequencies or default to 0;
            previousFrequencies = keyFrequencies.getOrDefault(key, 0);

            // add current count to previousFrequencies because if there is a new matching key, it create previousFrequencies new pairs.
            // example, a key occur 9 times, if 10th key occur, it can pair with all 9 previous keys, so create 9 new pairs.
            count = count + previousFrequencies;

            // frequencies occur at the end of each iteration is use as value for the above key.
            keyFrequencies.put(key, previousFrequencies + 1);
        }

        return count;
    }
}
