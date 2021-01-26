package un10;


import java.awt.GridLayout;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPanel;

public class GuiCadProjeto extends JFrame
{
   private JLabel labelCodigo;
   private JLabel labelDescricao;
   private JLabel labelDataIni;
   private JLabel labelDataFim;
   private JLabel labelPercentual;
   private JLabel labelSituacao;
   
   private JTextField textfieldCodigo;
   private JTextField textfieldDescricao;
   private JTextField textfieldDataIni;
   private JTextField textfieldDataFim;
   private JTextField textfieldPercentual;
   private JTextField textfieldSituacao;
   private JPanel buttonJPanel; // painel para armazenar botões
   private JButton buttons[] = new JButton[ 4 ]; // array de botões
   private final String names[] = { "Salvar", "Editar","Deletar", "Limpar"};
   private Manipula_Projeto mp = new Manipula_Projeto();

   // construtor sem argumento
   public GuiCadProjeto()
   {
      super("Exemplo com Multiplos Paineis");
      
      labelCodigo = new JLabel("Código");
      labelCodigo.setVisible(false);
      labelDescricao = new JLabel("Descrição");
      labelDataIni = new JLabel("Data de Inicio");
      labelDataFim = new JLabel("Data de Finalização");
      labelPercentual = new JLabel("Percentual");
      labelSituacao = new JLabel("Situação");
      
      textfieldCodigo = new JTextField(30);
      textfieldCodigo.setVisible(false);
      textfieldCodigo.addActionListener(      
			  new ActionListener() 
	         {  
	            public void actionPerformed( ActionEvent event )
	            {
	            	  Conexao c = new Conexao("localhost","livro","sqluser","sql123");
	            	  c.Conectar();
	            	  mp.setConexao(c);
	               	  Projetos p = mp.consultaDados(Integer.parseInt(textfieldCodigo.getText()));
	               	  if (p != null){
	               		 textfieldDescricao.setText(p.getDescricao());
	                     textfieldDataIni.setText(p.getDataInicio());
	                     textfieldDataFim.setText(p.getDataFinal());
	                     textfieldPercentual.setText(Integer.toString(p.getPercentual()));
	                     textfieldSituacao.setText(p.getSituacao());
	               		  
	               	  }
	               	  else{
	               		 JOptionPane.showMessageDialog(null,"Registro não encontrado. Inserir dados para novo registro!","",
      					          JOptionPane.INFORMATION_MESSAGE);
	               		 c.FecharConexao();
	               	  } 
	            }
	             
	         } 
	      ); 
      
      textfieldDescricao = new JTextField(30);
      textfieldDataIni = new JTextField(30);
      textfieldDataFim = new JTextField(30);
      textfieldPercentual = new JTextField(30);
      textfieldSituacao = new JTextField(30);
      
      
      JPanel buttonJPanel = new JPanel(new GridLayout( 0, 4)); // cria JPanel dos botoes
      // cria e adiciona botões ao panel
      for ( int count = 0; count < buttons.length; count++ ) {
        	 buttons[ count ] = new JButton( names [ count ] ) ;
        	 buttons[ count ].addActionListener(      
        			  new ActionListener() 
        	         {  
        	            public void actionPerformed( ActionEvent event )
        	            {
        	            	if (event.getSource() == buttons[ 0 ]){ //salvar
        	            	 if (!textfieldDescricao.getText().equals("")){	
        	            		 Conexao c = new Conexao("localhost","livro","sqluser","sql123");
        	            		 c.Conectar();
        	            		 mp.setConexao(c);
        	            		 Projetos p;
        	            		 if (!textfieldCodigo.getText().equals("")){
        	            			 p=new Projetos(Integer.parseInt(textfieldCodigo.getText()),textfieldDescricao.getText(),textfieldDataIni.getText(),
        	            					 textfieldDataFim.getText(),Integer.parseInt(textfieldPercentual.getText()),
        	            					 textfieldSituacao.getText());
        	            		 }else{
        	            			 p=new Projetos(textfieldDescricao.getText(),textfieldDataIni.getText(),
        	            					 textfieldDataFim.getText(),Integer.parseInt(textfieldPercentual.getText()),
        	            					 textfieldSituacao.getText());
        	            		 }
        	            		 mp.InsereDados(p);
        	            		 c.FecharConexao();
        	            	 }else
        	            		 JOptionPane.showMessageDialog(null,"Inserir descricao do projeto!","",
           					          JOptionPane. WARNING_MESSAGE);
        	            	   
        	            	}else
        	            		if (event.getSource() == buttons[ 1 ]){ //editar
        	            			  labelCodigo.setVisible(true);
        	            			  textfieldCodigo.setVisible(true);
        	            		}else
        	            			if (event.getSource() == buttons[ 2 ]){ //deletar
        	            				if (!textfieldCodigo.getText().equals("")){
       	            				 		Conexao c = new Conexao("localhost","livro","root","virtual");
       	            				 		c.Conectar();
       	            				 		mp.setConexao(c);
       	            				 		mp.RemoverDados(Integer.parseInt(textfieldCodigo.getText()));
       	            				 		c.FecharConexao();
        	            				}else{
        	            					 JOptionPane.showMessageDialog(null,"Inserir código do projeto!","",
        	            					          JOptionPane. WARNING_MESSAGE);
        	            					  labelCodigo.setVisible(true);
                	            			  textfieldCodigo.setVisible(true);
        	            				}
        	            			} 
        	            			else
        	            				if (event.getSource() == buttons[ 3 ]){ //limpar
        	            					textfieldCodigo.setText("");
        	            					textfieldDescricao.setText("");
        	            					textfieldDataIni.setText("");
        	            					textfieldDataFim.setText("");
        	            					textfieldPercentual.setText("");
        	            					textfieldSituacao.setText("");
        	            					textfieldCodigo.setFocusable(true);
        	            				}	 
        	         }		

        	        }
        	      ); 

         	 buttonJPanel.add( buttons[ count ] ); // adiciona botão ao painel
      } 
        
      JPanel labelPane = new JPanel(new GridLayout(0,1)); // cria JPanel dos labels
      labelPane.add(labelCodigo); //adiciona label´s ao panel
      labelPane.add(labelDescricao);
      labelPane.add(labelDataIni);
      labelPane.add(labelDataFim); //adiciona label´s ao panel
      labelPane.add(labelPercentual);
      labelPane.add(labelSituacao); 
        
      JPanel fieldPane = new JPanel(new GridLayout(0,1));// cria JPanel dos textedit
      fieldPane.add(textfieldCodigo); //adiciona textfield´s ao panel
      fieldPane.add(textfieldDescricao);
      fieldPane.add(textfieldDataIni);
      fieldPane.add(textfieldDataFim); //adiciona textfield´s ao panel
      fieldPane.add(textfieldPercentual);
      fieldPane.add(textfieldSituacao);
      
          
       JPanel principalPane = new JPanel(new BorderLayout());// cria JPanel principal
       principalPane.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
       principalPane.add(labelPane, BorderLayout.CENTER);// adiciona painel ao JFrame na região Sul   
       principalPane.add(fieldPane, BorderLayout.EAST);// adiciona painel ao JFrame na região Sul
       principalPane.add( buttonJPanel, BorderLayout.SOUTH ); // adiciona painel ao JFrame na região Sul
         
       add(principalPane,BorderLayout.CENTER) ; 
         
   } // fim do construtor 

  public static void main( String args[] )
   { 
      GuiCadProjeto panel2 = new GuiCadProjeto(); 
      panel2.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
      panel2.setSize( 600, 200 ); // configura o tamanho do frame
      panel2.setVisible( true ); // exibe o frame
   } // fim de main
  
} // fim da classe 

