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
 * Servlet implementation class UpdateCourse
 */
public class UpdateCourse extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateCourse() {
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
	         System.out.println("course_id"+ course_id );
	         String course_name = request.getParameter("course_name");
	         String course_score = request.getParameter("course_score");
	         String course_time = request.getParameter("course_time");
	         
	        
	         String sql = "update t_newcourse set course_name='"+ course_name+"' ,  course_score='"+ course_score+"', course_time='"+ course_time+"' where course_id='"+course_id+"'";
		
	        Statement stm = Utils.connectDB(sql);
					
			int executeUpdate = stm.executeUpdate(sql);
			System.out.println("executeUpdate   "+executeUpdate);
		
			if(executeUpdate==1){
				
				//response.getWriter().write("success");
				JSONStringer stringer = Utils.showCourse(stm);
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
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
