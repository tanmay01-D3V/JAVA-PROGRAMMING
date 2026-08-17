import javax.swing.*;

public class swing {
    public static void main(String[] args) {

        JFrame frame = new JFrame("Student form");

        JLabel namelabel = new JLabel("Enter your name");

        JTextField nameTextField = new JTextField();

        JButton button = new JButton("Submit");

        namelabel.setBounds(450, 450, 220, 70);
        nameTextField.setBounds(600, 470, 200, 30);
        button.setBounds(525, 550, 100, 30);

        frame.add(namelabel);
        frame.add(nameTextField);
        frame.add(button);

        button.addActionListener(e -> {
            String name = nameTextField.getText();

            JOptionPane.showMessageDialog(frame, "Hi " + name + " !");
        });

        frame.setSize(450, 200);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

    }
}
