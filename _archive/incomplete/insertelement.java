import javax.swing.*;

public class insertelement extends JFrame {
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

    public insertelement() {
        super("Insert Element");
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

    private void performAdd() {
        try {
            String values = arrayTextField.getText().trim();
            String addition = addTextField.getText().trim();
            resultArea.setText(values.isEmpty() ? addition : values + ", " + addition);
        } catch (RuntimeException exception) {
            resultArea.setText("Enter valid values.");
        }
    }

    private void performDelete() {
        String values = arrayTextField.getText().trim();
        String deletion = deleteTextField.getText().trim();
        String[] elements = values.split(",");
        StringBuilder remaining = new StringBuilder();
        for (String element : elements) {
            if (!element.trim().equals(deletion)) {
                if (remaining.length() > 0) {
                    remaining.append(", ");
                }
                remaining.append(element.trim());
            }
        }
        resultArea.setText(remaining.toString());
    }

    private void clearFields() {
        arrayTextField.setText("");
        addTextField.setText("");
        deleteTextField.setText("");
        resultArea.setText("");
    }
}
