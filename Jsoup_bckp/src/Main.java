import java.awt.EventQueue;
import java.io.IOException;

import org.jsoup.Connection;
import org.jsoup.Connection.Response;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import java.awt.TextArea;
import javax.swing.*;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Font;
import java.awt.datatransfer.*;
import java.awt.Toolkit;
import org.eclipse.wb.swing.FocusTraversalOnArray;
import java.awt.Component;

public class Main {

	private JFrame frame;
	private JTextField txtCai;
	private String textCai, textSummary;
	private JLabel lblNewLabel;
	private JTextField txtSummary;
	private JButton btnSummary;
	private JTextArea txtaNotesReady;
	private JTextField txtSumReady;
	private String notes="";
	private JButton btnCSummary;
	private String SumReady="";
	private String nReady;
	private JButton btnNSummary;
	private JTextArea txtaNotes;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main window = new Main();
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
	public Main() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 873, 577);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel lblStatus = new JLabel("");
		lblStatus.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblStatus.setHorizontalAlignment(SwingConstants.CENTER);
		lblStatus.setBounds(677, 474, 170, 53);
		frame.getContentPane().add(lblStatus);

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
		frame.getContentPane().add(txtCai);
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
		frame.getContentPane().add(btnGet);

		txtSummary = new JTextField();
		

		txtSummary.setText("Summary");
		txtSummary.setToolTipText("Summary");
		txtSummary.setBounds(10, 11, 374, 20);
		frame.getContentPane().add(txtSummary);
		txtSummary.setColumns(10);

		btnSummary = new JButton("Get Summary");
		btnSummary.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textSummary = txtSummary.getText();
				String txtTest = textSummary + "//hou//111";
				lblStatus.setText(txtTest);
				txtaNotesReady.setText(txtTest);
			}
		});
		btnSummary.setBounds(161, 453, 113, 23);
		frame.getContentPane().add(btnSummary);

		txtaNotesReady = new JTextArea();
		txtaNotesReady.setBounds(400, 42, 374, 290);
		frame.getContentPane().add(txtaNotesReady);

		txtSumReady = new JTextField();
		txtSumReady.setText("Summary ready");
		txtSumReady.setBounds(400, 11, 374, 20);
		frame.getContentPane().add(txtSumReady);
		txtSumReady.setColumns(10);
		
		btnCSummary = new JButton("Get");
		btnCSummary.setHorizontalAlignment(SwingConstants.LEFT);
		btnCSummary.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {				
				StringSelection stringSelection = new StringSelection(SumReady);
				Clipboard clpbrd = Toolkit.getDefaultToolkit().getSystemClipboard();
				clpbrd.setContents(stringSelection, null);
			}
		});
		btnCSummary.setBounds(784, 10, 49, 23);
		frame.getContentPane().add(btnCSummary);
		
		btnNSummary = new JButton("Get");
		btnNSummary.setHorizontalAlignment(SwingConstants.LEFT);
		btnNSummary.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StringSelection stringSelection = new StringSelection(nReady);
				Clipboard clpbrd = Toolkit.getDefaultToolkit().getSystemClipboard();
				clpbrd.setContents(stringSelection, null);
				
			}
		});
		btnNSummary.setBounds(784, 43, 49, 23);
		frame.getContentPane().add(btnNSummary);
		
		txtaNotes = new JTextArea();
		txtaNotes.setText("Problem description: \r\nTroubleshooting performed: ");
		txtaNotes.setBounds(10, 42, 374, 290);
		frame.getContentPane().add(txtaNotes);
		frame.getContentPane().setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{txtSummary, txtaNotes, txtCai, btnGet, lblStatus, btnSummary, txtaNotesReady, txtSumReady, btnCSummary, btnNSummary}));
		frame.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{txtSummary, txtaNotes, btnGet, frame.getContentPane(), lblStatus, txtCai, btnSummary, txtaNotesReady, txtSumReady, btnCSummary, btnNSummary}));
	}
}
