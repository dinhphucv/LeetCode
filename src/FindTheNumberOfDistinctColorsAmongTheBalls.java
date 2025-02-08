import java.util.Arrays;
import java.util.HashMap;

public class FindTheNumberOfDistinctColorsAmongTheBalls {
    public static void main(String[] args) {
        int[][] queries = {{0, 1}, {0, 4}, {1, 2}, {1, 5}, {1, 4}};
        System.out.println(Arrays.toString(queryResults(4, queries)));
    }

    public static int[] queryResults(int limit, int[][] queries) {
        int distinctColors = 0;
        int[] result = new int[queries.length];
        int ball;
        int color;
        int colorCount;

        int ballColor;
        int ballColorCount;

        HashMap<Integer, Integer> ballMap = new HashMap<>();
        HashMap<Integer, Integer> colorMap = new HashMap<>();

        for (int i = 0; i < queries.length; i++) {
            ball = queries[i][0];
            color = queries[i][1];
            colorCount = colorMap.getOrDefault(color, 0);

            ballColor = ballMap.getOrDefault(ball, -1);
            ballColorCount = colorMap.getOrDefault(ballColor, 0);

            if (ballColor == -1 && colorCount == 0) {
                ballMap.put(ball, color);
                colorMap.put(color, 1);
                distinctColors++;
                result[i] = distinctColors;
                continue;
            }

            if (ballColor == color) {
                result[i] = distinctColors;
                continue;
            }

            if (ballColorCount == 0) {
                ballMap.put(ball, color);
                colorCount++;
                colorMap.put(color, colorCount);
                result[i] = distinctColors;
                continue;
            }

            ballColorCount--;
            ballMap.put(ball, color);
            colorMap.put(ballColor, ballColorCount);
            colorCount++;
            colorMap.put(color, colorCount);

            if (ballColorCount == 0) {
                distinctColors--;
            }
            if (colorCount == 1) {
                distinctColors++;
            }
            result[i] = distinctColors;
        }

        return result;
    }
}
