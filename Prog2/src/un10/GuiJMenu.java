package un10;

import java.awt.Color;
import java.awt.Font;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import javax.swing.JFrame;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JCheckBoxMenuItem;   
import javax.swing.JOptionPane;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.ButtonGroup;
import javax.swing.JMenu;    
import javax.swing.JMenuItem;
import javax.swing.JMenuBar;

public class GuiJMenu extends JFrame 
{
   private final Color colorValues[] = 
      { Color.BLACK, Color.BLUE, Color.RED, Color.GREEN };   
  
   // construtor sem argumento para configurar a GUI
   public GuiJMenu()
   {
      super( "Gerenciador de Projetos" );     

      JMenu cadastrarMenu = new JMenu( "Cadastrar" ); // cria o menu Cadastrar
      cadastrarMenu.setMnemonic( 'C' ); // configura o mnemônico como C        

      // cria item de menu About... 
      JMenuItem projetoItem = new JMenuItem( "Projeto" );       
      projetoItem.setMnemonic( 'P' ); // configura o mnemônico com P   
          
      cadastrarMenu.add( projetoItem ); // adiciona o item Projeto ao menu Cadastrar
      projetoItem.addActionListener(
         new ActionListener() // classe interna anônima
         {  
            public void actionPerformed( ActionEvent event )
            {
               GuiCadProjeto panel2 = new GuiCadProjeto(); 
      		   panel2.setSize( 600, 200 ); 
       		   panel2.setVisible( true ); 
            } // fim do método actionPerformed
         } // fim da classe interna anônima
      ); // fim da chamada para addActionListener
 
 
      JMenuItem particItem = new JMenuItem( "Participante" ); // cria o item Participante
      particItem.setMnemonic( 'P' ); // configura o mnemônico como P     
                 
      cadastrarMenu.add( particItem ); // adiciona o item Participante ao menu Cadastrar
      particItem.addActionListener(

         new ActionListener() // classe interna anônima
         {  
            public void actionPerformed( ActionEvent event )
            {
			GuiCadPartic panel2 = new GuiCadPartic(); 
       		panel2.setSize( 600, 200 ); // configura o tamanho do frame
      		panel2.setVisible( true ); // exibe o frame
            } // fim do método actionPerformed
         } // fim da classe interna anônima
      ); // fim da chamada para addActionListener
      
      JMenuItem sairItem = new JMenuItem( "Sair" ); // cria o item Sair
      sairItem.setMnemonic( 'S' ); // configura o mnemônico como S     
                 
      cadastrarMenu.add( sairItem ); // adiciona o item Sair ao menu Cadastrar    
      sairItem.addActionListener(      
		  new ActionListener() // classe interna anônima
         {  
          public void actionPerformed( ActionEvent event )
            {
               System.exit( 0 ); // encerra o aplicativo
            } // fim do método actionPerformed
         } // fim da classe interna anônima
      ); // fim da chamada para addActionListener


      JMenu ajudaMenu = new JMenu( "Ajuda" ); // cria o menu Ajuda
      ajudaMenu.setMnemonic( 'A' ); // configura o mnemônico como A            

  		JMenuItem sobreItem = new JMenuItem( "Sobre" ); // cria o item Sobre
      	sobreItem.setMnemonic( 'S' ); // configura o mnemônico como S     
       	sobreItem.addActionListener(      
		  new ActionListener() // classe interna anônima
         {  
			  public void actionPerformed( ActionEvent event ){
				  JOptionPane.showMessageDialog( GuiJMenu.this,"Sistema de Gerenciamento de Projetos","Sobre", JOptionPane.PLAIN_MESSAGE );
			  }
         } // fim da classe interna anônima
      	); // fim da chamada para addActionListener*/

     	ajudaMenu.add( sobreItem ); // adiciona o item Sobre ao menu Ajuda    
      	
      	JMenuBar bar = new JMenuBar(); // cria a barra de menus
      	setJMenuBar( bar ); // adiciona uma barra de menus ao aplicativo
      	bar.add( cadastrarMenu ); // adiciona o menu Cadastrar à barra de menus
	      
	    bar.add( ajudaMenu ); // adiciona o menu Ajuda à barra de menus     
     
     
      getContentPane().setBackground( Color.BLUE ); // configura o fundo
      
   } // fim do construtor de MenuFrame


   
   
   
   
   public static void main( String args[] )
   { 
      GuiJMenu menu = new GuiJMenu(); // criar MenuFrame
      menu.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
      menu.setSize( 580, 200 ); // configura o tamanho do frame
      menu.setVisible( true ); // exibe o frame
   } // fim de main
   
   
} // fim da classe MenuFrame

