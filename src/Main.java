import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        System.out.println("###########################");
        System.out.println(" Welcome in my MarketPlace ");
        System.out.println("###########################");

        Random rand = new Random();
        Order myorder = new Order(1);

        List<String> listOfItems = Arrays.asList("Banana", "Peach", "Apple", "A nice car", "TV");

        for(String itemName : listOfItems){
            int quantityRand = rand.nextInt(5) + 1;
            double priceRand = 0.50 + rand.nextDouble() * (20 - 0.50);  // 0.50 min and 20 max

            Item item = new Item(itemName, quantityRand, priceRand);
            myorder.addItem(item);
        }

        System.out.println(myorder);
    }
}