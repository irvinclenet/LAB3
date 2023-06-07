import java.util.List;

public class Order {

    private List<Item> items;
    private List<OrderObserver> observers;

    public void attach(OrderObserver observer) {
    }

    public void detach(OrderObserver observer) {
    }

    public void addItem(Item item) {
    }

    public void removeItem(Item item) {
    }

    public double getTotalPrice() {
        return 0;
    }

    public int getCount() {
        return 0;
    }

    public String toString() {
        return "";
    }

}
