import java.util.Stack;

public class RemoveAllOccurrencesOfASubstring {
    public static void main(String[] args) {
        System.out.println(removeOccurrences("daabcbaabcbc", "abc"));
    }

    public static String removeOccurrences(String s, String part) {
        StringBuilder sb = new StringBuilder(s);
        int startIndex = sb.indexOf(part);
        while (startIndex != -1) {
            sb.delete(startIndex, startIndex + part.length());
            startIndex = sb.indexOf(part);
        }

        return sb.toString();
    }
}
