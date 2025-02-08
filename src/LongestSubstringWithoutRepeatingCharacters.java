import java.util.Arrays;
import java.util.HashMap;

public class LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
    }

    public static int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int max = 0;
        int startIndex;

        char[] sArray = s.toCharArray();
        for (int i = 0; i < sArray.length; i++) {
            if (map.containsKey(sArray[i])) {
                max = Math.max(max, map.size());
                startIndex = map.get(sArray[i]);
                Integer[] mapValues = map.values().toArray(new Integer[0]);
                Arrays.sort(mapValues);
                for (int number : mapValues) {
                    if (number > startIndex) {
                        break;
                    }
                    map.remove(sArray[number]);
                }
            }

            map.put(sArray[i], i);
        }
        return Math.max(max, map.size());
    }
}
