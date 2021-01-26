package Un12;
public class Conta {
		private int numero;
		private double saldo;
		private Cliente cliente;
		
		public Conta ( ){
		numero =0;
		saldo =0;
		cliente = null;
		
		}
		public void setNumero(int inum){
		numero=inum;
		}
		
		public void setSaldo(double ssaldo){
		saldo=ssaldo;
		}
		
		public void setCliente(Cliente c){
		cliente = c;
		}
		public int getNumero( ){
		return numero;
		}
		
		public double getSaldo(){
		return saldo;
		}
		
		public Cliente getCliente(){
		return cliente;
		}

}
