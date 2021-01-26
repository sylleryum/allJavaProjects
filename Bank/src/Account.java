
public class Account {
	private String cliente;
	private double balance;
	
	
	public String getCliente() {
		return cliente;
	}
	public void setCliente(String cliente) {
		this.cliente = cliente;
	}
	
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}

	public void tirar(double tirar){
		if (balance >= tirar){
			balance = balance - tirar;
			System.out.println(tirar +" Retirado com sucesso!");
		}else{
			System.out.println("sem fundos!");
		}
		
	}
	
	public void botar (double botar){
		balance += botar;
	}
}
