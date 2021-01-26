package Un12;
	public class Cliente{
		private String nome;
		private String endereco;
		private int cpf;
		
		public Cliente( ){
		nome="";
		endereco="";
		cpf=0;
		}
		
		public Cliente(String snom, String send, int icpf ){
		nome=snom;
		endereco=send;
		cpf=icpf;
		}
		
		public void setNome(String snom){
		nome=snom;
		}
		
		public void setEndereco(String sender){
		endereco= sender;
		}
		
		public void setCpf(int icpf){
		cpf= icpf;
		}
		
		public String getNome(){
		return nome;
		}
		
		public String getEndereco(){
		return endereco;
		}
		
		public int getCpf( ){
		return cpf;
		}

}
