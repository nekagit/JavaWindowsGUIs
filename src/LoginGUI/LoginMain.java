package LoginGUI;

import javax.swing.*;
import java.awt.*;

public class LoginMain extends JFrame {
    private JTextField userField;
    private JPasswordField passwordField;
    private JButton loginButton;

    public LoginMain() {
        // Set up the frame
        setTitle("Bitte loggen Sie sich...");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 200);

        // Create main panel
        JPanel mainPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 10, 5, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Create components
        userField = new JTextField(15);
        passwordField = new JPasswordField(15);
        loginButton = new JButton("Login");

        // Add Benutzer label
        JLabel userLabel = new JLabel("Benutzer:");
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        mainPanel.add(userLabel, gbc);

        // Add Benutzer field
        gbc.gridx = 0;
        gbc.gridy = 1;
        mainPanel.add(userField, gbc);

        // Add Passwort label with spacing from username field
        JLabel passwordLabel = new JLabel("Passwort:");
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.insets = new Insets(10, 10, 5, 10); // More top padding after username field
        mainPanel.add(passwordLabel, gbc);

        // Add Passwort field
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.insets = new Insets(5, 10, 5, 10); // Normal padding
        mainPanel.add(passwordField, gbc);

        // Add login button
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.insets = new Insets(15, 10, 5, 10); // More top padding before button
        gbc.anchor = GridBagConstraints.LINE_END;
        gbc.fill = GridBagConstraints.NONE;
        mainPanel.add(loginButton, gbc);

        // Add the main panel to the frame
        add(mainPanel);

        // Add action listener
        loginButton.addActionListener(e -> {
            String username = userField.getText();
            String password = new String(passwordField.getPassword());
            System.out.println("Login attempt with username: " + username);
        });

        // Center the window on screen
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new LoginMain().setVisible(true);
        });
    }
}