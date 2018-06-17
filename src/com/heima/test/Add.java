package com.heima.test;

import java.io.BufferedReader;
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
 * Servlet implementation class Add
 */
public class Add extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Add() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		System.out.println("dao le ma ");
		try {
			 response.setContentType("text/html;charset=utf-8");
	         request.setCharacterEncoding("utf-8");
	         
       
	         String id = request.getParameter("id");
	         String username = request.getParameter("username");
	         String password = request.getParameter("password");
	         String sex = request.getParameter("sex");
	         String role = request.getParameter("role");
	         String phone = request.getParameter("phone");
	         String email = request.getParameter("email");
	         
	         
	        String sql="insert into t_user(id,name,password,sex,role,phone,email) values('"+id+"','"+username+"','"+password+"','"+sex+"','"+role+"','"+phone+"','"+email+"')";
	        Statement stm = Utils.connectDB(sql);
	       
	        boolean isExecuted = stm.execute(sql);
	        System.out.println("isExecuted   "+isExecuted);
	        if(isExecuted==false) {//Java API Statement类的execute的确返回Boolean 型。他指的是否返回ResultSet对象；对插入，更新,来说没有返回对象所以就是false!!!
	        	JSONStringer stringer = Utils.show(stm);
	        	response.getOutputStream().write(stringer.toString().getBytes("utf-8"));
				
				String string = new String(stringer.toString().getBytes("utf-8"));
				System.out.println(string);
				System.out.println("json return success");
	        }else {
	        	response.getOutputStream().write("Executed fail".getBytes("utf-8"));
			}
	        
	        
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
