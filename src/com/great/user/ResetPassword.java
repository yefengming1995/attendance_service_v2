package com.great.user;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.heima.test.Utils;

import net.sf.json.util.JSONStringer;

/**
 * Servlet implementation class ResetPassword
 */
public class ResetPassword extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ResetPassword() {
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
	         
   
	         String userid = request.getParameter("userid");
	         //String userid = "170327099";
	         System.out.println("userid"+ userid );
	         
	         
	         
	         String sql="select * from t_user where  userid='"+userid+"'";
	         String sql1 = "update t_user set password='123456'  where userid='"+userid+"'";
	        Statement stm = Utils.connectDB(sql);
	        ResultSet resultSet=stm.executeQuery(sql);
	        JSONStringer stringer = new JSONStringer();
			stringer.object();
			stringer.key("data");
			stringer.array();
			int count=0;
			while(resultSet.next()){
			count++;
			}
			resultSet.beforeFirst();
			//if(resultSet.getString("student_id") == null) {
			if(count == 0) {
				System.out.println("用户不存在");
				stringer.object();
				stringer.key("status");
				stringer.value("useridWrong");
				stringer.endObject();
			}else {
				int executeUpdate = stm.executeUpdate(sql1);
				System.out.println("executeUpdate   "+executeUpdate);
			
				if(executeUpdate==1){
					
					//response.getWriter().write("success");
					stringer.object();
					stringer.key("status");
					stringer.value("ResetSucess");
					stringer.endObject();
					
				}else {
					System.out.println("更新失败");
					stringer.object();
					stringer.key("status");
					stringer.value("resetFail");
					stringer.endObject();
					
				}
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
