import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;

public class Reservationform {
    public static void main(String[] args) {

        JFrame frame = new JFrame("Reservation Form");

        JLabel passengersLabel = new JLabel("Enter Number of Passengers :");
        JLabel sourceLabel = new JLabel("Source :");
        JLabel destinationLabel = new JLabel("Destination :");
        JLabel fareLabel = new JLabel("Fare Price :");
        JLabel fareText = new JLabel("");
        JLabel statusText = new JLabel("");

        JTextField passengersTextField = new JTextField();

        JButton submitButton = new JButton("Submit");
        JButton resetButton = new JButton("Reset");

        String[] cities = { "Ahmednagar",
                "Akola",
                "Alibag",
                "Amravati",
                "Beed",
                "Bhandara",
                "Bhiwandi",
                "Buldhana",
                "Chandrapur",
                "Chhatrapati Sambhajinagar",
                "CIDCO",
                "Dhule",
                "Gadchiroli",
                "Ganeshpeth",
                "Gondia",
                "Hingoli",
                "Jalgaon",
                "Jalna",
                "Kalyan",
                "Kolhapur",
                "Kurla Nehru Nagar",
                "Latur",
                "Mumbai Central",
                "Nagpur",
                "Nanded",
                "Nandurbar",
                "Nashik",
                "Osmanabad",
                "Pandharpur",
                "Panvel",
                "Parel",
                "Parbhani",
                "Pen",
                "Pune",
                "Ratnagiri",
                "Sangli",
                "Satara",
                "Shivajinagar",
                "Sindhudurg",
                "Solapur",
                "Swargate",
                "Thane",
                "Wardha",
                "Washim",
                "Yavatmal"
        };

        JComboBox<String> sourceBox = new JComboBox<>(cities);
        JComboBox<String> destinationBox = new JComboBox<>(cities);

        List<JTextField> nameFields = new ArrayList<>();

        JPanel namesPanel = new JPanel();
        namesPanel.setLayout(new BoxLayout(namesPanel, BoxLayout.Y_AXIS));

        JScrollPane namesScroll = new JScrollPane(namesPanel);

        namesPanel.addMouseListener(new MouseListener() {

            public void mouseClicked(MouseEvent e) {
                statusText.setText("Mouse clicked on passenger names panel");
            }

            public void mousePressed(MouseEvent e) {
                statusText.setText("Mouse pressed on passenger names panel");
            }

            public void mouseReleased(MouseEvent e) {
                statusText.setText("Mouse released on passenger names panel");
            }

            public void mouseEntered(MouseEvent e) {
                statusText.setText("Mouse entered passenger names panel");
            }

            public void mouseExited(MouseEvent e) {
                statusText.setText("Mouse exited passenger names panel");
            }
        });

        passengersLabel.setBounds(40, 40, 180, 30);
        passengersTextField.setBounds(230, 40, 200, 30);
        namesScroll.setBounds(40, 80, 390, 140);

        sourceLabel.setBounds(40, 250, 180, 30);
        sourceBox.setBounds(230, 250, 200, 30);

        destinationLabel.setBounds(40, 280, 180, 30);
        destinationBox.setBounds(230, 280, 200, 30);

        fareLabel.setBounds(40, 330, 180, 30);
        fareText.setBounds(230, 330, 200, 30);

        statusText.setBounds(40, 220, 390, 30);

        submitButton.setBounds(40, 380, 90, 35);
        resetButton.setBounds(140, 380, 90, 35);

        passengersTextField.addKeyListener(new KeyAdapter() {
            public void keyReleased(KeyEvent e) {
                Reservationform.updateNameFields(passengersTextField.getText(), namesPanel, nameFields, fareText);
            }
        });

        submitButton.addActionListener(e -> {

            String passengers = passengersTextField.getText().trim();

            if (passengers.isEmpty()) {

                JOptionPane.showMessageDialog(frame, "Enter Number of Passengers!");

            } else if (!passengers.matches("\\d+") || Integer.parseInt(passengers) < 1) {

                JOptionPane.showMessageDialog(frame, "Passengers must be a number greater than 0!");

            } else {

                boolean missing = false;

                for (int i = 0; i < nameFields.size(); i++) {
                    if (nameFields.get(i).getText().trim().isEmpty()) {
                        JOptionPane.showMessageDialog(frame, "Enter Passenger " + (i + 1) + " Name!");
                        missing = true;
                        break;
                    }
                }

                if (!missing) {

                    StringBuilder namesList = new StringBuilder();

                    for (int i = 0; i < nameFields.size(); i++) {
                        namesList.append("Passenger ").append(i + 1).append(" : ")
                                .append(nameFields.get(i).getText().trim()).append("\n");
                    }

                    String message = "Ticket Booked!\n\n"
                            + namesList
                            + "\nSource : " + sourceBox.getSelectedItem() + "\n"
                            + "Destination : " + destinationBox.getSelectedItem() + "\n"
                            + "Fare Price : " + fareText.getText();

                    JOptionPane.showMessageDialog(frame, message);
                }
            }
        });

        resetButton.addActionListener(e -> {

            passengersTextField.setText("");
            sourceBox.setSelectedIndex(0);
            destinationBox.setSelectedIndex(0);
            fareText.setText("");
            updateNameFields(passengersTextField.getText(), namesPanel, nameFields, fareText);
        });

        frame.add(passengersLabel);
        frame.add(passengersTextField);
        frame.add(namesScroll);
        frame.add(sourceLabel);
        frame.add(sourceBox);
        frame.add(destinationLabel);
        frame.add(destinationBox);
        frame.add(fareLabel);
        frame.add(fareText);
        frame.add(statusText);
        frame.add(submitButton);
        frame.add(resetButton);

        frame.setSize(480, 510);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    static void updateNameFields(String text, JPanel namesPanel, List<JTextField> nameFields, JLabel fareText) {

        namesPanel.removeAll();
        nameFields.clear();

        try {
            int count = Integer.parseInt(text.trim());

            for (int i = 1; i <= count; i++) {

                JTextField nameField = new JTextField(18);
                nameField.setMaximumSize(new Dimension(200, 30));
                nameFields.add(nameField);

                JPanel row = new JPanel(new FlowLayout(FlowLayout.LEFT));
                row.add(new JLabel("Passenger " + i + " Name :"));
                row.add(nameField);
                namesPanel.add(row);
            }

            fareText.setText("Rs. " + (125 * count));

        } catch (NumberFormatException ex) {
            fareText.setText("");
        }

        namesPanel.revalidate();
        namesPanel.repaint();
    }
}
