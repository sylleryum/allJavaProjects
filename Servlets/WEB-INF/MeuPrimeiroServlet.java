import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class MeuPrimeiroServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		PrintWriter saida = response.getWriter();
		java.util.Date hoje = new java.util.Date();
		saida.println("<html>");
		saida.println("<body>");
		saida.println("Hoje é: " + hoje);
		saida.println("</body>");
		saida.println("</html>");
	}
}