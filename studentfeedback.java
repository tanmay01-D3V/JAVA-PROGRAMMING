import java.awt.event.*;
import javax.swing.*;

public class studentfeedback {
    public static void main(String[] args) {

        JFrame frame = new JFrame("Feedback Form");

        JLabel nameLabel = new JLabel("Student Name: ");
        JLabel feedLabel = new JLabel("Feedback: ");
        JLabel statusLabel = new JLabel("Status: ");
        JLabel statusText = new JLabel("");

        JButton submitButton = new JButton("Submit");
        JButton clearButton = new JButton("Clear");

        JTextField nameField = new JTextField();
        JTextArea feedArea = new JTextArea();

        feedArea.setLineWrap(true);
        feedArea.setWrapStyleWord(true);

        JScrollPane scrollPane = new JScrollPane(feedArea);

        nameLabel.setBounds(50, 50, 100, 30);
        nameField.setBounds(150, 50, 200, 30);

        feedLabel.setBounds(50, 100, 100, 30);
        scrollPane.setBounds(150, 100, 200, 70);

        statusLabel.setBounds(50, 180, 100, 30);
        statusText.setBounds(150, 180, 250, 30);

        submitButton.setBounds(100, 230, 80, 30);
        clearButton.setBounds(200, 230, 80, 30);

        // Keyboard Event
        nameField.addKeyListener(new KeyListener() {

            public void keyTyped(KeyEvent e) {
                statusText.setText("Student is typing....");
            }

            public void keyPressed(KeyEvent e) {
                System.out.println("Key Pressed: " + e.getKeyChar());
                statusText.setText("Student is typing....");
            }

            public void keyReleased(KeyEvent e) {
            }
        });

        // Mouse Event
        feedArea.addMouseListener(new MouseListener() {

            public void mouseClicked(MouseEvent e) {
            }

            public void mouseReleased(MouseEvent e) {
            }

            public void mousePressed(MouseEvent e) {
            }

            public void mouseEntered(MouseEvent e) {
                statusText.setText("Mouse entered feedback box");
            }

            public void mouseExited(MouseEvent e) {
                statusText.setText("Mouse exited feedback box");
            }
        });

        // Submit Button
        submitButton.addActionListener(e -> {

            String name = nameField.getText();
            String feedback = feedArea.getText();

            if (name.trim().isEmpty()) {

                JOptionPane.showMessageDialog(
                    frame,
                    "Enter Name!"
                );

            } else if (feedback.trim().isEmpty()) {

                JOptionPane.showMessageDialog(
                    frame,
                    "Enter Feedback!"
                );

            } else {

                String message =
                    "Thanks for your feedback, " + name + "!\n\n"
                    + "Your Feedback:\n" + feedback;

                JOptionPane.showMessageDialog(
                    frame,
                    message
                );

                statusText.setText("Feedback submitted successfully");
            }
        });

        // Clear Button
        clearButton.addActionListener(e -> {

            nameField.setText("");
            feedArea.setText("");
            statusText.setText("");
        });

        // Add Components
        frame.add(nameLabel);
        frame.add(nameField);
        frame.add(feedLabel);
        frame.add(scrollPane);
        frame.add(statusLabel);
        frame.add(statusText);
        frame.add(submitButton);
        frame.add(clearButton);

        // Frame Settings
        frame.setSize(600, 600);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
