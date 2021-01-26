import java.awt.EventQueue;
import java.io.IOException;

import org.jsoup.Connection;
import org.jsoup.Connection.Response;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import java.awt.TextArea;
import javax.swing.*;
import javax.xml.crypto.dom.DOMCryptoContext;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Font;
import java.awt.KeyboardFocusManager;
import java.awt.datatransfer.*;
import java.awt.Toolkit;
import org.eclipse.wb.swing.FocusTraversalOnArray;

import java.awt.BorderLayout;
import java.awt.Component;

public class Main {

	private JFrame frmTicketGenerator;
	private JTextField txtCai;
	private String textCai, textSummary;
	private JLabel lblNewLabel;
	private JTextField txtSummary;
	private JTextArea txtaNotesReady;
	private JTextField txtSumReady;
	private String notes="";
	private JButton btnCSummary;
	private String SumReady="";
	private String nReady;
	private JButton btnNSummary;
	private JTextArea txtaNotes;
	private JButton btnClear;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try{
			Document docConec = Jsoup.connect("http://www.htmlgoodies.com/tutorials/html_401/article.php/3479661").get();
			//docConec = null;
		} catch (IOException e2){
			JOptionPane.showMessageDialog(null, "\nError! \nEither: \n1- You are not connected to a Chevron network\n"
					+ "2- The connection wasn't established successfuly");
			System.exit(0);
			//e1.printStackTrace();
		}		

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
		lblStatus.setBounds(677, 474, 170, 53);
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
					/*Document doc = Jsoup.connect(
							"https://whitepages.chevron.com/popuppages/PersonDetails.aspx?cai=" + txtCai.getText()).get();
					
					String jName = doc.select("span[ID=lblPreferredName]").text();
					String jCai = doc.select("span[ID=lblCAI]").text();
					String jCtn = doc.select("span[ID=lblCTN]").text();
					String jLoc1 = doc.select("span[ID=lblBuildingName]").text();
					String jRoom = doc.select("span[ID=lblRoom]").text();
					String jFac = doc.select("span[ID=lblFacility]").text();
					String jLPhone = doc.select("span[ID=lblLongPhoneNumber]").text();
					String jMobile = doc.select("span[ID=lblMobile]").text();
					String phone = "";*/
					
					//=test code
					//3479661
					 Document doc = Jsoup.connect(
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
					 String phone = "";
					
					
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
					nReady = (txtaNotes.getText()+"\n"
							+ "User: "+jName+" ("+jCai+")"+"\n"
							+ "Phone: "+phone+"\n"
							+ "Location: "+jLoc1+" "+jRoom+"\n"
							+ "");
					txtaNotesReady.setText(nReady);
												
								
					 
				} catch (IOException e1) {
					
					e1.printStackTrace();					
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
        
		txtaNotes.setFocusTraversalKeys(KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS, null);
		txtaNotes.setFocusTraversalKeys(KeyboardFocusManager.BACKWARD_TRAVERSAL_KEYS, null);
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
				
			}
		});
		btnClear.setBounds(400, 342, 83, 23);
		frmTicketGenerator.getContentPane().add(btnClear);
		frmTicketGenerator.getContentPane().setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{txtSummary, txtaNotes, txtCai, btnGet, btnCSummary, btnNSummary, lblStatus, txtaNotesReady, txtSumReady}));
		frmTicketGenerator.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{txtSummary, txtaNotes, txtCai, btnGet, btnCSummary, btnNSummary, frmTicketGenerator.getContentPane(), lblStatus, txtaNotesReady, txtSumReady}));
		
	}
}
