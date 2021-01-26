package ad;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.ScrollPaneConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GuiListar extends JFrame {

	private JPanel contentPane;
	//private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GuiListar frame = new GuiListar();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public GuiListar() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 460, 307);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		String[] colunasTabela = new String[]{ "ID ", "Nome ", "idade ","Data Nascimento ","Cidade ","Estado Civil "};  
		DefaultTableModel modeloTabela = new DefaultTableModel(null,colunasTabela);
		contentPane.setLayout(null);
		JTable table = new JTable();
		table.setModel(modeloTabela);
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(5, 5, 434, 218);
		getContentPane().add(scrollPane);
		
		JButton btnFechar = new JButton("Fechar");
		btnFechar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		btnFechar.setBounds(345, 234, 89, 23);
		contentPane.add(btnFechar);
		Datasource ds = new Datasource();
		ds.open();
		for (Pessoa p:ds.returnPessoa()){
			modeloTabela.addRow(new String[] {
					Integer.toString(p.getPessoaID()), p.getNome(), Integer.toString(p.getIdade()), p.getDataNasc(),p.getCidade(),p.getEstadoCivil()

			});
		}		
	}
}
