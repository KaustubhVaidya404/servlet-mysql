package studentservel;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/FormMW")
public class FormMW extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public FormMW() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		PrintWriter pw;
		pw = response.getWriter();
		
		String stdid = request.getParameter("stdid");
		String stdname = request.getParameter("stdname");
		String stdrollno = request.getParameter("stdrollno");
		String stdemail = request.getParameter("stdemail");
		String stdbranch = request.getParameter("stdbranch");
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Database loaded...");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/practice","root","Password@123");
			String insertsql = "insert into stdinfo values(?,?,?,?,?)";
			PreparedStatement ps = con.prepareStatement(insertsql);
			ps.setString(1, stdid);
			ps.setString(2, stdname);
			ps.setString(3, stdrollno);
			ps.setString(4, stdemail);
			ps.setString(5, stdbranch);
			ps.execute();
			pw.println("Done");
			pw.close();
			con.close();
			} catch (ClassNotFoundException e) {
			e.printStackTrace(); 
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
