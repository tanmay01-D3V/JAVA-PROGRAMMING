import javax.swing.*;

class ArrayOperations {
    public int[] addElement(int[] array, int newValue) {
        int[] result = new int[array.length + 1];
        for (int i = 0; i < array.length; i++) {
            result[i] = array[i];
        }
        result[array.length] = newValue;
        return result;
    }

    public int[] deleteElement(int[] array, int target) {
        int count = 0;

        for (int value : array) {
            if (value != target) {
                count++;
            }
        }

        int[] result = new int[count];
        int index = 0;

        for (int value : array) {
            if (value != target) {
                result[index++] = value;
            }
        }

        return result;
    }

    public String formatArray(int[] array) {
        StringBuilder sb = new StringBuilder();
        for (int value : array) {
            sb.append(value).append(" ");
        }
        return sb.toString().trim();
    }
}

public class addelement extends JFrame {
    private final JLabel arrayLabel = new JLabel("Enter Array:");
    private final JLabel addLabel = new JLabel("Add Element:");
    private final JLabel deleteLabel = new JLabel("Delete Element:");

    private final JTextField arrayTextField = new JTextField();
    private final JTextField addTextField = new JTextField();
    private final JTextField deleteTextField = new JTextField();

    private final JButton addButton = new JButton("Add");
    private final JButton deleteButton = new JButton("Delete");
    private final JButton clearButton = new JButton("Clear");

    private final JTextArea resultArea = new JTextArea();
    private final ArrayOperations arrayOperations = new ArrayOperations();

    public addelement() {
        super("Array Addition and Deletion");
        setLayout(null);

        arrayLabel.setBounds(40, 30, 100, 25);
        arrayTextField.setBounds(150, 30, 220, 25);

        addLabel.setBounds(40, 75, 100, 25);
        addTextField.setBounds(150, 75, 220, 25);

        deleteLabel.setBounds(40, 120, 110, 25);
        deleteTextField.setBounds(150, 120, 220, 25);

        addButton.setBounds(50, 170, 100, 30);
        deleteButton.setBounds(170, 170, 100, 30);
        clearButton.setBounds(290, 170, 100, 30);

        resultArea.setBounds(40, 220, 350, 120);
        resultArea.setEditable(false);

        add(arrayLabel);
        add(addLabel);
        add(deleteLabel);
        add(arrayTextField);
        add(addTextField);
        add(deleteTextField);
        add(addButton);
        add(deleteButton);
        add(clearButton);
        add(resultArea);

        setSize(450, 380);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        addButton.addActionListener(e -> performAdd());
        deleteButton.addActionListener(e -> performDelete());
        clearButton.addActionListener(e -> clearFields());
    }

    private int[] parseArray() {
        String input = arrayTextField.getText().trim();
        if (input.isEmpty()) {
            return new int[0];
        }

        String[] parts = input.split("[\\s,]+");
        int[] numbers = new int[parts.length];

        try {
            for (int i = 0; i < parts.length; i++) {
                numbers[i] = Integer.parseInt(parts[i]);
            }
        } catch (NumberFormatException e) {
            resultArea.setText("Please enter only numeric values in the array.");
            return null;
        }

        return numbers;
    }

    private void performAdd() {
        int[] array = parseArray();
        if (array == null) {
            return;
        }

        String valueText = addTextField.getText().trim();
        if (valueText.isEmpty()) {
            resultArea.setText("Please enter a value to add.");
            return;
        }

        try {
            int value = Integer.parseInt(valueText);
            int[] result = arrayOperations.addElement(array, value);
            resultArea.setText("Updated Array: " + arrayOperations.formatArray(result));
        } catch (NumberFormatException e) {
            resultArea.setText("Please enter a valid integer to add.");
        }
    }

    private void performDelete() {
        int[] array = parseArray();
        if (array == null) {
            return;
        }

        String valueText = deleteTextField.getText().trim();
        if (valueText.isEmpty()) {
            resultArea.setText("Please enter a value to delete.");
            return;
        }

        try {
            int value = Integer.parseInt(valueText);
            int[] result = arrayOperations.deleteElement(array, value);

            boolean found = false;
            for (int num : array) {
                if (num == value) {
                    found = true;
                    break;
                }
            }

            if (!found) {
                resultArea.setText("Value not found. Array remains: " + arrayOperations.formatArray(array));
            } else if (result.length == 0) {
                resultArea.setText("Deleted successfully. Array is now empty.");
            } else {
                resultArea.setText("Updated Array: " + arrayOperations.formatArray(result));
            }
        } catch (NumberFormatException e) {
            resultArea.setText("Please enter a valid integer to delete.");
        }
    }

    private void clearFields() {
        arrayTextField.setText("");
        addTextField.setText("");
        deleteTextField.setText("");
        resultArea.setText("");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            addelement frame = new addelement();
            frame.setVisible(true);
        });
    }
}
