import java.util.Stack;

public class ClearDigits {
    public static void main(String[] args) {
        System.out.println(clearDigits("abc"));
    }

    public static String clearDigits(String s) {
        String result = "";
        char[] chars = s.toCharArray();
        Stack<Character> stack = new Stack<>();

        for (char aChar : chars) {
            if (aChar >= '0' && aChar <= '9') {
                stack.pop();
            } else {
                stack.push(aChar);
            }
        }

        while (!stack.isEmpty()) {
            result =  stack.pop() + result;
        }
        return result;
    }
}
