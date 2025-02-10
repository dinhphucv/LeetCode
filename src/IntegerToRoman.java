public class IntegerToRoman {
    public static void main(String[] args) {

    }

    public static String intToRoman(int num) {
        StringBuilder result = new StringBuilder();

        int[] values = {1, 4, 5, 9, 10, 40, 50, 90, 100, 400, 500, 900, 1000};
        String[] roman = {"I", "IV", "V", "IX", "X", "XL", "L", "XC", "C", "CD", "D", "CM", "M"};
        int temp;

        for (int i = roman.length - 1; i >= 0; i--) {
            if (num >= values[i]) {
                temp = num / values[i];
                result.append(roman[i].repeat(temp));
                num = num - (temp * values[i]);
            }
        }

        return result.toString();
    }
}
