public class LongestCommonPrefix {
    public static void main(String[] args) {
        String[] strs = {"abab", "aba", ""};
        System.out.println(longestCommonPrefix(strs));
    }

    public static String longestCommonPrefix(String[] strs) {
        if (strs.length == 1) {
            return strs[0];
        }
        int uptoIndex = 0;

        while (uptoIndex < strs[0].length() && uptoIndex < strs[1].length()) {
            if (!(strs[0].charAt(uptoIndex) == strs[1].charAt(uptoIndex))) {
                break;
            }
            uptoIndex++;
        }

        if (uptoIndex == 0) {
            return "";
        }

        for (int i = 2 ; i < strs.length; i++) {
            if (uptoIndex > strs[i].length()) {
                uptoIndex = strs[i].length();
            }
            if (uptoIndex == 0) {
                return "";
            }
            for (int j = 0; j < uptoIndex && j < strs[i].length(); j++) {
                if (strs[0].charAt(j) != strs[i].charAt(j)) {
                    uptoIndex = j;
                    break;
                }
            }
        }

        String result = strs[0].substring(0, uptoIndex);

        return result;
    }
}
