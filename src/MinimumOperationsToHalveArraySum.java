import java.util.Collections;
import java.util.PriorityQueue;

public class MinimumOperationsToHalveArraySum {
    public static void main(String[] args) {

    }

    public static int halveArray(int[] nums) {
        if (nums.length <= 2) {
            return nums.length;
        }

        PriorityQueue<Double> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        double sum = 0;
        for (int num : nums) {
            maxHeap.add((double) num);
            sum = sum + num;
        }

        double halve = sum / 2;
        int operations = 0;

        double x;
        while (sum > halve) {
            x = maxHeap.poll() / 2;
            sum = sum - x;
            maxHeap.add(x);
            operations++;
        }

        return operations;
    }
}
