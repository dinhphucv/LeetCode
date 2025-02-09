public class PalindromeNumber {
    public static void main(String[] args) {
        System.out.println(isPalindrome(10));
    }

    public static boolean isPalindrome(int x) {
        String xStr = String.valueOf(x);
        int xLength = xStr.length();
        char[] xArr = xStr.toCharArray();
        for (int i = 0; i < xLength / 2; i++) {
            if(xArr[i] != xArr[xLength - 1 - i]) {
                return false;
            }
        }
        return true;
    }
}
