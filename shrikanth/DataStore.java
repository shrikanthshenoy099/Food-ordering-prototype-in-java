package shrikanth;

import java.util.*;

public class DataStore {
    public static ArrayList<User> users = new ArrayList<>();
    public static ArrayList<Order> orders = new ArrayList<>();
    public static HashMap<Integer, FoodItem> menu = new HashMap<>();
    public static final String ADMIN_USERNAME = "Shrikanth";
    public static final String ADMIN_PASSWORD = "Shrikanth@216";
    

    static {
        menu.put(1, new FoodItem(1, "Pizza", 120));
        menu.put(2, new FoodItem(2, "Burger", 80));
        menu.put(3, new FoodItem(3, "Pasta", 100));
        menu.put(4, new FoodItem(4, "Sandwich", 60));
        menu.put(5, new FoodItem(5, "Coffee", 40));
        System.out.println("Users count: " + DataStore.users.size());

    }
}

