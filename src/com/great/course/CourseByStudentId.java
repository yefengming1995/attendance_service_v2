package com.great.course;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.heima.test.Utils;

import net.sf.json.util.JSONStringer;

/**
 * Servlet implementation class CourseByStudentId
 */
public class CourseByStudentId extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CourseByStudentId() {
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
	        
	        String student_id = request.getParameter("student_id");
	         System.out.println("student_id"+ student_id );
			String sql;
			sql="select * from v_student_course where student_id ='"+student_id+"'";

			Statement stm;
			stm = Utils.connectDB(sql);
			ResultSet resultSet = stm.executeQuery(sql);
			JSONStringer stringer = new JSONStringer();
			stringer.object();
			stringer.key("data");
			stringer.array();
			
				while (resultSet.next()) {
						String course_id = resultSet.getString("course_id");
						System.out.println("course_id      "+course_id);
						String place_id1 = resultSet.getString("place_id1");
						System.out.println("place_id1    "+place_id1);
						String place_name = resultSet.getString("place_name");
						System.out.println("place_name    "+place_name);
						String course_name = resultSet.getString("course_name");
						System.out.println("course_name    "+course_name);
						String course_score = resultSet.getString("course_score");
						System.out.println("course_score    "+course_score);
						String course_time = resultSet.getString("course_time");
						System.out.println("course_time    "+course_time);
						String course_single_double = resultSet.getString("course_single_double");
						System.out.println("course_single_double    "+course_single_double);
						String course_day = resultSet.getString("course_day");
						System.out.println("course_day    "+course_day);
						String class_scope = resultSet.getString("class_scope");
						System.out.println("class_scope    "+class_scope);
						String course_towho = resultSet.getString("course_towho");
						System.out.println("course_towho    "+course_towho);
						String class_weekscope = resultSet.getString("class_weekscope");
						System.out.println("class_weekscope    "+class_weekscope);
						//String student_idBack = resultSet.getString("student_idBack");
						String student_idBack = resultSet.getString("student_id");
						System.out.println("student_idBack    "+student_idBack);
						String student_name = resultSet.getString("student_name");
						System.out.println("student_name    "+student_name);
						//student_id
						System.out.println("utils success");
						stringer.object();
						stringer.key("course_id");
						stringer.value(course_id);
						
						stringer.key("place_id1");
						stringer.value(place_id1);
						
						stringer.key("place_name");
						stringer.value(place_name);
						
						stringer.key("course_name");
						stringer.value(course_name);
						
						stringer.key("course_score");
						stringer.value(course_score);
						
						stringer.key("course_time");
						stringer.value(course_time);
						
						stringer.key("course_single_double");
						stringer.value(course_single_double);
						
						stringer.key("course_day");
						stringer.value(course_day);
						
						stringer.key("class_scope");
						stringer.value(class_scope);
						
						
						stringer.key("course_towho");
						stringer.value(course_towho);
						
						stringer.key("class_weekscope");
						stringer.value(class_weekscope);
						
						//stringer.key("student_idBack");
						//tringer.value(student_idBack);
						
						stringer.key("student_name");
						stringer.value(student_name);
						
						stringer.endObject();
						//response.reset();
				}
				stringer.endArray();
				stringer.endObject();
                response.getOutputStream().write(stringer.toString().getBytes("utf-8"));
				
				String string = new String(stringer.toString().getBytes("utf-8"));
				System.out.println(string);
				System.out.println("json return success");
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
