import java.util.ArrayList;
import java.util.List;

public class Order {
    
    private int ID;
    private List<Item> items = new ArrayList<>();
    private List<OrderObserver> observers = new ArrayList<>();

    private int discountPrice;
    private int discountQuantity;

    // Constructor
    Order(int ID) {
        this.ID = ID;

        attach(new PriceObserver());
        attach(new QuantityObserver());
    }

    // Observers
    public void attach(OrderObserver observer) {
        observers.add(observer);
    }

    public void detach(OrderObserver observer) {
        observers.remove(observer);
    }

    public void updateObserver() {
        for(OrderObserver obs:observers) {
            obs.update(this);
        }
    }

    // Items
    public void addItem(Item item) {
        items.add(item);
        updateObserver();
    }

    public void removeItem(Item item) {
        items.remove(item);
        updateObserver();
    }

    // Calc prices
    public double getItemsPrice() {
        double price = 0;
        for(Item item:items) {
            price += item.getPrice();
        }

        return price;
    }

    public double getTotalPrice() {
        double price = 0;

        price += getItemsPrice();
        price -= discountPrice;
        price += discountQuantity;

        return price;
    }

    public int getCount() {
        return items.size();
    }

    // toString
    public String toString() {
        String recapItems = "";

        // Ex : 5x Banana      $2.50 (u/$1.25)
        for(Item item:items) {
            recapItems += item.getQuantity() + "x " + item.getName() +
                          "       $" + String.format("%.2f", item.getPrice()) +
                          " (u/$" + String.format("%.2f", item.getUnitPrice()) + ")" + "\n";
        }

        recapItems += "\nSubtotal : $" + String.format("%.2f", getItemsPrice()) + "\n";
        
        return  "\n" +
                "Order n°" + ID + "\n" +
                "\n" +
                recapItems +
                "\n" +
                "Discount Price : -$" + discountPrice + "\n" +
                "Shipping : $" + discountQuantity + "\n" +
                "Total : $" + String.format("%.2f", getTotalPrice());
    }


    // Setters
    public void setDiscountPrice(int discountPrice) {
        this.discountPrice = discountPrice;
    }
    public void setDiscountQuantity(int discountQuantity) {
        this.discountQuantity = discountQuantity;
    }
}
