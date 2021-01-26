package Un13;

public class Aptos extends Imoveis{
	protected int andar, nAP;

	public Aptos() {
		super();
		andar=0;
		nAP=0;
	}
	
	public Aptos(int sandar, int snAP) {
		super();
		andar=sandar;
		nAP=snAP;
	}
	//set
	public void setAndar(int andar) {
		this.andar = andar;
	}

	public void setnAP(int nAP) {
		this.nAP = nAP;
	}
	
	//get
	public int getAndar() {
		return andar;
	}

	public int getnAP() {
		return nAP;
	}

}
