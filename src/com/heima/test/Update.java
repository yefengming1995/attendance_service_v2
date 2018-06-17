package com.heima.test;

import java.io.IOException;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.PreparedStatement;

import net.sf.json.util.JSONStringer;

/**
 * Servlet implementation class Update
 */
public class Update extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Update() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// response.getWriter().append("Served at: ").append(request.getContextPath());
		try {

			response.setContentType("text/html;charset=utf-8");
			request.setCharacterEncoding("utf-8");
			
			 String id = request.getParameter("id");
			 System.out.println("id   "+id);
	         String username = request.getParameter("username");
	         System.out.println("username   "+username);
//	         String password = request.getParameter("password");
//	         String sex = request.getParameter("sex");
//	         String role = request.getParameter("role");
	         String phone = request.getParameter("phone");
	         System.out.println("phone   "+phone);
//	         String email = request.getParameter("email");
	        
	         String sql = "update t_user set name='"+username+"' , phone='"+phone+"'  where id='"+id+"'";
			
	        Statement stm = Utils.connectDB(sql);
					
			int executeUpdate = stm.executeUpdate(sql);
			System.out.println("executeUpdate   "+executeUpdate);
		
			if(executeUpdate==1){
				
				//response.getWriter().write("success");
				JSONStringer stringer = Utils.show(stm);
				response.getOutputStream().write(stringer.toString().getBytes("utf-8"));

				String string = new String(stringer.toString().getBytes("utf-8"));
				System.out.println(string);
				System.out.println("json return success");
				
			}else {
				response.getOutputStream().write("updata failed".getBytes("utf-8"));
				
			}

			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
