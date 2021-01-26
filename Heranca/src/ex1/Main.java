package ex1;
public class Main {
	public static void main(String args[]) {
		Assis assis1 = new Assis();
		assis1.setNome("nombre");
		assis1.setnMat(5);
		System.out.println("===");
		System.out.println("nome" +assis1.getNome());
		System.out.println("mat" +assis1.getNmat());
	}
}
