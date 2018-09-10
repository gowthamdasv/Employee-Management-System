package db;


import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class db
 */
@WebServlet("/db")
public class db extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();

			Connection con = DriverManager.getConnection("jdbc:mysql://localhost/ems","root","root");
			Statement stmt=con.createStatement();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
