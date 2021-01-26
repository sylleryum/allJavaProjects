package ad;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import javax.swing.JTextField;

import javax.swing.JRadioButton;
import javax.naming.ldap.Rdn;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollBar;
import org.eclipse.wb.swing.FocusTraversalOnArray;
import java.awt.Component;

public class Main {

	private JFrame frmAd;
	private JTextField txtNome;
	private JTextField txtIdade;
	private JTextField txtNascimento;
	private JTextField txtCidade;
	private JButton btnCancelarEdicao;
	private boolean bAlterar = false;
	private Pessoa aPessoa;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main window = new Main();
					window.frmAd.setVisible(true);
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
		Datasource dataSource = new Datasource();
		dataSource.open();
		// dataSource.saveTest();

		frmAd = new JFrame();
		frmAd.setTitle("AD1");
		frmAd.setBounds(100, 100, 438, 380);
		frmAd.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmAd.getContentPane().setLayout(null);

		JLabel lblDados = new JLabel("Dados de Pessoa");
		lblDados.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblDados.setBounds(20, 11, 116, 26);
		frmAd.getContentPane().add(lblDados);

		JLabel lblNome = new JLabel("Nome: ");
		lblNome.setBounds(20, 48, 46, 14);
		frmAd.getContentPane().add(lblNome);

		txtNome = new JTextField();
		txtNome.setBounds(20, 66, 86, 20);
		frmAd.getContentPane().add(txtNome);
		txtNome.setColumns(10);

		JLabel lblIdade = new JLabel("Idade: ");
		lblIdade.setBounds(20, 97, 46, 14);
		frmAd.getContentPane().add(lblIdade);

		txtIdade = new JTextField();
		txtIdade.setColumns(10);
		txtIdade.setBounds(20, 115, 86, 20);
		frmAd.getContentPane().add(txtIdade);

		JLabel lblNasc = new JLabel("Data Nascimento: ");
		lblNasc.setBounds(20, 146, 108, 14);
		frmAd.getContentPane().add(lblNasc);

		txtNascimento = new JTextField();
		txtNascimento.setText("dd/mm/yyyy");
		txtNascimento.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if (txtNascimento.getText().equalsIgnoreCase("dd/mm/yyyy")) {
					txtNascimento.setText("");
				}
			}
		});
		txtNascimento.setColumns(10);
		txtNascimento.setBounds(20, 163, 138, 20);
		frmAd.getContentPane().add(txtNascimento);

		JLabel lblCidade = new JLabel("Cidade: ");
		lblCidade.setBounds(20, 194, 46, 14);
		frmAd.getContentPane().add(lblCidade);

		txtCidade = new JTextField();
		txtCidade.setColumns(10);
		txtCidade.setBounds(20, 210, 86, 20);
		frmAd.getContentPane().add(txtCidade);

		JLabel lblEstado = new JLabel("Estado Civil: ");
		lblEstado.setBounds(20, 241, 86, 14);
		frmAd.getContentPane().add(lblEstado);

		JRadioButton rbCasado = new JRadioButton("Casado");
		rbCasado.setBounds(20, 257, 109, 23);
		frmAd.getContentPane().add(rbCasado);

		JRadioButton rbSolteiro = new JRadioButton("Solteiro");
		rbSolteiro.setBounds(20, 283, 109, 23);
		frmAd.getContentPane().add(rbSolteiro);

		JRadioButton rbViuvo = new JRadioButton("Viuvo");
		rbViuvo.setBounds(20, 309, 109, 23);
		frmAd.getContentPane().add(rbViuvo);

		ButtonGroup rbs = new ButtonGroup();
		rbs.add(rbViuvo);
		rbs.add(rbCasado);
		rbs.add(rbSolteiro);

		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (bAlterar) {
					if (txtNome.getText().isEmpty()) {
						JOptionPane.showMessageDialog(null, "Nome em branco");
						txtNome.requestFocus();
						settxtNasc();
					} else if (txtNascimento.getText().length() != 10) {
						JOptionPane.showMessageDialog(null, "Formato de data invalida");
					} else {
						String estadoCivil;
						if (rbCasado.isSelected()) {
							estadoCivil = "Casado";
						} else if (rbSolteiro.isSelected()) {
							estadoCivil = "Solteiro";
						} else if (rbViuvo.isSelected()) {
							estadoCivil = "Viuvo";
						} else {
							estadoCivil = null;
						}
						int idadeTemp = 0;
						if (!txtIdade.getText().isEmpty()) {
							idadeTemp = Integer.parseInt(txtIdade.getText());

						}
						dataSource.updateToDb(txtNome.getText(), idadeTemp, txtNascimento.getText(),
								txtCidade.getText(), estadoCivil, aPessoa.getPessoaID());
					}
					//System.out.println("atualizado com sucesso");
					JOptionPane.showMessageDialog(frmAd,
							"Registro de ID: " + aPessoa.getPessoaID() + " alterada com sucesso!");
					bAlterar = false;
					btnCancelarEdicao.setVisible(false);
					aPessoa = null;
					frmAd.setTitle("AD1");

				} else {
					// novo
					if (txtNome.getText().isEmpty()) {
						JOptionPane.showMessageDialog(null, "Nome em branco");
						txtNome.requestFocus();
						settxtNasc();
					} else if (txtNascimento.getText().length() != 10) {
						JOptionPane.showMessageDialog(null, "Formato de data invalida");
					} else {
						String estadoCivil;
						if (rbCasado.isSelected()) {
							estadoCivil = "Casado";
						} else if (rbSolteiro.isSelected()) {
							estadoCivil = "Solteiro";
						} else if (rbViuvo.isSelected()) {
							estadoCivil = "Viuvo";
						} else {
							estadoCivil = null;
						}
						int idadeTemp = 0;
						if (!txtIdade.getText().isEmpty()) {
							idadeTemp = Integer.parseInt(txtIdade.getText());

						}
						dataSource.saveToDb(txtNome.getText(), idadeTemp, txtNascimento.getText(), txtCidade.getText(),
								estadoCivil);
						JOptionPane.showMessageDialog(frmAd, "Nova pessoa cadastrada com sucesso");
						//System.out.println("cadastrado (novo) com sucesso");
					}
				}

			}
		});

		btnSalvar.setBounds(323, 16, 89, 23);
		frmAd.getContentPane().add(btnSalvar);

		JButton btnListar = new JButton("Listar");
		btnListar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// for (Pessoa p: dataSource.returnPessoa()){
				// System.out.println("id: "+p.getPessoaID()+
				// "|nome: "+p.getNome()+
				// "|idade: "+p.getIdade()+
				// "|data nascimento: "+p.getDataNasc()+
				// "|cidade: "+p.getCidade()+
				// "|estado civil: "+p.getEstadoCivil()+"\n======");
				// }
				GuiListar guiListar = new GuiListar();
				guiListar.setSize(460, 307);
				guiListar.setVisible(true);
				// for (Pessoa p: dataSource.returnPessoa()){
				//
				// }
			}

			// GuiListar.set

			// GuiCadProjeto panel2 = new GuiCadProjeto();
			// panel2.setSize( 600, 200 );
			// panel2.setVisible( true );

		});
		btnListar.setBounds(323, 44, 89, 23);
		frmAd.getContentPane().add(btnListar);

		JButton btnAlterar = new JButton("Alterar");
		btnAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int alterar = -1;
				try {
					alterar = Integer.parseInt(JOptionPane.showInputDialog("Digite o ID para alterar: "));
				} catch (NumberFormatException e) {
					//System.out.println("whoops");

				}				
				if (alterar>=0){
					aPessoa = dataSource.alterar(alterar);
					if (aPessoa.getPessoaID() > 0) {
						// return
						// "'"+date.substring(6)+"-"+date.substring(3,5)+"-"+date.substring(0,2)+"'";
						String dataFormatada = aPessoa.getDataNasc();
						//System.out.println("0-0-" + aPessoa.getDataNasc());

						if (aPessoa.getDataNasc() != null) {
							dataFormatada = aPessoa.getDataNasc().substring(8, 10) + "/"
									+ aPessoa.getDataNasc().substring(5, 7) + "/" + aPessoa.getDataNasc().substring(0, 4);
						}
						txtNome.setText(aPessoa.getNome());
						txtIdade.setText(Integer.toString(aPessoa.getIdade()));
						// txtNascimento.setText(aPessoa.getDataNasc());
						txtNascimento.setText(dataFormatada);
						txtCidade.setText(aPessoa.getCidade());
						if (aPessoa.getEstado().equalsIgnoreCase("Casado")) {
							rbCasado.setSelected(true);
						} else if (aPessoa.getEstado().equalsIgnoreCase("Solteiro")) {
							rbSolteiro.setSelected(true);
						} else if (aPessoa.getEstado().equalsIgnoreCase("Viuvo")) {
							rbViuvo.setSelected(true);
						}
						btnCancelarEdicao.setVisible(true);
						bAlterar = true;
						frmAd.setTitle("Alteração");
					}
				}				
				
				//System.out.println("retorno " + aPessoa.getPessoaID() + " " + aPessoa.getNome());
				

				// System.out.println("busca" +result);
			}
		});
		btnAlterar.setBounds(323, 72, 89, 23);
		frmAd.getContentPane().add(btnAlterar);

		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int excluir = -1;
				try {
					excluir = Integer.parseInt(JOptionPane.showInputDialog("Digite o ID para Excluir: "));
				} catch (NumberFormatException e) {
					//System.out.println("whoops");

				}

				if (excluir > 0) {
					dataSource.excluir(excluir);
				}

			}
		});
		btnExcluir.setBounds(323, 100, 89, 23);
		frmAd.getContentPane().add(btnExcluir);

		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				txtNome.setText("");
				txtIdade.setText("");
				txtNascimento.setText("");
				txtCidade.setText("");
				rbs.clearSelection();
				settxtNasc();
			}
		});
		btnLimpar.setBounds(323, 128, 89, 23);
		frmAd.getContentPane().add(btnLimpar);

		JButton btnSair = new JButton("Sair");
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (dataSource.getConexao()) {
					dataSource.close();
				}
				System.exit(0);

			}
		});
		btnSair.setBounds(323, 156, 89, 23);
		frmAd.getContentPane().add(btnSair);

		btnCancelarEdicao = new JButton("Cancelar edi\u00E7\u00E3o");
		btnCancelarEdicao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				bAlterar = false;
				frmAd.setTitle("AD1");
				btnCancelarEdicao.setVisible(false);
			}
		});
		btnCancelarEdicao.setBounds(116, 65, 130, 23);
		frmAd.getContentPane().add(btnCancelarEdicao);
		frmAd.getContentPane().setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{txtNome, txtIdade, txtNascimento, txtCidade, rbCasado, rbSolteiro, rbViuvo, btnSalvar, btnListar, btnAlterar, btnExcluir, btnLimpar, btnSair}));
		frmAd.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{txtNome, txtIdade, txtNascimento, txtCidade, rbCasado, rbSolteiro, rbViuvo, btnSalvar, btnListar, btnAlterar, btnExcluir, btnLimpar, btnSair}));
		btnCancelarEdicao.setVisible(false);

	}

	public void settxtNasc() {
		txtNascimento.setText("dd/mm/yyyy");
	}
}
