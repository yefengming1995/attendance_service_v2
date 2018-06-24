package com.great.leave;

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
 * Servlet implementation class TeacherCheckLeave
 */
public class TeacherCheckLeave extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TeacherCheckLeave() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("utf-8");
        //String course_id="c1";
        String course_id = request.getParameter("course_id");
        System.out.println("course_id" +course_id);
        
		try {
			String sql="select * from t_leave where course_id='"+course_id+"'";
			Statement stm;
			stm = Utils.connectDB(sql);
			ResultSet resultSet = stm.executeQuery(sql);
			JSONStringer stringer = new JSONStringer();
			stringer.object();
			stringer.key("data");
			stringer.array();
			
				while (resultSet.next()) {
						String record_id = resultSet.getString("record_id");
						System.out.println("record_id      "+record_id);
						String course_id1 = resultSet.getString("course_id");
						System.out.println("course_id    "+course_id1);
						String course_name = resultSet.getString("course_name");
						System.out.println("course_name    "+course_name);
						String student_id  = resultSet.getString("student_id");
						System.out.println("student_id     "+student_id );
						String  student_name = resultSet.getString("student_name");
						System.out.println("student_name    "+ student_name);
						String leave_reason= resultSet.getString("leave_reason");
						System.out.println("leave_reason    "+leave_reason);
						
						System.out.println("utils success");
						stringer.object();
						stringer.key("record_id");
						stringer.value(record_id);
						
						stringer.key("course_id");
						stringer.value(course_id1);
						
						stringer.key("course_name");
						stringer.value(course_name);
						
						stringer.key("student_id");
						stringer.value(student_id);
						
						stringer.key("student_name");
						stringer.value(student_name);
						
						
						stringer.key("leave_reason");
						stringer.value(leave_reason);
						
						
						//stringer.key("student_idBack");
						//tringer.value(student_idBack);
						
						;
						
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
