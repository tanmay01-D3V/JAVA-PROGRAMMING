import javax.swing.*;

class SearchAlgorithm {
    public int linearSearch(String[] array, String target) {
        for (int i = 0; i < array.length; i++) {
            if (array[i].equals(target)) {
                return i;
            }
        }
        return -1;
    }
}

class BubbleSortAlgorithm {
    public int[] bubbleSort(int[] array) {
        int[] sortedArray = array.clone();
        int n = sortedArray.length;

        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (sortedArray[j] > sortedArray[j + 1]) {
                    int temp = sortedArray[j];
                    sortedArray[j] = sortedArray[j + 1];
                    sortedArray[j + 1] = temp;
                }
            }
        }
        return sortedArray;
    }
}

public class linearsearchswing extends JFrame {
    private final JLabel arrayLabel = new JLabel("Enter Array:");
    private final JLabel elementLabel = new JLabel("Search Element:");

    private final JTextField arrayTextField = new JTextField();
    private final JTextField elementTextField = new JTextField();

    private final JButton searchButton = new JButton("Search");
    private final JButton sortButton = new JButton("Sort");
    private final JButton clearButton = new JButton("Clear");

    private final JTextArea textarea = new JTextArea();
    private final SearchAlgorithm searchAlgorithm = new SearchAlgorithm();
    private final BubbleSortAlgorithm bubbleSortAlgorithm = new BubbleSortAlgorithm();

    public linearsearchswing() {
        super("Linear Search & Bubble Sort Program");
        setLayout(null);

        arrayLabel.setBounds(50, 50, 100, 30);
        arrayTextField.setBounds(150, 50, 200, 30);

        elementLabel.setBounds(50, 100, 100, 30);
        elementTextField.setBounds(150, 100, 200, 30);

        searchButton.setBounds(120, 150, 100, 30);
        sortButton.setBounds(230, 150, 100, 30);
        clearButton.setBounds(340, 150, 100, 30);

        textarea.setBounds(50, 200, 390, 120);
        textarea.setEditable(false);

        add(arrayLabel);
        add(elementLabel);
        add(arrayTextField);
        add(elementTextField);
        add(searchButton);
        add(sortButton);
        add(clearButton);
        add(textarea);

        setSize(500, 370);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        searchButton.addActionListener(e -> performSearch());
        sortButton.addActionListener(e -> performBubbleSort());
        clearButton.addActionListener(e -> clearFields());
    }

    private void performSearch() {
        String arrayInput = arrayTextField.getText().trim();
        String targetInput = elementTextField.getText().trim();

        if (arrayInput.isEmpty() || targetInput.isEmpty()) {
            textarea.setText("Please enter both array elements and target.");
            return;
        }

        String[] elements = arrayInput.split("\\s+");
        int foundIndex = searchAlgorithm.linearSearch(elements, targetInput);

        if (foundIndex != -1) {
            textarea.setText("Target found at Index: " + foundIndex + ", Position: " + (foundIndex + 1));
        } else {
            textarea.setText("Target not found in the array.");
        }
    }

    private void performBubbleSort() {
        String arrayInput = arrayTextField.getText().trim();

        if (arrayInput.isEmpty()) {
            textarea.setText("Please enter array values before sorting.");
            return;
        }

        String[] values = arrayInput.split("\\s+");
        int[] numbers = new int[values.length];

        try {
            for (int i = 0; i < values.length; i++) {
                numbers[i] = Integer.parseInt(values[i]);
            }
        } catch (NumberFormatException e) {
            textarea.setText("Please enter numeric values only for sorting.");
            return;
        }

        int[] sortedArray = bubbleSortAlgorithm.bubbleSort(numbers);

        StringBuilder result = new StringBuilder();
        result.append("Sorted Array: ");
        for (int value : sortedArray) {
            result.append(value).append(" ");
        }

        textarea.setText(result.toString().trim());
    }

    private void clearFields() {
        arrayTextField.setText("");
        elementTextField.setText("");
        textarea.setText("");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            linearsearchswing frame = new linearsearchswing();
            frame.setVisible(true);
        });
    }
}
