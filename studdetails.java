import java.awt.event.*;
import javax.swing.*;


class Person {
    private String name; 
    private int age;
    public void setName(String name){
        this.name = name;



    }
}
public class studdetails extends JFrame implements ActionListener {

    JLabel nameLabel = new JLabel("Student Name:");
    JLabel ageLabel = new JLabel("Age:");
    JLabel courseLabel = new JLabel("Course:");

    JTextField nameText = new JTextField();
    JTextField ageText = new JTextField();

    String[] courses = {"ComputerScience", "IT AI", "DS"};
    JComboBox<String> courseDropdown = new JComboBox<>(courses);

    JButton submitButton = new JButton("Submit");
    JButton clearButton = new JButton("Clear");

    JTextArea textarea = new JTextArea();

    studdetails() {

        setTitle("Student Details");
        setSize(500, 450);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        nameLabel.setBounds(50, 50, 120, 30);
        nameText.setBounds(180, 50, 180, 30);

        ageLabel.setBounds(50, 100, 120, 30);
        ageText.setBounds(180, 100, 180, 30);

        courseLabel.setBounds(50, 150, 120, 30);
        courseDropdown.setBounds(180, 150, 180, 30);

        submitButton.setBounds(80, 220, 100, 40);
        clearButton.setBounds(220, 220, 100, 40);

        textarea.setBounds(70, 300, 350, 100);
        textarea.setEditable(false);

        add(nameLabel);
        add(nameText);

        add(ageLabel);
        add(ageText);

        add(courseLabel);
        add(courseDropdown);

        add(submitButton);
        add(clearButton);

        add(textarea);

        submitButton.addActionListener(this);
        clearButton.addActionListener(this);

        setLocationRelativeTo(null);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == submitButton) {

            String name = nameText.getText();
            String age = ageText.getText();
            String course = (String) courseDropdown.getSelectedItem();

            textarea.setText(
                "----- Student Details -----\n\n" +
                "Student Name: " + name + "\n" +
                "Age: " + age + "\n" +
                "Course: " + course
            );
        }

        else if (e.getSource() == clearButton) {

            nameText.setText("");
            ageText.setText("");
            courseDropdown.setSelectedIndex(0);
            textarea.setText("");
        }
    }

    public static void main(String[] args) {
        new studdetails();
    }
}