import java.awt.event.*;
import javax.swing.*;

public class KeyEventDemo {

    public static void main(String[] args) {

        JFrame frame = new JFrame("Keyboard Example");

        JTextField field = new JTextField();
        field.setBounds(50, 50, 200, 30);

        field.addKeyListener(new KeyListener() {

            @Override
            public void keyPressed(KeyEvent e) {
                System.out.println("Key Pressed");
            }

            @Override
            public void keyReleased(KeyEvent e) {
                System.out.println("Key Released");
            }

            @Override
            public void keyTyped(KeyEvent e) {
                System.out.println("Key Typed");
            }
        });

        frame.add(field);

        frame.setSize(300, 250);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}