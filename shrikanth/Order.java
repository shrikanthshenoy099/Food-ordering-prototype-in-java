package shrikanth;
import java.util.*;

public class Order {
    String username;
    HashMap<FoodItem, Integer> cart = new HashMap<>();

    public Order(String username) {
        this.username = username;
    }

    public void addItem(FoodItem item) {
        cart.put(item, cart.getOrDefault(item, 0) + 1);
    }

    public double getTotal() {
        double total = 0;
        for (Map.Entry<FoodItem, Integer> entry : cart.entrySet()) {
            total += entry.getKey().price * entry.getValue();
        }
        return total;
    }
}
