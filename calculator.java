
import javax.swing.*;

public class calculator {
    public static void main(String[] args) {

        JFrame frame = new JFrame("Calculator");

        JLabel number1Label = new JLabel("Enter Number 1:");
        JLabel number2Label = new JLabel("Enter Number 2:");
        JLabel resultLabel = new JLabel("Result:");

        JTextField number1TextField = new JTextField();
        JTextField number2TextField = new JTextField();
        JTextField resultTextField = new JTextField();

        JButton AddButton = new JButton("+");
        JButton SubButton = new JButton("-");
        JButton MultiplyButton = new JButton("x");
        JButton DivButton = new JButton("/");

        number1Label.setBounds(40, 40, 130, 30);
        number1TextField.setBounds(180, 40, 200, 30);
        number2Label.setBounds(40, 90, 130, 30);
        number2TextField.setBounds(180, 90, 200, 30);

        resultLabel.setBounds(40, 140, 130, 30);
        resultTextField.setBounds(180, 140, 200, 30);

        AddButton.setBounds(40, 200, 75, 40);
        SubButton.setBounds(125, 200, 75, 40);
        MultiplyButton.setBounds(210, 200, 75, 40);
        DivButton.setBounds(295, 200, 75, 40);

        AddButton.addActionListener(e -> {
            double a = Double.parseDouble(number1TextField.getText());
            double b = Double.parseDouble(number2TextField.getText());

            double answer = a + b;

            resultTextField.setText(String.valueOf(answer));
        });

        SubButton.addActionListener(e -> {
            double a = Double.parseDouble(number1TextField.getText());
            double b = Double.parseDouble(number2TextField.getText());

            double answer = a - b;

            resultTextField.setText(String.valueOf(answer));
        });

        MultiplyButton.addActionListener(e -> {
            double a = Double.parseDouble(number1TextField.getText());
            double b = Double.parseDouble(number2TextField.getText());

            double answer = a * b;

            resultTextField.setText(String.valueOf(answer));
        });

        DivButton.addActionListener(e -> {
            double a = Double.parseDouble(number1TextField.getText());
            double b = Double.parseDouble(number2TextField.getText());

            if (b == 0) {
                resultTextField.setText("Cannot divide by 0");
            } else {
                double answer = a / b;
                resultTextField.setText(String.valueOf(answer));
            }
        });

        frame.add(number1Label);
        frame.add(number2Label);
        frame.add(number1TextField);
        frame.add(number2TextField);
        frame.add(resultLabel);
        frame.add(resultTextField);
        frame.add(AddButton);
        frame.add(SubButton);
        frame.add(MultiplyButton);
        frame.add(DivButton);

        frame.setSize(450, 320);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
