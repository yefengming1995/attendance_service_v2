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
 * Servlet implementation class TeacherCourse
 */
public class TeacherCourse extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TeacherCourse() {
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
	        

	        String record_id = request.getParameter("record_id");
	        System.out.println("record_id"+ record_id );
	        String teacher_id = request.getParameter("teacher_id");
	        System.out.println("teacher_id"+ teacher_id );
	        String course_id1 = request.getParameter("course_id1");
	        System.out.println("course_id1"+ course_id1 );
	        String teacher_name = request.getParameter("teacher_name");
	        System.out.println("teacher_name"+ teacher_name );
	       
	        if(teacher_id == null || course_id1 == null || teacher_name ==null ){
	        	System.out.println("hahaha");
	        	Statement stm;
	        	String sql="";
	        	stm = Utils.connectDB(sql);
	        	JSONStringer stringer = Utils.showTeacherCourse(stm);
	        	response.getOutputStream().write(stringer.toString().getBytes("utf-8"));
				
				String string = new String(stringer.toString().getBytes("utf-8"));
				System.out.println(string);
				System.out.println("json return success");
	        
	        }
	        else
	        {
	        	System.out.println("y");
	        	String sql="insert into t_teacher_course(teacher_id,course_id1,teacher_name) values('"+teacher_id+"','"+course_id1+"','"+teacher_name+"')";
		        Statement stm;
		        stm = Utils.connectDB(sql);
		        boolean isExecuted = stm.execute(sql);
		        System.out.println("isExecuted   "+isExecuted);
		        if(isExecuted==false) {//Java API Statement类的execute的确返回Boolean 型。他指的是否返回ResultSet对象；对插入，更新,来说没有返回对象所以就是false!!!
		        	JSONStringer stringer = Utils.showTeacherCourse(stm);
		        	response.getOutputStream().write(stringer.toString().getBytes("utf-8"));
					
					String string = new String(stringer.toString().getBytes("utf-8"));
					System.out.println(string);
					System.out.println("json return success");
		        }else {
		        	response.getOutputStream().write("Executed fail".getBytes("utf-8"));
				}
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
