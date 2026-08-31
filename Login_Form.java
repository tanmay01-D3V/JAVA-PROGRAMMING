
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;

class User {
    private String username;
    private String password;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public boolean isValidPassword() {
        if (password == null || password.length() < 8) {
            return false;
        }
        if (!password.matches(".*[A-Z].*")) {
            return false;
        }
        if (!password.matches(".*[a-z].*")) {
            return false;
        }
        if (!password.matches(".*\\d.*")) {
            return false;
        }
        return true;
    }
}

public class Login_Form {
    private List<User> users = new ArrayList<>();

    public boolean registerUser(User newUser) {
        for (User user : users) {
            if (user.getUsername().equalsIgnoreCase(newUser.getUsername())) {
                return false;
            }
        }
        users.add(newUser);
        return true;
    }

    public boolean loginUser(String username, String password) {
        for (User user : users) {
            if (user.getUsername().equalsIgnoreCase(username) &&
                    user.getPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }

    public void openRegistrationForm() {
        new RegistrationForm(this).setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Login_Form app = new Login_Form();
            app.openRegistrationForm();
        });
    }

    class RegistrationForm extends JFrame implements ActionListener {
        private final Login_Form app;
        private JTextField usernameField;
        private JPasswordField passwordField;
        private JPasswordField confirmPasswordField;
        private JButton registerButton;

        public RegistrationForm(Login_Form app) {
            this.app = app;
            setTitle("Register");
            setLayout(null);
            setSize(400, 260);
            setLocationRelativeTo(null);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setResizable(false);

            JLabel usernameLabel = new JLabel("Username:");
            JLabel passwordLabel = new JLabel("Password:");
            JLabel confirmLabel = new JLabel("Confirm Password:");

            usernameField = new JTextField();
            passwordField = new JPasswordField();
            confirmPasswordField = new JPasswordField();
            registerButton = new JButton("Register");

            usernameLabel.setBounds(40, 30, 120, 25);
            usernameField.setBounds(170, 30, 170, 25);
            passwordLabel.setBounds(40, 75, 120, 25);
            passwordField.setBounds(170, 75, 170, 25);
            confirmLabel.setBounds(40, 120, 120, 25);
            confirmPasswordField.setBounds(170, 120, 170, 25);
            registerButton.setBounds(150, 170, 100, 30);

            add(usernameLabel);
            add(usernameField);
            add(passwordLabel);
            add(passwordField);
            add(confirmLabel);
            add(confirmPasswordField);
            add(registerButton);

            registerButton.addActionListener(this);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            String username = usernameField.getText().trim();
            String password = new String(passwordField.getPassword());
            String confirmPassword = new String(confirmPasswordField.getPassword());

            if (username.isEmpty() || password.isEmpty() || confirmPassword.isEmpty()) {
                JOptionPane.showMessageDialog(this, "All fields are required.");
                return;
            }

            if (!password.equals(confirmPassword)) {
                JOptionPane.showMessageDialog(this, "Passwords do not match.");
                return;
            }

            User user = new User(username, password);
            if (!user.isValidPassword()) {
                JOptionPane.showMessageDialog(this,
                        "Password must contain at least 8 characters, uppercase, lowercase, and a number.");
                return;
            }

            if (!app.registerUser(user)) {
                JOptionPane.showMessageDialog(this, "Username already exists. Please choose another one.");
                return;
            }

            JOptionPane.showMessageDialog(this, "Registration successful! Please login.");
            dispose();
            new LoginForm(app).setVisible(true);
        }
    }

    class LoginForm extends JFrame implements ActionListener {
        private final Login_Form app;
        private JTextField usernameField;
        private JPasswordField passwordField;
        private JButton loginButton;

        public LoginForm(Login_Form app) {
            this.app = app;
            setTitle("Login");
            setLayout(null);
            setSize(400, 220);
            setLocationRelativeTo(null);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setResizable(false);

            JLabel usernameLabel = new JLabel("Username:");
            JLabel passwordLabel = new JLabel("Password:");

            usernameField = new JTextField();
            passwordField = new JPasswordField();
            loginButton = new JButton("Login");

            usernameLabel.setBounds(40, 30, 100, 25);
            usernameField.setBounds(150, 30, 180, 25);
            passwordLabel.setBounds(40, 80, 100, 25);
            passwordField.setBounds(150, 80, 180, 25);
            loginButton.setBounds(150, 130, 100, 30);

            add(usernameLabel);
            add(usernameField);
            add(passwordLabel);
            add(passwordField);
            add(loginButton);

            loginButton.addActionListener(this);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            String username = usernameField.getText().trim();
            String password = new String(passwordField.getPassword());

            if (username.isEmpty() || password.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Username and password are required.");
                return;
            }

            if (app.loginUser(username, password)) {
                JOptionPane.showMessageDialog(this, "Login successful! Welcome, " + username + ".");
                dispose();
            } else {
                JOptionPane.showMessageDialog(this, "Invalid username or password.");
            }
        }
    }
}
