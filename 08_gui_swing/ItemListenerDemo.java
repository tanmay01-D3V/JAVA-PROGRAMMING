
import javax.swing.*;

public class ItemListenerDemo {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Item Listener Demo");

        JLabel coursesLabel = new JLabel("Select Course: ");
        JLabel genderLabel = new JLabel("Select Gender: ");
        JLabel hobbiesLabel = new JLabel("Select Hobbies: ");
        JLabel resultLabel = new JLabel("Selection will appear here");

        String[] courses = {
                "Electonic Enginnering",
                "Computer Science Engineering",
                "Civil Engineering",
        };

        JRadioButton maleButton = new JRadioButton("Male");
        JRadioButton femaleButton = new JRadioButton("Female");

        JComboBox<String> courseBox = new JComboBox<>(courses);
        JCheckBox readingBox = new JCheckBox("Reading");
        JCheckBox musicBox = new JCheckBox("Music");
        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(maleButton);
        genderGroup.add(femaleButton);

        coursesLabel.setBounds(20, 20, 120, 25);
        courseBox.setBounds(150, 20, 220, 25);
        genderLabel.setBounds(20, 60, 120, 25);
        maleButton.setBounds(150, 60, 80, 25);
        femaleButton.setBounds(240, 60, 90, 25);
        hobbiesLabel.setBounds(20, 100, 120, 25);
        readingBox.setBounds(150, 100, 90, 25);
        musicBox.setBounds(240, 100, 90, 25);
        resultLabel.setBounds(20, 150, 350, 25);

        frame.add(coursesLabel);
        frame.add(courseBox);
        frame.add(genderLabel);
        frame.add(maleButton);
        frame.add(femaleButton);
        frame.add(hobbiesLabel);
        frame.add(readingBox);
        frame.add(musicBox);
        frame.add(resultLabel);

        java.awt.event.ItemListener updateResult = event -> resultLabel.setText(
                courseBox.getSelectedItem() + " | "
                        + (maleButton.isSelected() ? "Male" : femaleButton.isSelected() ? "Female" : "No gender")
                        + " | Hobbies: "
                        + (readingBox.isSelected() ? "Reading " : "")
                        + (musicBox.isSelected() ? "Music" : ""));
        courseBox.addItemListener(updateResult);
        maleButton.addItemListener(updateResult);
        femaleButton.addItemListener(updateResult);
        readingBox.addItemListener(updateResult);
        musicBox.addItemListener(updateResult);

        frame.setLayout(null);
        frame.setSize(420, 230);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
