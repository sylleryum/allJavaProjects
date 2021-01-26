package ad2;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ExcluirPessoa
 */
@WebServlet("/ExcluirPessoa")
public class ExcluirPessoa extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Datasource ds = null;
	
	public void init(ServletConfig config) throws ServletException {
		ds = new Datasource();		
		ds.open();
	}

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (request.getParameter("excluir")!=null) {
			//alterar
			boolean funcionou = ds.excluir(Integer.parseInt(request.getParameter("id")));
			if (funcionou) {
				System.out.println("excluido");
				request.setAttribute("status", "excluida");		
				RequestDispatcher rd = request.getRequestDispatcher("/listar?acao=lista");
				rd.forward(request, response);
			} else {
				System.out.println("erro");				
			}
			//procurar
		} else {
			int pessoaID = Integer.parseInt(request.getParameter("ID"));		
			System.out.println("PessoaID: "+ pessoaID);
			Pessoa pessoa = ds.alterar(pessoaID);
			if (pessoa.getPessoaID()==-1) {		
				System.out.println("Pessoa não encontrada");
				request.setAttribute("pessoa", pessoa);			
				RequestDispatcher rd = request.getRequestDispatcher("/deletarpessoa.jsp");
				rd.forward(request, response);
			} else {
				System.out.println("pessoa: " +pessoa.getNome());
				request.setAttribute("pessoa", pessoa);			
				RequestDispatcher rd = request.getRequestDispatcher("/deletarpessoa.jsp");
				rd.forward(request, response);
			}
		}
		
		
		
//		if (pessoa.getPessoaID()==-1) {
//			System.out.println("Pessoa não encontrado");
//			//request.setAttribute("pessoa", pessoa);			
//			saida.println("<script>alert(\"Pessoa não encontrada\")</script>");
//		} else {
//			System.out.println("pessoa: " +pessoa.getNome());
//			String dataFormatada = pessoa.getDataNasc();
//			if (pessoa.getDataNasc() != null) {
//				dataFormatada = pessoa.getDataNasc().substring(8, 10) + "/" + pessoa.getDataNasc().substring(5, 7)
//						+ "/" + pessoa.getDataNasc().substring(0, 4);
//			} 
//			saida.println("<h1>");
//			saida.println("Confirme a exclusão da seguinte pessoa: <br>");
//			saida.println("</h1>");
//			saida.println("Nome: "+pessoa.getNome()+"<br>");
//			saida.println("Idade: "+pessoa.getIdade()+"<br>");
//			saida.println("Data Nascimento: "+dataFormatada+"<br>");
//			saida.println("Cidade: "+pessoa.getCidade()+"<br>");
//			saida.println("Estado Civil: "+pessoa.getEstadoCivil()+"<br>");
//			
//
////			request.setAttribute("pessoa", pessoa);			
////			RequestDispatcher rd = request.getRequestDispatcher("/alterarpessoa.jsp");
////			rd.forward(request, response);
//		}		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
