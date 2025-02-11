import java.util.Stack;

public class RemoveAllOccurrencesOfASubstring {
    public static void main(String[] args) {
        System.out.println(removeOccurrences("daabcbaabcbc", "abc"));
    }

    public static String removeOccurrences(String s, String part) {
        StringBuilder sb = new StringBuilder();

        for (char aChar : s.toCharArray()) {
            sb.append(aChar);
            if (sb.length() >= part.length() && sb.substring(sb.length() - part.length(), sb.length()).equals(part)) {
                sb.delete(sb.length() - part.length(), sb.length());
            }
        }

        return sb.toString();
    }
}
