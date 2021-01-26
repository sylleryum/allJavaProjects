package ad2;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AlterarPessoa
 */
@WebServlet("/AlterarPessoa")
public class AlterarPessoa extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Datasource ds = null;
	
	
    public AlterarPessoa() {

    }

	@Override
	public void init() throws ServletException {
		super.init();
		ds = new Datasource();		
		ds.open();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
		
		
	}

	///////post
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		//alterar
				if (request.getParameter("iNome")!=null) {
					//System.out.println(request.getParameter("iNasc"));
					boolean status = ds.updateToDb(request.getParameter("iNome"), Integer.parseInt(request.getParameter("iIdade")), 
							request.getParameter("iNasc"), request.getParameter("iCidade"), 
							request.getParameter("check[]"), Integer.parseInt(request.getParameter("iID")));
					request.setAttribute("status", "alterada");
					RequestDispatcher rd = request.getRequestDispatcher("listar?acao=lista");
					rd.forward(request, response);
				//procurar pessoa para alterar	
				} else {
					int pessoaID = Integer.parseInt(request.getParameter("ID"));		
					System.out.println("PessoaID: "+ pessoaID);
					Pessoa pessoa = ds.alterar(pessoaID);
					if (pessoa.getPessoaID()==-1) {		
						System.out.println("Pessoa não encontrado");
						request.setAttribute("pessoa", pessoa);			
						RequestDispatcher rd = request.getRequestDispatcher("/alterarpessoa.jsp");
						rd.forward(request, response);
					} else {
						System.out.println("pessoa: " +pessoa.getNome());
						request.setAttribute("pessoa", pessoa);			
						RequestDispatcher rd = request.getRequestDispatcher("/alterarpessoa.jsp");
						rd.forward(request, response);
					}
				}
	}

}
