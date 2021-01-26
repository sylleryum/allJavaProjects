package celular;
import java.util.ArrayList;

public class Agenda {
	public ArrayList<Contato> contacts = new ArrayList<Contato>();

	public void addContact(String nome, int num) {
		Contato contato = new Contato();
		contato.setNome(nome);
		contato.setCel(num);
		System.out.println("adicionado " + contato.getNome());
		contacts.add(contato);
		System.out.println("numero " + contato.getCel());
	}

	public void update(String nome, String nNome, int num) {
		int i = buscaIn(nome);
		if (i >= 0) {
			System.out.println("*encontrado");
			contacts.get(i).setNome(nNome);
			contacts.get(i).setCel(num);
			System.out.println("*atualizado para " + nNome);
		} else {
			System.out.println("*não encontrado");
		}

	}

	public void delete(String nome) {
		System.out.println("==deletar==");		
		int i = buscaIn(nome);
		if (i >= 0) {
			contacts.remove(i);
			System.out.println("deletado");
		} else{
			System.out.println("não encontrado");
		}

	}

	public void listar() {
		System.out.println("==listar==");
		for (int i = 0; i < contacts.size(); i++) {
			System.out.println("nome " + (i + 1) + ": " + contacts.get(i).getNome());
			System.out.println("numero " + (i + 1) + ": " + contacts.get(i).getCel());
		}
	}

	public int buscaIn(String nome) {
		for (int i = 0; i < contacts.size(); i++) {
			if (contacts.get(i).getNome().equalsIgnoreCase(nome)) {
				return i;
			}
		}
		return -1;

	}
	

}
