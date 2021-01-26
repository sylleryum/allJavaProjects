package application;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.format.DateTimeFormatter;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Control;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;

public class Controller implements Initializable {

	ObservableList<String> options = FXCollections.observableArrayList("Codigo", "Nome", "Cidade");
	@FXML
	private Button btnSave;
	@FXML
	private Button btnGetInfo;
	@FXML
	private ComboBox<ParseKb> comboKb;
	@FXML
	private TextArea txtaGetInfo;
	@FXML
	private ListView<Ticket> listHistory;
	@FXML
	private TextField txtCai;
	@FXML
	private TextField txtSummary;
	@FXML
	private TextField txtKb;
	@FXML
	private Button btnNotepad;
	@FXML
	private CheckBox checkDetail;
	@FXML
	private AnchorPane mainScene;
	@FXML
	private Button btnEdit;
	@FXML
	private Button btnDelete;
	@FXML
	private Button btnClear;
	@FXML
	private Label lblStatus;
	@FXML
	private Label lblShortcut;
	@FXML
	private Label lblDs;
	@FXML
	private Button btnCaiClear;
	String txtaCb = "";
	//private static String kBFilename = "C:\\temp\\kbs.txt";
	private static String kBFilename = "\\\\HOUHCLGIL4VM60\\OneNote Chevron Base HCL\\Ticket generator\\kbs.txt";
	// private static String ticketFileName =
	// "\\\\10.0.0.2\\temp\\ticketlog.txt";
	private static String ticketFileName = "C:\\temp\\ticketlog.txt";
	// private static String ticketFileName = "\\\\HOUHCLGIL4VM60\\OneNote
	// Chevron Base HCL\\Ticket generator\\ticketlog.txt";

	private ObservableList<ParseKb> kbList = FXCollections.observableArrayList();
	private ObservableList<Ticket> ticketList = FXCollections.observableArrayList();

	// 3479661

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		// C:\\temp\\TodoListItems.txt

		Path path = Paths.get(kBFilename);
		String input;
		try {
			// read file and put on the combobox
			BufferedReader br = Files.newBufferedReader(path);
			while ((input = br.readLine()) != null) {
				String[] itemPieces = input.split("\t");
				String kb = itemPieces[0];
				String link = itemPieces[1];
				ParseKb parseKb = new ParseKb(kb, link);
				kbList.add(parseKb);
			}

		} catch (IOException e) {
			System.out.println("wtf?");
			e.printStackTrace();

			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Exception Dialog");
			alert.setHeaderText("Look, an Exception Dialog");
			alert.setContentText("IOException");

			Exception ex = new FileNotFoundException("IOException");

			// Create expandable Exception.
			StringWriter sw = new StringWriter();
			PrintWriter pw = new PrintWriter(sw);
			ex.printStackTrace(pw);
			String exceptionText = sw.toString();

			Label label = new Label("The exception stacktrace was:");

			TextArea textArea = new TextArea(exceptionText);
			textArea.setEditable(false);
			textArea.setWrapText(true);

			textArea.setMaxWidth(Double.MAX_VALUE);
			textArea.setMaxHeight(Double.MAX_VALUE);
			GridPane.setVgrow(textArea, Priority.ALWAYS);
			GridPane.setHgrow(textArea, Priority.ALWAYS);

			GridPane expContent = new GridPane();
			expContent.setMaxWidth(Double.MAX_VALUE);
			expContent.add(label, 0, 0);
			expContent.add(textArea, 0, 1);

			// Set expandable Exception into the dialog pane.
			alert.getDialogPane().setExpandableContent(expContent);

			alert.showAndWait();

		}
		// put list on the CB
		comboKb.setItems(kbList);
		comboKb.getSelectionModel().selectedIndexProperty().addListener((v, oldValue, newValue) -> {
			
			txtKb.setText(comboKb.getValue().getLink());
			txtKb.setTooltip(new Tooltip(txtKb.getText()));
			txtaCb = txtaGetInfo.getText() + "\n" + comboKb.getValue().getLink();
			txtaGetInfo.setText(txtaCb);
		});

		FxUtilTest.autoCompleteComboBoxPlus(comboKb,
				(typedText, itemToCompare) -> itemToCompare.getKb().toLowerCase().contains(typedText.toLowerCase())
						|| itemToCompare.getKb().toString().equals(typedText));
		FxUtilTest.getComboBoxValue(comboKb);

		// Shortcut save
		mainScene.addEventFilter(KeyEvent.KEY_PRESSED, new EventHandler<KeyEvent>() {
			final KeyCombination keyComb = new KeyCodeCombination(KeyCode.S, KeyCombination.CONTROL_DOWN);

			public void handle(KeyEvent ke) {
				if (keyComb.match(ke)) {
					try {
						saveTicket();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		});

		// tooltips
		// txtCai.setTooltip(new Tooltip("CTRL + 1"));
		// txtSummary.setTooltip(new Tooltip("CTRL + 2"));
		// comboKb.setTooltip(new Tooltip("CTRL + 3"));
		// txtaGetInfo.setTooltip(new Tooltip("CTRL + 4"));
		// btnSave.setTooltip(new Tooltip("CTRL + S"));
		// btnDelete.setTooltip(new Tooltip("CTRL + D"));
		// btnEdit.setTooltip(new Tooltip("CTRL + E"));;
		// btnClear.setTooltip(new Tooltip("CTRL + C"));
		lblShortcut.setTooltip(new Tooltip("CTRL + 1 = Go to CAI Field \n" + "CTRL + 2 = Go to Summary Field \n"
				+ "CTRL + 3 = Go to Select KB Field \n" + "CTRL + 4 = Go to Notes Field \n"
				+ "CTRL + S = Save ticket \n" + "CTRL + D = Delete selected ticket \n"
				+ "CTRL + E = Edit selected ticket \n" + "CTRL + B = Clear all fields \n"));

		// Shortcut clear
		mainScene.addEventFilter(KeyEvent.KEY_PRESSED, new EventHandler<KeyEvent>() {
			final KeyCombination keyComb = new KeyCodeCombination(KeyCode.B, KeyCombination.CONTROL_DOWN);

			public void handle(KeyEvent ke) {
				if (keyComb.match(ke)) {
					clearAll();
				}
			}
		});

		// Shortcut edit
		mainScene.addEventFilter(KeyEvent.KEY_PRESSED, new EventHandler<KeyEvent>() {
			final KeyCombination keyComb = new KeyCodeCombination(KeyCode.E, KeyCombination.CONTROL_DOWN);

			public void handle(KeyEvent ke) {
				if (keyComb.match(ke)) {
					clearAll();
				}
			}
		});

		// Shortcut delete
		mainScene.addEventFilter(KeyEvent.KEY_PRESSED, new EventHandler<KeyEvent>() {
			final KeyCombination keyComb = new KeyCodeCombination(KeyCode.D, KeyCombination.CONTROL_DOWN);

			public void handle(KeyEvent ke) {
				if (keyComb.match(ke)) {
					try {
						deleteTicket();
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		});

		// Shortcut get info
		mainScene.addEventFilter(KeyEvent.KEY_PRESSED, new EventHandler<KeyEvent>() {
			final KeyCombination keyComb = new KeyCodeCombination(KeyCode.ENTER, KeyCombination.CONTROL_DOWN);

			public void handle(KeyEvent ke) {
				if (keyComb.match(ke)) {
					getResults();
				}
			}
		});

		// Shortcut go to txtCai
		mainScene.addEventFilter(KeyEvent.KEY_PRESSED, new EventHandler<KeyEvent>() {
			final KeyCombination keyComb = new KeyCodeCombination(KeyCode.DIGIT1, KeyCombination.CONTROL_DOWN);

			public void handle(KeyEvent ke) {
				if (keyComb.match(ke)) {
					txtCai.requestFocus();
				}
			}
		});

		// Shortcut go to txtSummary
		mainScene.addEventFilter(KeyEvent.KEY_PRESSED, new EventHandler<KeyEvent>() {
			final KeyCombination keyComb = new KeyCodeCombination(KeyCode.DIGIT2, KeyCombination.CONTROL_DOWN);

			public void handle(KeyEvent ke) {
				if (keyComb.match(ke)) {
					txtSummary.requestFocus();
				}
			}
		});

		// Shortcut go to cbKB
		mainScene.addEventFilter(KeyEvent.KEY_PRESSED, new EventHandler<KeyEvent>() {
			final KeyCombination keyComb = new KeyCodeCombination(KeyCode.DIGIT3, KeyCombination.CONTROL_DOWN);

			public void handle(KeyEvent ke) {
				if (keyComb.match(ke)) {
					comboKb.requestFocus();
				}
			}
		});

		// Shortcut go to txtagetinfo
		mainScene.addEventFilter(KeyEvent.KEY_PRESSED, new EventHandler<KeyEvent>() {
			final KeyCombination keyComb = new KeyCodeCombination(KeyCode.DIGIT4, KeyCombination.CONTROL_DOWN);

			public void handle(KeyEvent ke) {
				if (keyComb.match(ke)) {
					txtaGetInfo.requestFocus();
				}
			}
		});

		Path pathLv = Paths.get(ticketFileName);
		try {
			// load
			// read file and put on the listview
			BufferedReader br = Files.newBufferedReader(pathLv);
			while ((input = br.readLine()) != null) {
				String[] itemPieces = input.split("->\t");
				itemPieces[2] = itemPieces[2].replaceAll("thisisaspace", "\n");
				String cai = itemPieces[0];
				String summary = itemPieces[1];
				String notes = itemPieces[2];
				Ticket ticket = new Ticket(cai, summary, notes);
				ticketList.add(ticket);
			}

		} catch (Exception e) {
			System.out.println("o");

			e.printStackTrace();

			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Exception Dialog");
			alert.setHeaderText("Look, an Exception Dialog");
			alert.setContentText("Exception:");

			Exception ex = new FileNotFoundException("Exception: ");

			// Create expandable Exception.
			StringWriter sw = new StringWriter();
			PrintWriter pw = new PrintWriter(sw);
			ex.printStackTrace(pw);
			String exceptionText = sw.toString();

			Label label = new Label("The exception stacktrace was:");

			TextArea textArea = new TextArea(exceptionText);
			textArea.setEditable(false);
			textArea.setWrapText(true);

			textArea.setMaxWidth(Double.MAX_VALUE);
			textArea.setMaxHeight(Double.MAX_VALUE);
			GridPane.setVgrow(textArea, Priority.ALWAYS);
			GridPane.setHgrow(textArea, Priority.ALWAYS);

			GridPane expContent = new GridPane();
			expContent.setMaxWidth(Double.MAX_VALUE);
			expContent.add(label, 0, 0);
			expContent.add(textArea, 0, 1);

			// Set expandable Exception into the dialog pane.
			alert.getDialogPane().setExpandableContent(expContent);

			alert.showAndWait();
		}
		listHistory.getItems().setAll(ticketList);

		// get listview selection and handle it
		listHistory.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Ticket>() {
			@Override
			public void changed(ObservableValue<? extends Ticket> observable, Ticket oldValue, Ticket newValue) {
				if (newValue != null) {
					listHistory.setOnMouseClicked(new EventHandler<MouseEvent>() {
						@Override
						public void handle(MouseEvent event) {
							if (event.getButton() == MouseButton.PRIMARY && event.getClickCount() == 2) {
								Ticket item = listHistory.getSelectionModel().getSelectedItem();

								if ((txtCai.getLength() <= 0) && (txtSummary.getLength() <= 0)
										&& (txtaGetInfo.getLength() <= 0)) {
									txtCai.setText(item.getCai());
									txtSummary.setText(item.getSummary());
									txtaGetInfo.setText(item.getNotes());
								} else {
									Alert alert = new Alert(AlertType.CONFIRMATION);
									alert.setTitle("Overwrite?");
									alert.setHeaderText("Replace currently content?");

									Optional<ButtonType> result = alert.showAndWait();
									if (result.get() == ButtonType.OK) {
										txtCai.setText(item.getCai());
										txtSummary.setText(item.getSummary());
										txtaGetInfo.setText(item.getNotes());
									} else {
									}
								}
							}
						}
					});

				}
			}
		});

	}

	@FXML
	public void getResults() {
		// =test code
		// 3479661
		try {
			String SumReady;
			String details = "";
			if (checkDetail.isSelected()) {
				details = "Problem description: \n" + "Troubleshooting performed: \n";
			}
//			Document doc = Jsoup
//					.connect("https://whitepages.chevron.com/popuppages/PersonDetails.aspx?cai=" + txtCai.getText())
//					.get();
//
//			String jName = doc.select("span[ID=lblPreferredName]").text();
//			String jWorkCompany = doc.select("span[ID=lblWorkCompany]").text(); // 6246
//			String jHrBillingCode = doc.select("span[ID=lblHRBillingCompany]").text(); // 6246
//			String jItBillingCode = doc.select("span[ID=lblITBillingCompanyCode]").text(); // 6246
//			String jCai = doc.select("span[ID=lblCAI]").text();
//			String jCtn = doc.select("span[ID=lblCTN]").text();
//			String jLoc1 = doc.select("span[ID=lblBuildingName]").text();
//			String jRoom = doc.select("span[ID=lblRoom]").text();
//			String jFac = doc.select("span[ID=lblFacility]").text();
//			String jLPhone = doc.select("span[ID=lblLongPhoneNumber]").text();
//			String jMobile = doc.select("span[ID=lblMobile]").text();
//			String phone = "";

			// =test code
			// 3479661
			 Document doc = Jsoup
			 .connect("http://www.htmlgoodies.com/tutorials/html_401/article.php/"
			 + txtCai.getText()).get();
			 String titl = doc.select("span[ID=newtext2]").text();
			 txtCai.setText(titl);
			 String jItBillingCode = "624s";
			 String jWorkCompany = "62"; // 6246
			 String jHrBillingCode = "";
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

			String iTbillingReady = "";
			if (jItBillingCode.length() >= 4) {
				iTbillingReady = jItBillingCode.substring(0, 4);
			}

			String hRbillingReady = "";
			if (jHrBillingCode.length() >= 4) {
				hRbillingReady = jHrBillingCode.substring(0, 4);
			}

			String workBillingReady = "";
			if (jWorkCompany.length() >= 4) {
				workBillingReady = jWorkCompany.substring(0, 4);
			}
			
			//caso seja diferente
			Boolean dSproblem = false;
			if (iTbillingReady != "" && hRbillingReady != "") {
				if (!iTbillingReady.equalsIgnoreCase(hRbillingReady)) {
					lblDs.setText("!!!");
					dSproblem = true;
				}
			} else if (iTbillingReady != "" && workBillingReady != "") {
				if (!iTbillingReady.equalsIgnoreCase(workBillingReady)) {
					lblDs.setText("!!!");
					dSproblem = true;
				}
			} else if (hRbillingReady != "" && workBillingReady != "") {
				if (!hRbillingReady.equalsIgnoreCase(workBillingReady)) {
					lblDs.setText("!!!");
					dSproblem = true;
				}
			}
			
			if (!dSproblem) {
				if (iTbillingReady.equalsIgnoreCase("6246") || hRbillingReady.equalsIgnoreCase("6246")
						|| workBillingReady.equalsIgnoreCase("6246")) {
					lblDs.setText("DS");
				} else if ((!iTbillingReady.equalsIgnoreCase("6246") && !iTbillingReady.isEmpty())
						|| (!hRbillingReady.equalsIgnoreCase("6246") && !hRbillingReady.isEmpty())
						|| (!workBillingReady.equalsIgnoreCase("6246") && !workBillingReady.isEmpty())) {
					lblDs.setText("Not DS");
				} else if ((iTbillingReady == "" || iTbillingReady == null || iTbillingReady.isEmpty())
						|| (hRbillingReady == "" || hRbillingReady == null || hRbillingReady.isEmpty())
						|| (workBillingReady == "" || workBillingReady == null || workBillingReady.isEmpty())) {
					lblDs.setText("No Info");
				} else {
					Alert alert = new Alert(AlertType.INFORMATION);
					alert.setTitle("Wut?");
					alert.setHeaderText("You should not be seeing this, Call Batman, i mean, Alisson");
					alert.setContentText("jItBillingCode:" + jItBillingCode + " - " + "jItBillingCodeReady:" + iTbillingReady 
							+"\n" + "jHrBillingCode:" + jHrBillingCode + " - " + "hRbillingReady:" + hRbillingReady 
							+"\n" + "jWorkCompany:" + jWorkCompany + " - " + "workBillingReady:" + workBillingReady);

					alert.showAndWait();
				}
			}

			// Fim dados

			// =monta summary
			// if (jCtn == "" && jLPhone==""){//soh mobile
			// SumReady = txtSummary.getText()+"/"+jFac+" "+jRoom+"/"+jMobile;
			// phone = jMobile;
			// } else if (jCtn ==""){//long phone
			// SumReady = txtSummary.getText()+"/"+jFac+" "+jRoom+"/"+jLPhone;
			// phone = jLPhone;
			// } else {//normal
			// SumReady = txtSummary.getText()+"/"+jFac+" "+jRoom+"/"+jCtn;
			// phone = jCtn;
			// }
			if ((jCtn == "" && jLPhone == "") || (jCtn == null && jLPhone == null)
					|| (jCtn.isEmpty() && jLPhone.isEmpty())) {// soh
				// mobile
				SumReady = txtSummary.getText() + "/" + jFac + " " + jRoom + "/" + jMobile;
				phone = jMobile;
			} else if ((jCtn == "") || (jCtn == null) || (jCtn.isEmpty())) {// long
																			// phone
				SumReady = txtSummary.getText() + "/" + jFac + " " + jRoom + "/" + jLPhone;
				phone = jLPhone;
			} else {// normal
				SumReady = txtSummary.getText() + "/" + jFac + " " + jRoom + "/" + jCtn;
				phone = jCtn;
			}

			txtSummary.setText(SumReady);

			// **************************Notes**************************
//			test DS
//			txtaGetInfo.setText("jItBillingCode:" + jItBillingCode + " - " + "jItBillingCodeReady:" + iTbillingReady 
//					+"\n" + "jHrBillingCode:" + jHrBillingCode + " - " + "hRbillingReady:" + hRbillingReady 
//					+"\n" + "jWorkCompany:" + jWorkCompany + " - " + "workBillingReady:" + workBillingReady);

			 String nReady = ("User: " + jName + " (" + jCai + ")" + "\n" +
			 "Phone: " + phone + "\n" + "Location: "
			 + jLoc1 + " " + jRoom + "\nMachine ID: \n\n" + txtaGetInfo.getText() + "\n\n");
			 txtaGetInfo.setText(nReady + details + txtaCb);

		} catch (Exception e1) {

			e1.printStackTrace();
			lblStatus.setText("Cai not found");
			
			//janela com exception
			System.out.println("wtf?");
			e1.printStackTrace();

			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Cai not found");
			alert.setHeaderText("Cai not found");
			alert.setContentText("Cai not found");

			Exception ex = new Exception("Cai not found");

			// Create expandable Exception.
			StringWriter sw = new StringWriter();
			PrintWriter pw = new PrintWriter(sw);
			ex.printStackTrace(pw);
			String exceptionText = sw.toString();

			Label label = new Label("The exception stacktrace was:");

			TextArea textArea = new TextArea(exceptionText);
			textArea.setEditable(false);
			textArea.setWrapText(true);

			textArea.setMaxWidth(Double.MAX_VALUE);
			textArea.setMaxHeight(Double.MAX_VALUE);
			GridPane.setVgrow(textArea, Priority.ALWAYS);
			GridPane.setHgrow(textArea, Priority.ALWAYS);

			GridPane expContent = new GridPane();
			expContent.setMaxWidth(Double.MAX_VALUE);
			expContent.add(label, 0, 0);
			expContent.add(textArea, 0, 1);

			// Set expandable Exception into the dialog pane.
			alert.getDialogPane().setExpandableContent(expContent);

			alert.showAndWait();
			
		}

	}

	@FXML
	private void txtCaiClear() {
		txtCai.clear();
	}

	@FXML
	private void txtaClear() {
		txtaGetInfo.clear();
	}

	@FXML
	private void editTicket() throws IOException {
		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setTitle("Overwrite current Ticket?");
		alert.setHeaderText(
				"Replace/Update ticket: " + listHistory.getSelectionModel().getSelectedItem().getSummary() + " ?");

		Optional<ButtonType> result = alert.showAndWait();
		if (result.get() == ButtonType.OK) {
			listHistory.getSelectionModel().getSelectedItem().setTicket(txtCai.getText(), txtSummary.getText(),
					txtaGetInfo.getText());
			listHistory.getItems().setAll(ticketList);
			saveToFile();
		} else {
		}

	}

	@FXML
	private void deleteTicket() {

		try {
			if (listHistory.getSelectionModel().getSelectedIndex() != 0) {
				ticketList.remove(listHistory.getSelectionModel().getSelectedItem());
				listHistory.getItems().setAll(ticketList);
				saveToFile();
			}
			saveToFile();
		} catch (Exception e) {
			System.out.println("o");

			e.printStackTrace();

			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Exception Dialog");
			alert.setHeaderText("Look, an Exception Dialog");
			alert.setContentText("Exception:");

			Exception ex = new FileNotFoundException("Exception: ");

			// Create expandable Exception.
			StringWriter sw = new StringWriter();
			PrintWriter pw = new PrintWriter(sw);
			ex.printStackTrace(pw);
			String exceptionText = sw.toString();

			Label label = new Label("The exception stacktrace was:");

			TextArea textArea = new TextArea(exceptionText);
			textArea.setEditable(false);
			textArea.setWrapText(true);

			textArea.setMaxWidth(Double.MAX_VALUE);
			textArea.setMaxHeight(Double.MAX_VALUE);
			GridPane.setVgrow(textArea, Priority.ALWAYS);
			GridPane.setHgrow(textArea, Priority.ALWAYS);

			GridPane expContent = new GridPane();
			expContent.setMaxWidth(Double.MAX_VALUE);
			expContent.add(label, 0, 0);
			expContent.add(textArea, 0, 1);

			// Set expandable Exception into the dialog pane.
			alert.getDialogPane().setExpandableContent(expContent);

			alert.showAndWait();
		}
		listHistory.getSelectionModel().select(0);
	}

	@FXML
	private void txtSumClear() {
		txtSummary.clear();
	}

	@FXML
	private void clearAll() {
		txtCai.setText("");
		txtSummary.setText("");
		txtaGetInfo.setText("");
		txtKb.setText("");
		txtaCb = "";

	}

	@FXML
	private void saveTicket() throws IOException {
		if (!txtCai.getText().isEmpty() || !txtSummary.getText().isEmpty() || !txtaGetInfo.getText().isEmpty()) {
			if (txtSummary.getText().isEmpty()) {
				txtSummary.setText("<Esse titulo tá... faltando>");
			}
			Ticket newTicket = new Ticket(txtCai.getText(), txtSummary.getText(), txtaGetInfo.getText());
			ticketList.add(newTicket);
			listHistory.getItems().setAll(ticketList);
			saveToFile();
		}

	}

	public void saveToFile() throws IOException {
		Path path = Paths.get(ticketFileName);
		BufferedWriter bw = Files.newBufferedWriter(path);
		try {
			Iterator<Ticket> iter = ticketList.iterator();
			while (iter.hasNext()) {
				Ticket item = iter.next();
				// if (item.getNotes().isEmpty()) {
				// item.setNotes(" ");
				// } else if (item.getCai().isEmpty()) {
				// item.setCai(" ");
				// } else if (item.getSummary().isEmpty()) {
				// item.setSummary(" ");
				// }
				String notesReady = item.getNotes();

				notesReady = item.getNotes().replaceAll("\n", "thisisaspace");
				// System.out.println(notesReady);
				bw.write(String.format("%s->\t%s->\t%s", item.getCai(), item.getSummary(), notesReady));
				bw.newLine();
			}

		} catch (Exception e) {
			System.out.println("o");

			e.printStackTrace();

			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Exception Dialog");
			alert.setHeaderText("Look, an Exception Dialog");
			alert.setContentText("Exception:");

			Exception ex = new FileNotFoundException("Exception: ");

			// Create expandable Exception.
			StringWriter sw = new StringWriter();
			PrintWriter pw = new PrintWriter(sw);
			ex.printStackTrace(pw);
			String exceptionText = sw.toString();

			Label label = new Label("The exception stacktrace was:");

			TextArea textArea = new TextArea(exceptionText);
			textArea.setEditable(false);
			textArea.setWrapText(true);

			textArea.setMaxWidth(Double.MAX_VALUE);
			textArea.setMaxHeight(Double.MAX_VALUE);
			GridPane.setVgrow(textArea, Priority.ALWAYS);
			GridPane.setHgrow(textArea, Priority.ALWAYS);

			GridPane expContent = new GridPane();
			expContent.setMaxWidth(Double.MAX_VALUE);
			expContent.add(label, 0, 0);
			expContent.add(textArea, 0, 1);

			// Set expandable Exception into the dialog pane.
			alert.getDialogPane().setExpandableContent(expContent);

			alert.showAndWait();

		}

		finally {
			if (bw != null) {
				bw.flush();
			}
		}
	}

}
