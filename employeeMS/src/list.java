

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.JspWriter;
/**
 * Servlet implementation class list
 */
@WebServlet("/list")
public class list extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost/ems","root","root");
			Statement stmt=con.createStatement();
			
			PrintWriter out=response.getWriter();
			out.print("<html><body>");
			out.print("<ul>");
			String q1="select * from ems.emp_details where reporting_man='-'";
			ResultSet r1=stmt.executeQuery(q1);
			r1.next();
			out.print("<li>"+r1.getString(2));
			out.print("</li></ul> </body> </html>");
			
			
			
			r1.close();
			con.close();
			stmt.close();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
	}

}
