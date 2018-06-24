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
 * Servlet implementation class StudentCourse
 */
public class StudentCourse extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentCourse() {
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
	        String student_id = request.getParameter("student_id");
	        System.out.println("student_id"+ student_id );
	        String course_id1 = request.getParameter("course_id1");
	        System.out.println("course_id1"+ course_id1 );
	        String student_name = request.getParameter("student_name");
	        System.out.println("student_name"+ student_name );
	       
	        String sql="insert into t_student_course(student_id,course_id1,student_name) values('"+student_id+"','"+course_id1+"','"+student_name+"')";
	        Statement stm;
	        stm = Utils.connectDB(sql);
	        boolean isExecuted = stm.execute(sql);
	        System.out.println("isExecuted   "+isExecuted);
	        if(isExecuted==false) {//Java API Statement类的execute的确返回Boolean 型。他指的是否返回ResultSet对象；对插入，更新,来说没有返回对象所以就是false!!!
	        	JSONStringer stringer = Utils.showStudentCourse(stm);
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
