import java.util.ArrayList;
import java.util.HashMap;

public class InsertDeleteGetRandomO1 {
    public static void main(String[] args) {

    }


}

class RandomizedSet {

    HashMap<Integer, Integer> map;
    ArrayList<Integer> list;

    public RandomizedSet() {
        map = new HashMap<>();
        list = new ArrayList<>();
    }

    public boolean insert(int val) {
        if (!map.containsKey(val)) {
            list.add(val);
            map.put(val, list.size() - 1);
            return true;
        }
        return false;
    }

    public boolean remove(int val) {
        if (!map.containsKey(val)) {
            return false;
        }

        int index = map.get(val);
        int lastElement = list.getLast();
        list.set(index, lastElement);
        map.put(lastElement, index);
        list.removeLast();
        map.remove(val);
        return true;
    }

    public int getRandom() {
        return list.get((int) (Math.random() * list.size()));
    }
}