package AD2Q4;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;
public class adMain {
	public static void main(String args[]) {
		final int INCLUIR = 1;
		final int BUSCAR = 2;
		final int SAIR = 3;
		int cont = 0;
		boolean continuar = true;
		
	      List<Paciente> listaP = new ArrayList<Paciente>();
	      List<Medico> listaM = new ArrayList<Medico>();
	      List<Doenca> listaD = new ArrayList<Doenca>();
	      List<Sintoma> listaS = new ArrayList<Sintoma>();

	      while (continuar) {
	    	  for (int c=0;c<=1;c++){
	            	cont=cont++;
	            }
	            cont = cont+1;
	            
	         int opcao = Integer.parseInt(JOptionPane.showInputDialog
	         ("digite uma das seguintes opcoes: \n1) Incluir\n2)buscar\n3)Sair"));

	         if (opcao == INCLUIR) {
	        	//incluir paciente
	            Paciente paciente = new Paciente();
	            paciente.setNome(JOptionPane.showInputDialog("Nome do paciente: "));
	            paciente.setSexo(JOptionPane.showInputDialog("Sexo (M ou F): "));
	            paciente.setIdade(Integer.parseInt(JOptionPane.showInputDialog("Idade: ")));
	            
	            //incluir medico	            
            	boolean continuarM = true;
	            while (continuarM){
		            int opMedico=Integer.parseInt(JOptionPane.showInputDialog("1 para cadastrar novo médico \n"
	           		+ "2 para buscar medico existente"));
		            if (opMedico == 1){
		            	Medico medico = new Medico();
		            	medico.setNome(JOptionPane.showInputDialog("Nome do medico: "));
		            	medico.setEspec(JOptionPane.showInputDialog("Especialidade: "));
		            	listaM.add(medico);
		            	//System.out.println("verificar medico: "+medico.getNome());
		            	paciente.setMedico(medico);
		            	JOptionPane.showMessageDialog(null, "Medico incluido com sucesso!");

		            	continuarM = false;
		            	
		            	System.out.println("nome do medico: " +paciente.getMedico().getNome());
		            	
		            //achar medico e atribuir a paciente
		            } else if (opMedico == 2 && cont>1){
		            	String BuscaM =JOptionPane.showInputDialog("Digite nome do médico: ");
		            	int contElseM=0;
		            	 for (Medico medico : listaM){
		            		 contElseM=contElseM+1;		            		 
		            		 if (BuscaM.equalsIgnoreCase(medico.getNome())){
		            			 paciente.setMedico(medico);
		            			 JOptionPane.showMessageDialog(null,"Medico atribuido com sucesso!");
		            			 continuarM=false;
		            			 break;
	//		  	              	 JOptionPane.showMessageDialog(null, "Medico "+ medico.getNome() + " adicionado para " +paciente.getNome()+" Com sucesso!");
	//		  	                 System.out.println(paciente.getMedico().getNome());
		            		 } else if (! BuscaM.equals(medico.getNome()) && contElseM >=listaM.size()){
		            			 JOptionPane.showMessageDialog(null, "Medico não encontrado");
		            		 }
		            	 }
		            } else if ((opMedico == 2) && (cont<=1)){
		            	JOptionPane.showMessageDialog(null, "Nenhum médico cadastrado ainda!");

		            } else {
		            	JOptionPane.showMessageDialog(null, "Opção invalida!");
		            }
		            
	            }
		            
///////////////////////////
            //incluir sintoma doenca
            boolean continuarS = true;
            while (continuarS){
	            int opSintoma=Integer.parseInt(JOptionPane.showInputDialog("1 para cadastrar novo sintoma e doenca \n"
	       		+ "2 para buscar Sintoma e cadastrar doenca \n"));
	            if (opSintoma == 1){
	            	Sintoma sintoma = new Sintoma();
	            	sintoma.setNome(JOptionPane.showInputDialog("Nome do sintoma: "));
	            	sintoma.setduracao(Integer.parseInt(JOptionPane.showInputDialog("Duração (dias): ")));
	            	listaS.add(sintoma);//
	            	Doenca doenca = new Doenca();
       			 	doenca.setNome(JOptionPane.showInputDialog("Digite nome da doenca: "));
       			 	doenca.setSintoma(sintoma);
       			    listaD.add(doenca);
       			    paciente.setDoenca(doenca);
       			    //
       			    continuarS=false;
       			    JOptionPane.showMessageDialog(null, "doenca incluido com sucesso!");
	            	JOptionPane.showMessageDialog(null, "Sintoma incluido com sucesso!");

	            	
	            //buscar sintoma incluir doenca
	            } else if ((opSintoma == 2) && (cont>1)){
	            	String BuscaS =JOptionPane.showInputDialog("Digite nome do sintoma: ");
	            	int contElseS=0;
	            	 for (Sintoma sintoma : listaS){
	            		 contElseS=contElseS+1;
	            		 if (BuscaS.equalsIgnoreCase(sintoma.getNome())){
	            			 //cadastrar doenca
	            			 Doenca doenca = new Doenca();
	            			 doenca.setNome(JOptionPane.showInputDialog("Digite nome da doenca: "));
	            			 doenca.setSintoma(sintoma);
	            			 listaD.add(doenca);
	            			 JOptionPane.showMessageDialog(null, "doenca incluido com sucesso!");
	            			 paciente.setDoenca(doenca);
	            			 
	            			 continuarS = false;
	            			 System.out.println("nome do sintoma: "+ doenca.getSintoma().getNome());
	            			 break;
	//		  	              	 JOptionPane.showMessageDialog(null, "Medico "+ medico.getNome() + " adicionado para " +paciente.getNome()+" Com sucesso!");
	//		  	                 System.out.println(paciente.getMedico().getNome());
	            		 } else if (! BuscaS.equals(sintoma.getNome()) && contElseS >=listaS.size()){
	            			 JOptionPane.showMessageDialog(null, "Sintoma não encontrado");
	            			 
	            		 }
	  	             }
	            
	            
//	            } else if (opSintoma ==3){
//	            	continuarS = false;
//	            }
	            
            }  else if ((opSintoma == 2) && (cont<=1)){
            	JOptionPane.showMessageDialog(null, "Nenhum Sintoma cadastrado ainda!");

            } else {
            	JOptionPane.showMessageDialog(null, "Opção invalida!");
            }
            }
	            //fim cadastro paciente      
	            listaP.add(paciente);
	            JOptionPane.showMessageDialog(null,"Paciente " +paciente.getNome() + " incluido com sucesso!");
	            
	            System.out.println("after run="+ cont);
	            System.out.println("paciente: ");
	            System.out.println("nome: "+paciente.getNome());
	            System.out.println("idade: "+paciente.getIdade());
	            System.out.println("sexo: "+paciente.getSexo());
	            System.out.println("medico============");
	            System.out.println("nome medico: "+paciente.getMedico().getNome());
	            System.out.println("espec: "+paciente.getMedico().getEspec());
	            System.out.println("sintoma============");
	            System.out.println("nome sintoma: "+paciente.getDoenca().getSintoma().getNome());
	            System.out.println("duracao: "+paciente.getDoenca().getSintoma().getduracao());
	            System.out.println("doenca============");
	            System.out.println("nome doenca: "+paciente.getDoenca().getNome());
	            
	            /* Onde não consigo chamar 
	             * Quanto tento verificar o metodo de GetNome pelo objeto medico aqui não é possivel, 
	             * testei na linha 42 logo apos inserir medico e a lista e funciona
	             * Poderia por favor me ajudar a entender por que?
	             * Obrigado!
	             * */
	            //System.out.println("verificar medico: "+medico.getNome());
	            
	         } else if ((opcao == BUSCAR) && cont >1 ) {
	        	 String buscaSS=JOptionPane.showInputDialog("Digite o sintoma para pesquisar: ");
	        	 int contElseSS=0;
	          	 for (Paciente paciente : listaP){
	          		contElseSS=contElseSS+1;
	          		
	          		 if (buscaSS.equalsIgnoreCase((paciente.getDoenca().getSintoma().getNome()))){
	          			JOptionPane.showMessageDialog(null, "Pacientes com o sintoma: "+buscaSS+": " +paciente.getNome());	          			 
	          		 } else if (! buscaSS.equals((paciente.getDoenca().getSintoma().getNome())) && contElseSS >=listaP.size()){
	          			 JOptionPane.showMessageDialog(null, "Fim da busca!");
	          		 } 

	        	 }

	         } else if(cont <=1){
	        	 JOptionPane.showMessageDialog(null, "Nenhum paciente cadastrado ainda!");
	        	 
	         } else if (opcao == SAIR) {
		            continuar = false;
	         }
	      }
	}
}
