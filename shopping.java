
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class shopping {

        public class ShoppingUI extends JFrame {

                HashMap<Integer, Products> products = new HashMap<>();
                HashSet<String> categories = new HashSet<>();
                LinkedList<CartItem> cart = new LinkedList<>();
                TreeMap<String, Double> bill = new TreeMap<>();

                JTextField searchField;
                JTextField quantityField;
                JTable productTable;
                JTable cartTable;

                DefaultTableModel productModel;
                DefaultTableModel cartModel;

                JTextArea billArea;

                public class Products {

                        int id;
                        String name;
                        String category;
                        double price;
                        int stock;

                        Products(int id, String name, String category, double price, int stock) {
                                this.id = id;
                                this.name = name;
                                this.category = category;
                                this.price = price;
                                this.stock = stock;
                        }
                }

                public class CartItem {
                        Products product;
                        int quantity;

                        CartItem(Products products, int quantity) {
                                this.product = products;
                                this.quantity = quantity;
                        }

                        double getTotal() {
                                return product.price * quantity;
                        }
                }

                public ShoppingUI() {

                        setTitle("Shopping Cart System");
                        setSize(900, 700);
                        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                        setLocationRelativeTo(null);
                        setLayout(new BorderLayout());

                        JPanel searchPanel = new JPanel();
                        searchField = new JTextField(20);
                        JButton searchButton = new JButton("Search");

                        searchPanel.add(new JLabel("Search Product: "));
                        searchPanel.add(searchField);
                        searchPanel.add(searchButton);
                        add(searchPanel, BorderLayout.NORTH);

                        productModel = new DefaultTableModel(
                                        new String[] { "ID", "Product", "Category", "Price", "Stock" }, 0);
                        productTable = new JTable(productModel);
                        JScrollPane productScrollPane = new JScrollPane(productTable);

                        JPanel addPanel = new JPanel();
                        quantityField = new JTextField(5);
                        JButton addButton = new JButton("Add to cart");

                        addPanel.add(new JLabel("Quantity: "));
                        addPanel.add(quantityField);
                        addPanel.add(addButton);

                        cartModel = new DefaultTableModel(
                                        new String[] { "ID", "Product", "Price", "Quantity", "Total" }, 0);
                        cartTable = new JTable(cartModel);
                        JScrollPane cartScrollPane = new JScrollPane(cartTable);

                        JPanel productPanel = new JPanel(new BorderLayout());
                        productPanel.setBorder(BorderFactory.createTitledBorder("Available Products"));
                        productPanel.add(productScrollPane, BorderLayout.CENTER);

                        JPanel cartPanel = new JPanel(new BorderLayout());
                        cartPanel.setBorder(BorderFactory.createTitledBorder("Shopping Cart"));
                        cartPanel.add(addPanel, BorderLayout.NORTH);
                        cartPanel.add(cartScrollPane, BorderLayout.CENTER);

                        JPanel centerPanel = new JPanel(new GridLayout(1, 2));
                        centerPanel.add(productPanel);
                        centerPanel.add(cartPanel);
                        add(centerPanel, BorderLayout.CENTER);

                        JPanel billPanel = new JPanel(new BorderLayout());
                        JButton billButton = new JButton("Generate Bill");
                        billArea = new JTextArea(10, 50);
                        billArea.setEditable(false);
                        billArea.setFont(new Font("Monospaced", Font.PLAIN, 14));

                        billPanel.add(billButton, BorderLayout.NORTH);
                        billPanel.add(new JScrollPane(billArea), BorderLayout.CENTER);
                        add(billPanel, BorderLayout.SOUTH);

                        displayProducts();

                        searchButton.addActionListener(e -> searchProduct());
                        addButton.addActionListener(e -> addToCart());
                        billButton.addActionListener(e -> generateBill());

                        setVisible(true);
                }

                void addSampleProducts() {

                        addProduct(new Products(1, "Mouse", "Electronics", 599, 10));
                        addProduct(new Products(2, "Keyboard", "Electronics", 999, 10));
                        addProduct(new Products(3, "Monitor", "Electronics", 7999, 5));
                        addProduct(new Products(4, "Headphones", "Audio", 1499, 8));
                        addProduct(new Products(5, "USB Cable", "Accessories", 199, 20));
                        addProduct(new Products(6, "Webcam", "Electronics", 2499, 6));
                }

                void addProduct(Products product) {
                        products.put(product.id, product);
                        categories.add(product.category);
                }

                void displayProducts() {
                        addSampleProducts();
                        productModel.setRowCount(0);
                        for (Products product : products.values()) {
                                productModel.addRow(new Object[] {
                                                product.id, product.name, product.category, product.price, product.stock
                                });
                        }
                }

                void searchProduct() {
                        String search = searchField.getText().toLowerCase();
                        productModel.setRowCount(0);
                        for (Products product : products.values()) {
                                if (product.name.toLowerCase().contains(search) ||
                                                product.category.toLowerCase().contains(search)) {
                                        productModel.addRow(new Object[] {
                                                        product.id, product.name, product.category, product.price,
                                                        product.stock
                                        });
                                }
                        }
                }

                void addToCart() {
                        int selectedRow = productTable.getSelectedRow();
                        if (selectedRow < 0) {
                                JOptionPane.showMessageDialog(this, "Please select a product!");
                                return;
                        }

                        try {
                                int quantity = Integer.parseInt(quantityField.getText());
                                int productId = (int) productModel.getValueAt(selectedRow, 0);
                                Products product = products.get(productId);

                                if (quantity <= 0 || quantity > product.stock) {
                                        JOptionPane.showMessageDialog(this, "Invalid quantity!");
                                        return;
                                }

                                cart.add(new CartItem(product, quantity));
                                product.stock -= quantity;
                                updateCartTable();
                                quantityField.setText("");
                                JOptionPane.showMessageDialog(this, "Added to cart!");

                        } catch (NumberFormatException ex) {
                                JOptionPane.showMessageDialog(this, "Please enter a valid quantity!");
                        }
                }

                void updateCartTable() {
                        cartModel.setRowCount(0);
                        for (CartItem item : cart) {
                                cartModel.addRow(new Object[] {
                                                item.product.id, item.product.name, item.product.price, item.quantity,
                                                item.getTotal()
                                });
                        }
                }

                void generateBill() {
                        if (cart.isEmpty()) {
                                JOptionPane.showMessageDialog(this, "Cart is empty.");
                                return;
                        }

                        bill.clear();
                        double subtotal = 0;

                        for (CartItem item : cart) {
                                double total = item.getTotal();
                                bill.put(item.product.name, total);
                                subtotal += total;
                        }

                        double tax = subtotal * 0.18;
                        double grandTotal = subtotal + tax;

                        StringBuilder output = new StringBuilder();
                        output.append("====================================\n");
                        output.append("          SHOPPING BILL\n");
                        output.append("====================================\n");
                        output.append(String.format("%-18s %-8s %-8s\n", "Product", "Qty", "Amount"));
                        output.append("------------------------------------\n");

                        for (String productName : bill.keySet()) {
                                double amount = bill.get(productName);
                                int quantity = 0;

                                for (CartItem item : cart) {
                                        if (item.product.name.equals(productName)) {
                                                quantity = item.quantity;
                                                break;
                                        }
                                }
                                output.append(String.format("%-18s %-8d ₹%-8.2f\n", productName, quantity, amount));
                        }

                        output.append("------------------------------------\n");
                        output.append(String.format("%-25s ₹%.2f\n", "Subtotal:", subtotal));
                        output.append(String.format("%-25s ₹%.2f\n", "GST (18%):", tax));
                        output.append(String.format("%-25s ₹%.2f\n", "Grand Total:", grandTotal));
                        output.append("====================================\n");
                        output.append("       Thank You! Visit Again!\n");
                        output.append("====================================\n");

                        billArea.setText(output.toString());
                        cart.clear();
                        updateCartTable();
                }
        }

        public static void main(String[] args) {
                SwingUtilities.invokeLater(() -> new shopping().new ShoppingUI());
        }
}
