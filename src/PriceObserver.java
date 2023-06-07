public class PriceObserver implements OrderObserver{

    public PriceObserver() {}
    public void update(Order order){
        if (order.getTotalPrice() > 200)
            order.setDiscountPrice(20);
        else
            order.setDiscountPrice(0);
    }
}
