package ad2;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ad2.Datasource;

/**
 * Servlet implementation class ListarPessoa
 */
@WebServlet("/ListarPessoa")
public class ListarPessoa extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Datasource ds = null;
	private List<Pessoa> listPessoas = null;
	
	@Override
	public void init() throws ServletException {
		super.init();
		ds = new Datasource();		
		ds.open();
		
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				
		String acao = "lista";//request.getParameter("acao");
		
		//System.out.println("Lista: "+acao);
		if (acao.equals("lista")) {
			listPessoas = ds.returnPessoa();			
			request.setAttribute("pessoa", listPessoas);
			request.setAttribute("status", request.getAttribute("status"));
			RequestDispatcher rd = request.getRequestDispatcher("/listarpessoas.jsp");
			rd.forward(request, response);
		}
		
	}

	
	
	/////////post
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
