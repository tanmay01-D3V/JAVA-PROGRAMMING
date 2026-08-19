
import javax.swing.*;

public class CheckboxString {
    public static void main(String[] args) {

        JFrame frame = new JFrame("Student Registration Form");

        JLabel nameLabel = new JLabel("Enter Your Name : ");
        JLabel RollnoLabel = new JLabel("Enter Your Roll.no .:");
        JLabel eamilLabel = new JLabel("Enter Your Email:");
        JLabel genderLabel = new JLabel("Gender ");
        JLabel courseLabel = new JLabel("courses");
        JLabel hobbiesLabel = new JLabel("Hobbies");

        JTextField nameTextField = new JTextField();
        JTextField rollnoTextField = new JTextField();
        JTextField eamilTextField = new JTextField();

        JRadioButton maleButton = new JRadioButton("Male");
        JRadioButton femaleButton = new JRadioButton("Female");
        JRadioButton LGBTQButton = new JRadioButton("Other");

        JButton RegButton = new JButton("Register");
        JButton CancelButton = new JButton("Cancel");

        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(maleButton);
        genderGroup.add(femaleButton);
        genderGroup.add(LGBTQButton);

        String[] courses = {
                "Select Course",
                "Computer Science",
                "Information Technology",
                "Electronics",
                "Civil"
        };

        JComboBox<String> courseBox = new JComboBox<>(courses);

        JCheckBox codingCheckBox = new JCheckBox("Coding");
        JCheckBox sportsCheckBox = new JCheckBox("Sports");
        JCheckBox musicCheckBox = new JCheckBox("music");

        nameLabel.setBounds(40, 40, 130, 30);
        nameTextField.setBounds(180, 40, 200, 30);
        RollnoLabel.setBounds(40, 90, 130, 30);
        rollnoTextField.setBounds(180, 90, 200, 30);
        eamilLabel.setBounds(40, 140, 130, 30);
        eamilTextField.setBounds(180, 140, 200, 30);

        genderLabel.setBounds(40, 180, 130, 30);
        maleButton.setBounds(180, 180, 80, 30);
        femaleButton.setBounds(270, 180, 80, 30);
        LGBTQButton.setBounds(360, 180, 80, 30);

        courseLabel.setBounds(40, 220, 130, 30);
        courseBox.setBounds(180, 220, 200, 30);

        hobbiesLabel.setBounds(40, 260, 130, 30);
        codingCheckBox.setBounds(180, 260, 80, 30);
        sportsCheckBox.setBounds(270, 260, 80, 30);
        musicCheckBox.setBounds(360, 260, 80, 30);

        RegButton.setBounds(40, 310, 90, 35);
        CancelButton.setBounds(140, 310, 90, 35);

        frame.add(nameLabel);
        frame.add(RollnoLabel);
        frame.add(eamilLabel);
        frame.add(genderLabel);
        frame.add(courseLabel);
        frame.add(hobbiesLabel);
        frame.add(nameTextField);
        frame.add(rollnoTextField);
        frame.add(eamilTextField);
        frame.add(maleButton);
        frame.add(femaleButton);
        frame.add(LGBTQButton);
        frame.add(courseBox);
        frame.add(codingCheckBox);
        frame.add(sportsCheckBox);
        frame.add(musicCheckBox);
        frame.add(RegButton);
        frame.add(CancelButton);

        RegButton.addActionListener(e -> {
            String name = nameTextField.getText();
            String rollno = rollnoTextField.getText();
            String email = eamilTextField.getText();

            String gender = "";

            if (maleButton.isSelected()) {
                gender = "Male";
            } else if (femaleButton.isSelected()) {
                gender = "Female";
            } else if (LGBTQButton.isSelected()) {
                gender = "Other";
            }

            String course = (String) courseBox.getSelectedItem();

            String hobbies = "";

            if (codingCheckBox.isSelected()) {
                hobbies += "Coding ";
            }
            if (sportsCheckBox.isSelected()) {
                hobbies += "Sports ";
            }
            if (musicCheckBox.isSelected()) {
                hobbies += "Music ";
            }

            if (name.isEmpty() || rollno.isEmpty() || email.isEmpty()) {
                JOptionPane.showMessageDialog(frame, "Please fill required fields!");
                return;
            }
            if (!email.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$")) {
                JOptionPane.showMessageDialog(frame, "Please enter a valid email address!");
                return;
            }
            if (gender.isEmpty()) {
                JOptionPane.showMessageDialog(frame, "Please select gender!");
                return;
            }
            if (course.equals("Select Course")) {
                JOptionPane.showMessageDialog(frame, "Please select a course!");
                return;
            }
            JOptionPane.showMessageDialog(frame,
                    "Registration Successful!\n\n" +
                            "Name: " + name + "\n" +
                            "Roll No: " + rollno + "\n" +
                            "Email: " + email + "\n" +
                            "Gender: " + gender + "\n" +
                            "Course: " + course + "\n" +
                            "Hobbies: " + (hobbies.isEmpty() ? "None" : hobbies));
        });

        CancelButton.addActionListener(e -> {
            nameTextField.setText("");
            rollnoTextField.setText("");
            eamilTextField.setText("");
            genderGroup.clearSelection();
            courseBox.setSelectedIndex(0);
            codingCheckBox.setSelected(false);
            sportsCheckBox.setSelected(false);
            musicCheckBox.setSelected(false);
        });

        frame.setSize(480, 400);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

    }
}