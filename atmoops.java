import javax.swing.*;

class BankAccount {
    private final String accountholder;
    private double balance;

    BankAccount(String accountholder, double balance) {
        this.accountholder = accountholder;
        this.balance = balance;
    }

    public String getaccountholder() {
        return accountholder;
    }

    public double getbalance() {
        return balance;
    }

    public void deposit(double amount) {
        balance = balance + amount;
    }

    public boolean withdraw(double amount) {
        if (amount <= balance) {
            balance = balance - amount;
            return true;
        }
        return false;
    }

    public double calculateInterest() {
        return 0;
    }
}

class SavingAccount extends BankAccount {

    public SavingAccount(String accountholder, double balance) {
        super(accountholder, balance);
    }

    @Override
    public double calculateInterest() {
        return getbalance() * 0.05;
    }

    public double addInterest() {
        double interest = calculateInterest();
        deposit(interest);
        return interest;
    }
}

public class atmoops {
    public static void main(String[] args) {

        JFrame frame = new JFrame("Feedback Form");

        JLabel nameLabel = new JLabel("Account Holder Name: ");
        JLabel balanceLabel = new JLabel("initial Balance: ");
        JLabel amountLabel = new JLabel("Amount: ");

        JButton depositButton = new JButton("Deposit");
        JButton withdrawButton = new JButton("Withdraw");
        JButton interestButton = new JButton("Get Interest");

        JTextField nameField = new JTextField();
        JTextField balanceField = new JTextField();
        JTextField amountField = new JTextField();
        JTextArea reciptArea = new JTextArea();

        reciptArea.setEditable(false);
        reciptArea.setLineWrap(true);
        reciptArea.setWrapStyleWord(true);

        JScrollPane scrollPane = new JScrollPane(reciptArea);

        nameLabel.setBounds(50, 50, 150, 30);
        nameField.setBounds(240, 50, 250, 30);

        balanceLabel.setBounds(50, 100, 100, 30);
        balanceField.setBounds(240, 100, 250, 30);

        amountLabel.setBounds(50, 150, 100, 30);
        amountField.setBounds(240, 150, 250, 30);
        scrollPane.setBounds(190, 200, 350, 150);

        depositButton.setBounds(240, 370, 110, 30);
        withdrawButton.setBounds(380, 370, 110, 30);
        interestButton.setBounds(35, 200, 100, 30);

        final SavingAccount[] account = { new SavingAccount("", 0) };

        Runnable initializeAccount = () -> {
            if (account[0].getaccountholder().isEmpty()) {
                account[0] = new SavingAccount(nameField.getText(),
                        Double.parseDouble(balanceField.getText()));
            }
        };

        java.util.function.Consumer<String> updateReceipt = message -> {
            String accountName = account[0].getaccountholder().isEmpty() ? nameField.getText()
                    : account[0].getaccountholder();
            reciptArea.setText("ACCOUNT RECEIPT\n"
                    + "------------------------------\n"
                    + "Account Holder: " + accountName + "\n"
                    + "Transfer Summary: " + message + "\n"
                    + "Current Balance: " + account[0].getbalance() + "\n");
        };

        depositButton.addActionListener(e -> {
            try {
                initializeAccount.run();
                double amount = Double.parseDouble(amountField.getText());
                account[0].deposit(amount);
                updateReceipt.accept("Deposit of " + amount + " completed.");
            } catch (NumberFormatException ex) {
                reciptArea.setText("Enter valid numbers.");
            }
        });

        withdrawButton.addActionListener(e -> {
            try {
                initializeAccount.run();
                double amount = Double.parseDouble(amountField.getText());
                double interest = account[0].addInterest();
                boolean successful = account[0].withdraw(amount);
                if (successful) {
                    updateReceipt.accept("Interest of " + interest
                            + " added. Withdrawal of " + amount + " completed.");
                } else {
                    account[0].withdraw(interest);
                    reciptArea.setText("Insufficient balance.");
                }
            } catch (NumberFormatException ex) {
                reciptArea.setText("Enter a valid amount.");
            }
        });

        interestButton.addActionListener(e -> {
            try {
                initializeAccount.run();
                double interest = account[0].addInterest();
                updateReceipt.accept("Interest of " + interest + " added.");
            } catch (NumberFormatException ex) {
                reciptArea.setText("Enter a valid initial balance.");
            }
        });

        frame.add(nameLabel);
        frame.add(nameField);
        frame.add(balanceLabel);
        frame.add(balanceField);
        frame.add(amountLabel);
        frame.add(amountField);
        frame.add(depositButton);
        frame.add(withdrawButton);
        frame.add(scrollPane);
        frame.add(interestButton);

        frame.setSize(600, 600);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
