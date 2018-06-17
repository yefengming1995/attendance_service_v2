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

import net.sf.json.util.JSONStringer;

/**
 * Servlet implementation class LoginJudge
 */
public class LoginJudge extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginJudge() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
        
        
        try {
			 response.setContentType("text/html;charset=utf-8");
	         request.setCharacterEncoding("utf-8");
	         
	         response.setContentType("text/html;charset=utf-8");
	         request.setCharacterEncoding("utf-8");
	         String username = request.getParameter("username");
	         System.out.println("username"+username);
	         String password = request.getParameter("password");
	         System.out.println("password"+password);
	         
	         
	         Class.forName("com.mysql.jdbc.Driver");

	         
	          java.sql.Connection connection =  DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/database","root", "admin");
		         
		      System.out.println("connection1 success");
		      System.out.println("aaaa");
		         
	         
	         Statement statement = connection.createStatement();
	         
	        String sql="select * from t_user,t_role where t_user.role=t_role.roleid and t_user.name='"+username+"'and t_user.password='"+password+"'";
			ResultSet resultSet = statement.executeQuery(sql);
			JSONStringer stringer = new JSONStringer();
			stringer.object();
			stringer.key("data");
			stringer.array();
	               
	       
	        while(resultSet.next())
	        {
	        	System.out.println(resultSet.getString(1)+" "+resultSet.getString(1)+" "+resultSet.getString(1)+" ");
	        	String name = resultSet.getString("name");
				System.out.println("name      "+name);
				String password1 = resultSet.getString("password");
				System.out.println("password    "+password1);
				String role1 = resultSet.getString("role");
				System.out.println("role    "+role1);
				String keys = resultSet.getString("keys");
				System.out.println("keys    "+keys);
				
				System.out.println("chaxun success");
				stringer.object();
				stringer.key("name");
				stringer.value(name);
				
				stringer.key("password");
				stringer.value(password1);
				
				stringer.key("role");
				stringer.value(role1);
				
				stringer.key("keys");
				stringer.value(keys);
				
				
				
				stringer.endObject();
	        }
	        
	        stringer.endArray();
        	stringer.endObject();
        	response.getOutputStream().write(stringer.toString().getBytes("utf-8"));
			
			String string = new String(stringer.toString().getBytes("utf-8"));
			System.out.println(string);
			System.out.println("json return success");
		       
	        
	       
			
        } catch (Exception e) {
			// TODO: handle exception
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
