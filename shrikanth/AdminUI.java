package shrikanth;
import javax.swing.*;
import java.util.*;

public class AdminUI {

    JFrame frame;

    public AdminUI() {

        // ---- Admin Authentication ----
        String adminUser = JOptionPane.showInputDialog(
                null, "Enter Admin Username:");

        JPasswordField pf = new JPasswordField();
        int ok = JOptionPane.showConfirmDialog(
                null, pf, "Enter Admin Password",
                JOptionPane.OK_CANCEL_OPTION);

        if (adminUser == null || ok != JOptionPane.OK_OPTION) {
            return;
        }

        String adminPass = new String(pf.getPassword());

        if (!adminUser.equals(DataStore.ADMIN_USERNAME) ||
            !adminPass.equals(DataStore.ADMIN_PASSWORD)) {

            JOptionPane.showMessageDialog(
                    null, "Invalid Admin Credentials");
            return;
        }

        JOptionPane.showMessageDialog(
                null, "Admin Login Successful");

        // ---- Admin Panel UI ----
        frame = new JFrame("Admin Panel");
        JTextArea area = new JTextArea();
        area.setEditable(false);

        StringBuilder data = new StringBuilder();

        // ---- USERS LIST ----
        data.append("USERS LIST\n");
        data.append("-----------------\n");

        if (DataStore.users.isEmpty()) {
            data.append("No users found.\n");
        } else {
            for (User u : DataStore.users) {
                data.append("Username: ")
                    .append(u.username)
                    .append(" | Age: ")
                    .append(u.age)
                    .append("\n");
            }
        }

        // ---- ORDERS LIST ----
        data.append("\nORDERS LIST\n");
        data.append("-----------------\n");

        double grandTotal = 0;

        if (DataStore.orders.isEmpty()) {
            data.append("No orders placed.\n");
        } else {
            for (Order o : DataStore.orders) {
                data.append("User: ")
                    .append(o.username)
                    .append("\n");

                for (Map.Entry<FoodItem, Integer> entry
                        : o.cart.entrySet()) {

                    FoodItem item = entry.getKey();
                    int qty = entry.getValue();

                    data.append("  ")
                        .append(item.name)
                        .append(" x")
                        .append(qty)
                        .append(" = ₹")
                        .append(item.price * qty)
                        .append("\n");
                }

                data.append("  Order Total: ₹")
                    .append(o.getTotal())
                    .append("\n\n");

                grandTotal += o.getTotal();
            }
        }

        // ---- TOTAL REVENUE ----
        data.append("TOTAL REVENUE: ₹")
            .append(grandTotal);

        area.setText(data.toString());

        frame.add(new JScrollPane(area));
        frame.setSize(500, 500);
        frame.setVisible(true);
    }
}
