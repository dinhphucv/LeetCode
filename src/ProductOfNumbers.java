public class ProductOfNumbers {
    ListNode tail;

    public ProductOfNumbers() {
        tail = null;
    }

    public void add(int num) {
        if (tail == null) {
            tail = new ListNode(num);
            return;
        }

        tail = new ListNode(num, tail);
    }

    public int getProduct(int k) {
        int product = 1;
        ListNode current = tail;
        while (k > 0) {
            product = product * current.val;
            current = current.next;
            k++;
        }

        return product;
    }
}
