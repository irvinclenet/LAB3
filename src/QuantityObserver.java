public class QuantityObserver implements OrderObserver{

    public QuantityObserver() {}
    public void update(Order order){
        if (order.getCount() > 5)
            order.setDiscountQuantity(0);
        else
            order.setDiscountQuantity(10);
    }
}
