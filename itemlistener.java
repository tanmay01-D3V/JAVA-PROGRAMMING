
import javax.swing.*;

public class itemlistener {
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
        }

        JRadioButton maleButton = new JRadioButton("Male");
        JRadioButton femaleButton = new JRadioButton("Female");
    }
}
