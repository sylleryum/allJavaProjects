import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

/*public class Shortcut {
    public static void main(String[] args) {
        JFrame f = new JFrame();
        f.setSize(new Dimension(410, 330));
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.getContentPane().setLayout(null);
        JPanel panel = new JPanel();
        panel.setBackground(Color.GREEN);
        panel.setBounds(50, 50, 300, 200);

        panel.addKeyListener(new MyKeyListener()); // add KeyListener
        panel.setFocusable(true); // set focusable to true
        panel.requestFocusInWindow(); // request focus

        f.getContentPane().add(panel);
        f.setVisible(true);
    }*/

    public class Shortcut extends KeyAdapter {
        
        @Override
        public void keyPressed(KeyEvent e) {
            if (e.getKeyCode() == KeyEvent.VK_DELETE) {
                // delete row method (when "delete" is pressed)
                System.out.println("Key \"Delete\" Pressed");
            }
        }

        
    }
