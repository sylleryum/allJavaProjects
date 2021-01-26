package ad2;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//import ad2.Datasource;

/**
 * Servlet implementation class InserirPessoa
 */
@WebServlet("/InserirPessoa")
public class InserirPessoa extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Datasource ds = null;
	public PrintWriter saida;

	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
		ds = new Datasource();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		doPost(request, response);
	}

	////////////////// post
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ds.open();
		System.out.println("Conectado? " + ds.getConexao());
		String nome = request.getParameter("iNome");
		int idade = Integer.parseInt(request.getParameter("iIdade"));
		String nasc = request.getParameter("iNasc");
		String cidade = request.getParameter("iCidade");
		String estadoC = request.getParameter("check[]");
		
		// salvar nova pessoa
		boolean checkSave = ds.saveToDb(nome, idade, nasc, cidade, estadoC);
		System.out.println("Incluido com sucesso? " + checkSave);
		
		request.setAttribute("status", "inserida");			
		RequestDispatcher rd = request.getRequestDispatcher("listar?acao=lista");
		rd.forward(request, response);
		//listar?acao=lista
		
		ds.close();
		
	}

}
