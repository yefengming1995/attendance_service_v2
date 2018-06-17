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

/**
 * Servlet implementation class SelectTeacher
 */
public class SelectTeacher extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SelectTeacher() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		try {
			 response.setContentType("text/html;charset=utf-8");
	         request.setCharacterEncoding("utf-8");
	         
	         
	         
	        Class.forName("com.mysql.jdbc.Driver");

	         
	          java.sql.Connection connection =  DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/database","root", "admin");
		         
		      System.out.println("connection1 success");
		      System.out.println("aaaa");
		         
	         
	         Statement statement = connection.createStatement();
	         
	        String sql="select * from t_teacher";
			ResultSet resultSet = statement.executeQuery(sql);
			JSONStringer stringer = new JSONStringer();
			stringer.object();
			stringer.key("data");
			stringer.array();
			
	        	while (resultSet.next()) {
						String id = resultSet.getString("id");
						System.out.println("id      "+id);
						String collegeId = resultSet.getString("collegeId");
						System.out.println("collegeId    "+collegeId);
						String proTitle = resultSet.getString("proTitle");
						System.out.println("proTitle    "+proTitle);
						String name = resultSet.getString("name");
						System.out.println("name    "+name);
						String sex = resultSet.getString("sex");
						System.out.println("sex    "+sex);
						System.out.println("chaxun success");
						stringer.object();
						stringer.key("id");
						stringer.value(id);
						
						
						
						stringer.key("collegeId");
						stringer.value(collegeId);
						
						stringer.key("proTitle");
						stringer.value(proTitle);
						
						stringer.key("name");
						stringer.value(name);
						
						stringer.key("sex");
						stringer.value(sex);
						
						
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
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
