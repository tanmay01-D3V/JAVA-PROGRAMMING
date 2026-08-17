import javax.swing.*;

public class LoginForm {
    public static void main(String[] args) {

        JFrame frame = new JFrame("Login form");

        JLabel userlabel = new JLabel("Username:");
        JLabel passLabel = new JLabel("Password:");

        JTextField nameTextField = new JTextField();
        JPasswordField passTextField = new JPasswordField();

        JButton loginbutton = new JButton("Login");

        userlabel.setBounds(50, 50, 100, 30);
        nameTextField.setBounds(150, 50, 200, 30);

        passLabel.setBounds(50, 100, 100, 30);
        passTextField.setBounds(150, 100, 200, 30);

        loginbutton.setBounds(150, 150, 100, 30);

        frame.add(userlabel);
        frame.add(passLabel);
        frame.add(nameTextField);
        frame.add(passTextField);
        frame.add(loginbutton);

        loginbutton.addActionListener(e -> {
            String username = nameTextField.getText();
            String password = new String(passTextField.getPassword());

            if (username.equals("admin") && password.equals("1234")) {
                JOptionPane.showMessageDialog(frame, "Login Successful!");
            } else {
                JOptionPane.showMessageDialog(frame, "Invalid Username or Password");
            }
        });

        frame.setSize(400, 230);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
