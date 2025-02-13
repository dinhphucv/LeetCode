import java.util.PriorityQueue;

public class MinimumOperationsToExceedThresholdValueII {
    public static void main(String[] args) {
        int[] nums = {999999999, 999999999, 999999999};
        System.out.println(minOperations(nums, 1000000000));
    }

    public static int minOperations(int[] nums, int k) {

        if (nums.length == 0) return 0;

        PriorityQueue<Long> minHeap = new PriorityQueue<>();
        for (int num : nums) {
            minHeap.add((long) num);
        }

        long x = minHeap.poll();
        long y;
        int count = 0;

        while (x < k) {
            y = minHeap.poll();
            minHeap.add(Math.min(x, y) * 2 + Math.max(x, y));
            count++;
            x = minHeap.poll();
        }

        return count;

    }
}
