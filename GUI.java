import java.awt.Component;
import javax.swing.*;

public class GUI {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Choose City");
        frame.setLayout(null);

        JLabel noofcitiesLabel = new JLabel("Enter no of cities: ");
        JLabel citynameLabel = new JLabel("Enter name of City: ");
        JLabel searchLabel = new JLabel("Search for the City: ");
        JButton removeButton = new JButton("Remove Duplicate Record");

        JTextField noofcitiesTextField = new JTextField();
        JTextField searchTextField = new JTextField();

        noofcitiesLabel.setBounds(20, 30, 250, 25);
        noofcitiesTextField.setBounds(190, 30, 210, 25);    

        searchLabel.setBounds(20, 75, 160, 25);
        searchTextField.setBounds(190, 75, 210, 25);

        citynameLabel.setBounds(20, 120, 160, 25);
        removeButton.setBounds(150, 470, 220, 30);

        frame.add(noofcitiesLabel);
        frame.add(noofcitiesTextField);
        frame.add(searchLabel);
        frame.add(searchTextField);
        frame.add(citynameLabel);
        frame.add(removeButton);

        noofcitiesTextField.addActionListener(e -> {
            try {
                int cityCount = Integer.parseInt(noofcitiesTextField.getText().trim());

                if (cityCount < 0) {
                    JOptionPane.showMessageDialog(frame, "Please enter a valid number of cities.");
                    return;
                }

                for (int i = 0; i < frame.getContentPane().getComponentCount(); i++) {
                    Component c = frame.getContentPane().getComponent(i);

                    if (c instanceof JLabel && c != noofcitiesLabel && c != citynameLabel && c != searchLabel
                            && c != removeButton) {
                        frame.remove(c);
                    }

                    if (c instanceof JTextField && c != noofcitiesTextField && c != searchTextField) {
                        frame.remove(c);
                    }
                }

                int y = 160;
                for (int i = 1; i <= cityCount; i++) {
                    JLabel cityLabel = new JLabel("City " + i + ":");
                    JTextField cityTextField = new JTextField();

                    cityLabel.setBounds(20, y, 100, 25);
                    cityTextField.setBounds(130, y, 200, 25);

                    frame.add(cityLabel);
                    frame.add(cityTextField);
                    y += 40;
                }

                frame.revalidate();
                frame.repaint();
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(frame, "Please enter a valid number.");
            }
        });

        frame.setSize(600, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
