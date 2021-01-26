package Un13;
public class Casas extends Imoveis{
	protected int pisc;

	public Casas() {
		super();
		pisc=0;
	}

	public Casas(int pisc) {
		super();
		this.pisc = pisc;
	}
	
	public void setPisc(int pisc) {
		this.pisc = pisc;
	}


	public int getPisc() {
		return pisc;
	}


}
