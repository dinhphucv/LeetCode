import java.util.HashMap;

public class TupleWithSameProduct {
    public static void main(String[] args) {
        int[] nums = {2,3,4,6,8,12};
        System.out.println(tupleSameProduct(nums));
    }

    public static int tupleSameProduct(int[] nums) {
        
        HashMap<Integer, Integer> map = new HashMap<>();
        int count = 0;
        int product;
        int value;
        int temp;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] != nums[j]) {
                   product = nums[i] * nums[j];
                   map.put(product, map.getOrDefault(product, 0) + 1);
                }
            }
        }

        for (int key : map.keySet()) {
            value = map.get(key);
            if (value != 1) {
                // how many combination of pair we can create
                temp = value * (value - 1) / 2;

                // each combination can have 8 tuples
                count = count + (temp * 8);
            }
        }

        return count;
    }
}
