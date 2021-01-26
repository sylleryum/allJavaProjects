package un10;


import java.awt.GridLayout;
import java.awt.BorderLayout;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPanel;

public class GuiCadPartic extends JFrame
{
   private JLabel labelNome;
   private JLabel labelCargo;
     
   private JTextField textfieldNome;
   private JTextField textfieldCargo;
 
   private JPanel buttonJPanel; // painel para armazenar bot�es
   private JButton buttons[] = new JButton[ 4 ]; // array de bot�es
   private final String names[] = { "Salvar", "Editar", "Deletar", "Sair"};


   // construtor sem argumento
   public GuiCadPartic()
   {
      super("Exemplo com Multiplos Paineis");
            
      labelNome = new JLabel("C�digo");
      labelCargo = new JLabel("Descri��o");
           
      
      textfieldNome = new JTextField(30);
      textfieldCargo = new JTextField(30);
          
      
      JPanel buttonJPanel = new JPanel(new GridLayout( 0, 4)); // cria JPanel dos botoes
      // cria e adiciona bot�es ao panel
      for ( int count = 0; count < buttons.length; count++ ) {
        	 buttons[ count ] = new JButton( names [ count ] ) ;
         	 buttonJPanel.add( buttons[ count ] ); // adiciona bot�o ao painel
      } 
        
      JPanel labelPane = new JPanel(new GridLayout(0,1)); // cria JPanel dos labels
      labelPane.add(labelNome); //adiciona label�s ao panel
      labelPane.add(labelCargo);
              
      JPanel fieldPane = new JPanel(new GridLayout(0,1));// cria JPanel dos textedit
      fieldPane.add(textfieldNome); //adiciona textfield�s ao panel
      fieldPane.add(textfieldCargo);
          
          
       JPanel principalPane = new JPanel(new BorderLayout());// cria JPanel principal
       principalPane.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
       principalPane.add(labelPane, BorderLayout.CENTER);// adiciona painel ao JFrame na regi�o Sul   
       principalPane.add(fieldPane, BorderLayout.EAST);// adiciona painel ao JFrame na regi�o Sul
       principalPane.add( buttonJPanel, BorderLayout.SOUTH ); // adiciona painel ao JFrame na regi�o Sul
         
       add(principalPane,BorderLayout.CENTER) ; 
         
   } // fim do construtor 

  public static void main( String args[] )
   { 
      GuiCadPartic panel2 = new GuiCadPartic(); 
      panel2.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
      panel2.setSize( 600, 200 ); // configura o tamanho do frame
      panel2.setVisible( true ); // exibe o frame
   } // fim de main
  
} // fim da classe 

