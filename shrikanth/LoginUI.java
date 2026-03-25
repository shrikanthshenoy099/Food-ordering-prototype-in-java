package shrikanth;

import javax.swing.*;
import java.awt.*;

public class LoginUI {
    JFrame frame;
    JTextField userField, ageField;
    JPasswordField passField;

    public LoginUI() {
        frame = new JFrame("Food Ordering Login");

        JLabel l1 = new JLabel("Username:");
        JLabel l2 = new JLabel("Password:");
        JLabel l3 = new JLabel("Age:");

        userField = new JTextField();
        passField = new JPasswordField();
        ageField = new JTextField();

        JButton loginBtn = new JButton("Login");
        JButton adminBtn = new JButton("Admin Login");

        frame.setLayout(new GridLayout(5,2));
        frame.add(l1); frame.add(userField);
        frame.add(l2); frame.add(passField);
        frame.add(l3); frame.add(ageField);
        frame.add(loginBtn);
        frame.add(adminBtn);

        loginBtn.addActionListener(e -> userLogin());
        adminBtn.addActionListener(e -> new AdminUI());

        frame.setSize(350,250);
        frame.setVisible(true);
    }

    void userLogin() {
        String user = userField.getText();
        String pass = String.valueOf(passField.getPassword());
        int age = Integer.parseInt(ageField.getText());

        if (age < 18) {
            JOptionPane.showMessageDialog(frame, "Age must be 18+");
            return;
        }

        DataStore.users.add(new User(user, pass, age));
        new UserUI(user);
        frame.dispose();
        System.out.println("Users after login: " + DataStore.users.size());

    }
}

