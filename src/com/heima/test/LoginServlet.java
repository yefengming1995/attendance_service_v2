package com.heima.test;

import java.io.IOException;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.util.JSONStringer;

import com.mysql.jdbc.Connection;

public class LoginServlet extends HttpServlet {

	/**
	 * The doGet method of the servlet. <br>
	 * 
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request
	 *            the request send by the client to the server
	 * @param response
	 *            the response send by the server to the client
	 * @throws ServletException
	 *             if an error occurred
	 * @throws IOException
	 *             if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			 response.setContentType("text/html;charset=utf-8");
	         request.setCharacterEncoding("utf-8");
	         
	         
	         
	        Class.forName("com.mysql.jdbc.Driver");

	         
	          java.sql.Connection connection =  DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/database","root", "admin");
		         
		      System.out.println("connection1 success");
		      System.out.println("aaaa");
		         
	         
	         Statement statement = connection.createStatement();
	         
	        String sql="select * from t_user";
			ResultSet resultSet = statement.executeQuery(sql);
			JSONStringer stringer = new JSONStringer();
			stringer.object();
			stringer.key("data");
			stringer.array();
			
	        	while (resultSet.next()) {
						String name = resultSet.getString("name");
						System.out.println("name      "+name);
						String password1 = resultSet.getString("password");
						System.out.println("password    "+password1);
						String role1 = resultSet.getString("role");
						System.out.println("role    "+role1);
						String rolename = resultSet.getString("rolename");
						System.out.println("rolename    "+rolename);
						System.out.println("chaxun success");
						stringer.object();
						stringer.key("name");
						stringer.value(name);
						
						stringer.key("password");
						stringer.value(password1);
						
						stringer.key("role");
						stringer.value(role1);
						
						stringer.key("rolename");
						stringer.value(rolename);
						
						stringer.endObject();
						//response.reset();
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
	 * The doPost method of the servlet. <br>
	 * 
	 * This method is called when a form has its tag value method equals to
	 * post.
	 * 
	 * @param request
	 *            the request send by the client to the server
	 * @param response
	 *            the response send by the server to the client
	 * @throws ServletException
	 *             if an error occurred
	 * @throws IOException
	 *             if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("post方式提交数据");
		doGet(request, response);
	}

}
