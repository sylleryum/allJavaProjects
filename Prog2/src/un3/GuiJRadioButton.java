package un3;

import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.*;

public class GuiJRadioButton extends JFrame {

	private JTextField textfeld;
	private Font fontNegrito;
	private Font fontItalico;
	private Font fontSimples;
	private Font fontNegritoItalico;
	private JRadioButton radioNegrito;
	private JRadioButton radioItalico;
	private JRadioButton radioSimples;
	private JRadioButton radioNegritoItalico;
	private ButtonGroup grupoRadio;

	public GuiJRadioButton(){
 super("Exemplo JRadioButton");
 setLayout(new FlowLayout()); //confgura o layout do frame

 textfeld = new JTextField("Tecnólogo em Web Design e Programação");
 textfeld.setFont(new Font("Serif", Font.PLAIN, 14)); //confgura o tipo da fonte,estilo e tamanho
 add(textfeld); //adiciona textfeld ao frame

 radioNegrito = new JRadioButton("Negrito");//cria o primeiro componenteJRadioButton
 radioItalico = new JRadioButton("Italico");//cria o segundo componente
 radioSimples = new JRadioButton("Simples");//cria o terceiro componente
 radioNegritoItalico = new JRadioButton("Negrito + Italico");//cria o quarto componente
 add(radioNegrito);//adiciona os quatro componentes ao frame
 add(radioItalico);
 add(radioSimples);
 add(radioNegritoItalico);

 grupoRadio = new ButtonGroup(); //cria ButtonGroup - componente agrupador dos botões de radio
 grupoRadio.add(radioNegrito); //adiciona cada JRadioButton ao ButtonGroup
 grupoRadio.add(radioItalico);
 grupoRadio.add(radioSimples);
 grupoRadio.add(radioNegritoItalico);
 //cria quatro objeto do tipo Font. Servirãopara confgurar o texto do JTextField
 fontNegrito = new Font("Serif", Font.BOLD, 14);
 fontItalico = new Font("Serif", Font.ITALIC, 14);
 fontSimples = new Font("Serif", Font.PLAIN, 14); // JTextField
 fontNegritoItalico = new Font("Serif", Font.BOLD+Font.ITALIC, 14);
 textfeld.setFont(fontSimples);
 //cria um objeto ouvinte de evento novo para cada componente e o adiciona  componente JCheckBox através do método addItemListener
 radioNegrito.addItemListener(new TrataEventoRadio(fontNegrito));
 radioItalico.addItemListener(new TrataEventoRadio(fontItalico));
 radioSimples.addItemListener(new TrataEventoRadio(fontSimples));
 radioNegritoItalico.addItemListener(new TrataEventoRadio(fontNegritoItalico));

 } // fm do construtor

	private class TrataEventoRadio implements ItemListener {
		private Font fonte; // variável de instância do tipo Font

		public TrataEventoRadio(Font f) { // construtor da classe
			fonte = f;
		}

		public void itemStateChanged(ItemEvent event) {
			textfeld.setFont(fonte); // confgura a fonte do texto no JTextField
		}
	} // fm da classe interna
} // fm da classe de primeiro nível
