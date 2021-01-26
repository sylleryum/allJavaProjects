package tests;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.luv2code.springdemo.dao.CustomerDAO;
import com.luv2code.springdemo.dao.CustomerDAOImpl;
import com.luv2code.springdemo.entity.Customer;

/**
 * Servlet implementation class TestDBConnection
 */
@WebServlet("/TestDBConnection")
public class TestDBConnection extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public TestDBConnection() {
        
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String user = "sqluser";
		String pass = "sql123";		
		
		String jdbcUrl = "jdbc:mysql://localhost:3306/web_customer_tracker?userSSL=false";
		String driver = "com.mysql.jdbc.Driver";
		
		try{
			PrintWriter out = response.getWriter();
			
			CustomerDAOImpl DAO = new CustomerDAOImpl();
			List<Customer> theCustomers = DAO.getCustomers();
			
			out.println("connecting to database " +jdbcUrl);
			Class.forName(driver);
			
			Connection conn = DriverManager.getConnection(jdbcUrl, user, pass);
			
			out.print("success");
			out.println("success writing: "+theCustomers);
			
			conn.close();
			
		}catch (Exception e){
			e.printStackTrace();
			throw new ServletException(e);
		}
		
	}

}
