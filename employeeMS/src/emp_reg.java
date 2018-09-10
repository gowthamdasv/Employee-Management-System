
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



/**
 * Servlet implementation class emp_reg
 */
@WebServlet("/emp_reg")
public class emp_reg extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		try {

			int empID=Integer.parseInt(request.getParameter("empID"));
			String empname = request.getParameter("empname");
			String empD=request.getParameter("empD");
			String ReportM=request.getParameter("ReportM");
			
			response.setContentType("text/html");

			Class.forName("com.mysql.jdbc.Driver").newInstance();

			Connection con = DriverManager.getConnection("jdbc:mysql://localhost/ems","root","root");

			String SQL="insert into emp_details values(?,?,?,?);";
			
			
			PreparedStatement pstmt = con.prepareStatement(SQL);
			
			pstmt.setInt(1, empID); 	
			pstmt.setString(2, empname);
			pstmt.setString(3, empD);
			pstmt.setString(4, ReportM);
			pstmt.executeUpdate();
			
			response.sendRedirect("home.html");
			
			
			con.close();
		} catch (Exception e) {
			System.err.println("Got an exception!");
		      System.err.println(e.getMessage());
		}
	}

}
