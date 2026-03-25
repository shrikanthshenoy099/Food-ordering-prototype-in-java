package shrikanth;

import javax.swing.*;

public class UserUI {
    JFrame frame;
    Order order;

    public UserUI(String username) {
        order = new Order(username);

        frame = new JFrame("Menu");
        frame.setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));

        for (FoodItem item : DataStore.menu.values()) {
            JButton btn = new JButton(item.name + " ₹" + item.price);
            btn.addActionListener(e -> order.addItem(item));
            frame.add(btn);
        }

        JButton finish = new JButton("Place Order");
        finish.addActionListener(e -> placeOrder());
        frame.add(finish);

        frame.setSize(300,400);
        frame.setVisible(true);
    }

    void placeOrder() {
        DataStore.orders.add(order);
        JOptionPane.showMessageDialog(frame, "Total Bill: ₹" + order.getTotal());
        frame.dispose();
    }
}
