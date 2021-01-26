//import org.jsoup.Connection;
//import org.jsoup.Connection.Response;
//import java.awt.TextArea;
//import javax.xml.crypto.dom.DOMCryptoContext;
//import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.io.IOException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.Font;
import java.awt.KeyboardFocusManager;
import java.awt.datatransfer.*;
import java.awt.Toolkit;
import org.eclipse.wb.swing.FocusTraversalOnArray;
import java.awt.Component;

public class Main{

	private JFrame frmTicketGenerator;
	private JTextField txtCai;
	private JTextField txtSummary;
	private JTextArea txtaNotesReady;
	private JTextField txtSumReady;	
	private JButton btnCSummary;
	private String SumReady="";
	private String nReady;
	private JButton btnNSummary;
	private JTextArea txtaNotes;
	private JButton btnClear;

	//private String textCai, textSummary;
	//private JLabel lblNewLabel;
	//private String notes="";
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		/*try{
			@SuppressWarnings("unused")
			Document docConec = Jsoup.connect("http://www.htmlgoodies.com/tutorials/html_401/article.php/3479661").get();
			//docConec = null;
		} catch (IOException e2){
			JOptionPane.showMessageDialog(null, "\nError! \nEither: \n1- You are not connected to a Chevron network\n"
					+ "2- The connection wasn't established successfuly");
			System.exit(0);
			//e1.printStackTrace();
		}*/		

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main window = new Main();
					window.frmTicketGenerator.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Main() {
		initialize();
/*		btnClear.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_X, InputEvent.CTRL_DOWN_MASK), "evento");
		btnClear.getActionMap().put("evento", new AbstractAction(){
	         @Override
	         public void actionPerformed(ActionEvent e){	            
	        	 System.out.println("test");
	         }
	      });*/
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmTicketGenerator = new JFrame();
		frmTicketGenerator.setIconImage(Toolkit.getDefaultToolkit().getImage(Main.class.getResource("/Resources/!iicon.png")));
		frmTicketGenerator.setTitle("Ticket Generator");
		frmTicketGenerator.setBounds(100, 100, 873, 577);
		frmTicketGenerator.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmTicketGenerator.getContentPane().setLayout(null);
		
		

		JLabel lblStatus = new JLabel("");
		lblStatus.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblStatus.setHorizontalAlignment(SwingConstants.CENTER);
		lblStatus.setBounds(718, 474, 129, 53);
		frmTicketGenerator.getContentPane().add(lblStatus);

		txtCai = new JTextField();
		txtCai.setToolTipText("CAI");
		txtCai.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txtCai.setText("");
			}
		});
		
		
		txtCai.setText("CAI");

		txtCai.setBounds(10, 343, 251, 20);
		frmTicketGenerator.getContentPane().add(txtCai);
		txtCai.setColumns(10);
		

		JButton btnGet = new JButton("Submit");
		
		btnGet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				/*
				 * textCai = textFieldCai.getText();
				 * lblNewLabel.setText(textCai);
				 * txtSummaryReady.setText(textCai);
				 */
				
				
				try {
					//**************************Summary**************************
					//=pega dados
					Document doc = Jsoup.connect(
							"https://whitepages.chevron.com/popuppages/PersonDetails.aspx?cai=" + txtCai.getText()).get();
					
					String jName = doc.select("span[ID=lblPreferredName]").text();
					String jCai = doc.select("span[ID=lblCAI]").text();
					String jCtn = doc.select("span[ID=lblCTN]").text();
					String jLoc1 = doc.select("span[ID=lblBuildingName]").text();
					String jRoom = doc.select("span[ID=lblRoom]").text();
					String jFac = doc.select("span[ID=lblFacility]").text();
					String jLPhone = doc.select("span[ID=lblLongPhoneNumber]").text();
					String jMobile = doc.select("span[ID=lblMobile]").text();
					String phone = "";
					
					//=test code
					//3479661
//					 Document doc = Jsoup.connect(
//					 "http://www.htmlgoodies.com/tutorials/html_401/article.php/" +txtCai.getText()).get(); 
//					 String titl = doc.select("span[ID=newtext2]").text();
//					 txtCai.setText(titl);
//					 String jName = "carlito";
//					 String jCai = "caca";
//					 String jCtn = "145-5415";
//					 String jLoc1 = "Houston floor";
//					 String jRoom = "1461D";
//					 String jFac = "hou150";
//					 String jLPhone = "";
//					 String jMobile = "+1 99587456"; 	 
//					 String phone = "";
					
					
					lblStatus.setText("Success!");
					//Fim dados				
					
					//=monta summary
					if (jCtn == "" && jLPhone==""){//soh mobile
						SumReady = txtSummary.getText()+"//"+jFac+" "+jRoom+"//"+jMobile;
						phone = jMobile;
					} else if (jCtn ==""){//long phone
						SumReady = txtSummary.getText()+"//"+jFac+" "+jRoom+"//"+jLPhone;
						phone = jLPhone;
					} else {//normal
						SumReady = txtSummary.getText()+"//"+jFac+" "+jRoom+"//"+jCtn;
						phone = jCtn;
					}
					txtSumReady.setText(SumReady);

					//**************************Notes**************************
					nReady = ("User: "+jName+" ("+jCai+")"+"\n"
							+ "Phone: "+phone+"\n"
							+ "Location: "+jLoc1+" "+jRoom+"\n\n"
							+ txtaNotes.getText()+"\n");
					txtaNotesReady.setText(nReady);
												
								
					 
				} catch (IOException e1) {
					
					e1.printStackTrace();
					nReady = ("User: \n"
							+ "Phone: \n"
							+ "Location: \n\n"
							+ txtaNotes.getText()+"\n");
					txtaNotesReady.setText(nReady);
					lblStatus.setText("CAI not found");
				}

			}
		});
		btnGet.setBounds(271, 342, 113, 23);
		frmTicketGenerator.getContentPane().add(btnGet);

		txtSummary = new JTextField();
		txtSummary.setText("Summary");
		txtSummary.setToolTipText("Summary");
		txtSummary.setBounds(10, 11, 374, 20);
		frmTicketGenerator.getContentPane().add(txtSummary);
		txtSummary.setColumns(10);
		
		txtaNotesReady = new JTextArea();
		txtaNotesReady.setLineWrap(true);
		txtaNotesReady.setWrapStyleWord(true);
		txtaNotesReady.setBounds(400, 42, 374, 290);
		frmTicketGenerator.getContentPane().add(txtaNotesReady);

		txtSumReady = new JTextField();
		txtSumReady.setText("Summary ready");
		txtSumReady.setBounds(400, 11, 374, 20);
		frmTicketGenerator.getContentPane().add(txtSumReady);
		txtSumReady.setColumns(10);
		
		btnCSummary = new JButton("Get");
		btnCSummary.setToolTipText("|Copy to Clipboard");
		btnCSummary.setHorizontalAlignment(SwingConstants.LEFT);
		btnCSummary.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {				
				StringSelection stringSelection = new StringSelection(txtSumReady.getText());
				Clipboard clpbrd = Toolkit.getDefaultToolkit().getSystemClipboard();
				clpbrd.setContents(stringSelection, null);
			}
		});
		btnCSummary.setBounds(784, 10, 63, 23);
		frmTicketGenerator.getContentPane().add(btnCSummary);
		
		btnNSummary = new JButton("Get");
		btnNSummary.setToolTipText("|Copy to Clipboard");
		btnNSummary.setHorizontalAlignment(SwingConstants.LEFT);
		btnNSummary.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StringSelection stringSelection = new StringSelection(txtaNotesReady.getText());
				Clipboard clpbrd = Toolkit.getDefaultToolkit().getSystemClipboard();
				clpbrd.setContents(stringSelection, null);
				
			}
		});
		btnNSummary.setBounds(784, 43, 63, 23);
		frmTicketGenerator.getContentPane().add(btnNSummary);
		
		txtaNotes = new JTextArea();
		txtaNotes.setWrapStyleWord(true);
		txtaNotes.setLineWrap(true);
        
		txtaNotes.setFocusTraversalKeys(KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS, null);
		txtaNotes.setFocusTraversalKeys(KeyboardFocusManager.BACKWARD_TRAVERSAL_KEYS, null);
		txtaNotesReady.setFocusTraversalKeys(KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS, null);
		txtaNotesReady.setFocusTraversalKeys(KeyboardFocusManager.BACKWARD_TRAVERSAL_KEYS, null);
		txtaNotes.setText("Problem description: \r\nTroubleshooting performed: ");
		txtaNotes.setCaretPosition(21);
		txtaNotes.setBounds(10, 42, 374, 290);
		frmTicketGenerator.getContentPane().add(txtaNotes);
		btnClear = new JButton("Clear");
		
		btnClear.setToolTipText("Clear Fields");
		
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//--------------------------------------
				txtaNotes.setText("Problem description: \r\nTroubleshooting performed: ");
				txtSummary.setText("");
				txtaNotes.setCaretPosition(21);
				
			}		
		});
		//set keys
		txtSummary.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_F1, 0), "summary");
		txtSummary.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_F2, 0), "notes");
		txtSummary.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_F3, 0), "cai");
		txtSummary.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_1, KeyEvent.CTRL_DOWN_MASK), "copySum");
		txtSummary.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_2, KeyEvent.CTRL_DOWN_MASK), "copyNotes");
		txtSummary.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_R, KeyEvent.CTRL_DOWN_MASK), "clear");
		txtSummary.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, KeyEvent.CTRL_DOWN_MASK), "get");
		
		txtSummary.getActionMap().put("copySum", new AbstractAction(){
	         @Override
	         public void actionPerformed(ActionEvent e){	            
	        	 System.out.println("copySum");
	        	 StringSelection stringSelection = new StringSelection(txtSumReady.getText());
				 Clipboard clpbrd = Toolkit.getDefaultToolkit().getSystemClipboard();
				 clpbrd.setContents(stringSelection, null);
	         }
	      });
		
		txtSummary.getActionMap().put("copyNotes", new AbstractAction(){
	         @Override
	         public void actionPerformed(ActionEvent e){	            
	        	 System.out.println("copyNotes");
	        	 StringSelection stringSelection = new StringSelection(txtaNotesReady.getText());
				 Clipboard clpbrd = Toolkit.getDefaultToolkit().getSystemClipboard();
				 clpbrd.setContents(stringSelection, null);
	         }
	      });
		
		txtSummary.getActionMap().put("summary", new AbstractAction(){
	         @Override
	         public void actionPerformed(ActionEvent e){	            
	        	 System.out.println("summary");
	        	 txtSummary.setCaretPosition(0);
	        	 txtSummary.grabFocus();
	         }
	      });
		
		txtSummary.getActionMap().put("clear", new AbstractAction(){
	         @Override
	         public void actionPerformed(ActionEvent e){	            
	        	 System.out.println("clear");
	        	 txtaNotes.setText("Problem description: \r\nTroubleshooting performed: ");
				 txtSummary.setText("");
				 txtaNotes.setCaretPosition(21);
	         }
	      });
		
		txtSummary.getActionMap().put("notes", new AbstractAction(){
	         @Override
	         public void actionPerformed(ActionEvent e){	            
	        	 System.out.println("notes");
	        	 txtaNotes.setCaretPosition(21);
	        	 txtaNotes.grabFocus();
	         }
	      });
		txtSummary.getActionMap().put("cai", new AbstractAction(){
	         @Override
	         public void actionPerformed(ActionEvent e){	            
	        	 System.out.println("cai");
	        	 txtCai.setCaretPosition(0);
	        	 txtCai.grabFocus();
	         }
	      });
		
		txtSummary.getActionMap().put("get", new AbstractAction(){
	         @Override
	         public void actionPerformed(ActionEvent e){	            
	        	 System.out.println("get");
	        	 try {
						//**************************Summary**************************
						//=pega dados
						Document doc = Jsoup.connect(
								"https://whitepages.chevron.com/popuppages/PersonDetails.aspx?cai=" + txtCai.getText()).get();
						
						String jName = doc.select("span[ID=lblPreferredName]").text();
						String jCai = doc.select("span[ID=lblCAI]").text();
						String jCtn = doc.select("span[ID=lblCTN]").text();
						String jLoc1 = doc.select("span[ID=lblBuildingName]").text();
						String jRoom = doc.select("span[ID=lblRoom]").text();
						String jFac = doc.select("span[ID=lblFacility]").text();
						String jLPhone = doc.select("span[ID=lblLongPhoneNumber]").text();
						String jMobile = doc.select("span[ID=lblMobile]").text();
						String phone = "";
						
						//=test code
						//3479661
						 /*Document doc = Jsoup.connect(
						 "http://www.htmlgoodies.com/tutorials/html_401/article.php/" +txtCai.getText()).get(); 
						 String titl = doc.select("span[ID=newtext2]").text();
						 txtCai.setText(titl);
						 String jName = "carlito";
						 String jCai = "caca";
						 String jCtn = "145-5415";
						 String jLoc1 = "Houston floor";
						 String jRoom = "1461D";
						 String jFac = "hou150";
						 String jLPhone = "";
						 String jMobile = "+1 99587456"; 	 
						 String phone = "";*/
						
						
						lblStatus.setText("Success!");
						//Fim dados				
						
						//=monta summary
						if (jCtn == "" && jLPhone==""){//soh mobile
							SumReady = txtSummary.getText()+"//"+jFac+" "+jRoom+"//"+jMobile;
							phone = jMobile;
						} else if (jCtn ==""){//long phone
							SumReady = txtSummary.getText()+"//"+jFac+" "+jRoom+"//"+jLPhone;
							phone = jLPhone;
						} else {//normal
							SumReady = txtSummary.getText()+"//"+jFac+" "+jRoom+"//"+jCtn;
							phone = jCtn;
						}
						txtSumReady.setText(SumReady);

						//**************************Notes**************************
						nReady = ("User: "+jName+" ("+jCai+")"+"\n"
								+ "Phone: "+phone+"\n"
								+ "Location: "+jLoc1+" "+jRoom+"\n\n"
								+ txtaNotes.getText()+"\n");
						txtaNotesReady.setText(nReady);
													
									
						 
					} catch (IOException e1) {
						
						e1.printStackTrace();
						nReady = ("User: \n"
								+ "Phone: \n"
								+ "Location: \n\n"
								+ txtaNotes.getText()+"\n");
						txtaNotesReady.setText(nReady);
						lblStatus.setText("CAI not found");
					}
	        	 
	         }
	      });
		//
		btnClear.setBounds(400, 342, 83, 23);
		frmTicketGenerator.getContentPane().add(btnClear);
		
		JLabel lblVersion = new JLabel("Version 1.2");
		lblVersion.setBounds(10, 513, 173, 14);
		frmTicketGenerator.getContentPane().add(lblVersion);
		
		JLabel lblShortcuts = new JLabel("Shortcuts");
		lblShortcuts.setForeground(Color.BLUE);
		lblShortcuts.setToolTipText("<html>"
                + "F1 = Summary <br>"
                + "F2 = Notes <br>"
                + "F3 = CAI <br>"
                + "CTRL + Enter = Submit <br>"
                + "CTRL + 1 = Copy Summary ready for the clipboard <br>"
                + "CTRL + 2 = Copy Notes ready for the clipboard <br>"
                + "CTRL + R = Clear fields"
           + "</html>");
		//("F1 = Summary \n\r\nF2 = Notes\r\nF3 = CAI\r\nCTRL + Enter = Submit\r\nCTRL + 1 = Copy Summary ready for the clipboard\r\nCTRL + 2 = Copy Notes ready for the clipboard\r\nCTRL + R = Clear fields");
		lblShortcuts.setBounds(784, 77, 63, 14);
		frmTicketGenerator.getContentPane().add(lblShortcuts);
		frmTicketGenerator.getContentPane().setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{txtSummary, txtaNotes, txtCai, btnGet, txtSumReady, txtaNotesReady, btnCSummary, btnNSummary}));
		frmTicketGenerator.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{txtSummary, txtaNotes, txtCai, btnGet, txtSumReady, txtaNotesReady, btnCSummary, btnNSummary}));
		
	}
}


