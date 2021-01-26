import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.KeyStroke;
import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JComponent;

import java.awt.event.ActionEvent;
import java.awt.event.InputEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import org.eclipse.wb.swing.FocusTraversalOnArray;
import java.awt.Component;

public class Test {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Test window = new Test();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Test() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnGet = new JButton("get");
		/*btnGet.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_DELETE) {
	                // delete row method (when "delete" is pressed)
	                System.out.println("Key \"Delete\" Pressed");
	            }
			}
		});*/
		btnGet.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_X, InputEvent.CTRL_DOWN_MASK), "evento");
		btnGet.getActionMap().put("evento", new AbstractAction(){
	         @Override
	         public void actionPerformed(ActionEvent e){	            
	        	 System.out.println("test");
	         }
	      });
		btnGet.setBounds(183, 46, 89, 23);
		frame.getContentPane().add(btnGet);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_DELETE) {
	                // delete row method (when "delete" is pressed)
	                System.out.println("Key \"Delete\" Pressed");
	            }
			}
		});
		btnNewButton.setBounds(10, 108, 89, 23);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("New button");
		btnNewButton_1.setBounds(93, 167, 89, 23);
		frame.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("New button");
		btnNewButton_2.setBounds(72, 46, 89, 23);
		frame.getContentPane().add(btnNewButton_2);
		frame.getContentPane().setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{btnNewButton, btnGet}));
		frame.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{btnNewButton, frame.getContentPane(), btnGet}));
	}
}
