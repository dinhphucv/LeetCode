import java.util.ArrayList;

public class ProductOfNumbers {
    ArrayList<Integer> preProducts;

    public ProductOfNumbers() {
        preProducts = new ArrayList<>();
    }

    public void add(int num) {
        if (num == 0) {
            preProducts.clear();
            return;
        }

        if (preProducts.isEmpty()) {
            preProducts.add(num);
            return;
        }

        preProducts.add(preProducts.getLast() * num);
    }

    public int getProduct(int k) {
        if (k > preProducts.size()) {
            return 0;
        }

        if (k == preProducts.size()) {
            return preProducts.getLast();
        }

        return preProducts.getLast() / preProducts.get(preProducts.size() - k - 1);
    }
}
