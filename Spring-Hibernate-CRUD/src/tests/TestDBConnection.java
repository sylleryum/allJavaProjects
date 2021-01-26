package tests;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;

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
			
			out.println("connecting to database " +jdbcUrl);
			Class.forName(driver);
			
			Connection conn = DriverManager.getConnection(jdbcUrl, user, pass);
			
			out.print("success");
			
			conn.close();
			
		}catch (Exception e){
			e.printStackTrace();
			throw new ServletException(e);
		}
		
	}

}
