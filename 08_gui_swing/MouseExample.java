
import java.awt.event.*;
import javax.swing.*;

public class MouseExample {
    public static void main(String[] args) {

        JFrame frame = new JFrame("Mouse Example");

        JLabel label = new JLabel("Click ME");
        label.setBounds(100, 100, 100, 30);

        label.addMouseListener(new MouseListener() {

            public void mouseClicked(MouseEvent e) {
                System.out.println("Mouse Clicked");
            }

            public void mousePressed(MouseEvent e) {
                System.out.println("Mouse Pressed");
            }

            public void mouseReleased(MouseEvent e) {
                System.out.println("Mouse Released");
            }

            public void mouseEntered(MouseEvent e) {
                System.out.println("Mouse Entered");
            }

            public void mouseExited(MouseEvent e) {
                System.out.println("Mouse Exited");
            }
        });

        frame.add(label);

        frame.setSize(300, 250);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
