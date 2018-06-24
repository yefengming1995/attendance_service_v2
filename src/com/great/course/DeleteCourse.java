package com.great.course;

import java.io.IOException;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.heima.test.Utils;

import net.sf.json.util.JSONStringer;

/**
 * Servlet implementation class DeleteCourse
 */
public class DeleteCourse extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteCourse() {
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
	         
	         String course_id = request.getParameter("course_id");
	         System.out.println("course_id    "+course_id);
	         
	         String sql="delete from t_newcourse where course_id='"+course_id+"'";
	      
	         Statement stm = Utils.connectDB(sql);
	         
			boolean isExecuted = stm.execute(sql);
			System.out.println("isExecuted   "+isExecuted);
	        if(isExecuted==false) {//Java API Statement类的execute的确返回Boolean 型。他指的是否返回ResultSet对象；对插入，更新,来说没有返回对象所以就是false!!!
	        	JSONStringer stringer = Utils.showCourse(stm);
	        	response.getOutputStream().write(stringer.toString().getBytes("utf-8"));
				
				String string = new String(stringer.toString().getBytes("utf-8"));
				System.out.println(string);
				System.out.println("json return success");
	        }else {
	        	response.getOutputStream().write("Executed fail".getBytes("utf-8"));
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
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
