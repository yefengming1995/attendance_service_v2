package com.great.leave;

import java.io.IOException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.heima.test.Utils;

import net.sf.json.util.JSONStringer;

/**
 * Servlet implementation class StudentAskLeave
 */
public class StudentAskLeave extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentAskLeave() {
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
	         
  
	         String course_id = request.getParameter("course_id");
	         //String course_id = "123";
	         System.out.println("course_id:"+course_id);
	         String course_name = request.getParameter("course_name");
	         //String course_name = "223";
	         System.out.println("course_name:"+course_name);
	         String student_id =request.getParameter("student_id");
	         //String student_id ="323";
	         System.out.println("student_id:"+student_id);
	         String student_name =request.getParameter("student_name");
	         //String student_name ="423";
	         System.out.println("student_name:"+student_name);
	         String leave_reason =request.getParameter("leave_reason");
	         //String leave_reason ="523";
	         System.out.println("leave_reason:"+leave_reason);
	         
	         
	         
	        String sql="insert into t_leave(course_id,course_name,student_id,student_name,leave_reason) values('"+course_id+"','"+course_name+"','"+student_id+"','"+student_name+"','"+leave_reason+"')";
	        Statement stm = Utils.connectDB(sql);
	       
	        boolean isExecuted = stm.execute(sql);
	        System.out.println("isExecuted   "+isExecuted);
	        JSONStringer stringer = new JSONStringer();
			stringer.object();
			stringer.key("data");
			stringer.array();
	        if(isExecuted==false) {//Java API Statement类的execute的确返回Boolean 型。他指的是否返回ResultSet对象；对插入，更新,来说没有返回对象所以就是false!!!
	        	//JSONStringer stringer = Utils.showMajor(stm);
	        	
	        	stringer.object();
				stringer.key("state");
				stringer.value("LeaveAllowed");
				stringer.endObject();
	        }else {
	        	stringer.object();
				stringer.key("state");
				stringer.value("LeaveDenied");
				stringer.endObject();
			}
	        
	        stringer.endArray();
			stringer.endObject();
			
          response.getOutputStream().write(stringer.toString().getBytes("utf-8"));
          String string = new String(stringer.toString().getBytes("utf-8"));
			System.out.println(string);
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
