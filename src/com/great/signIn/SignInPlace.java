package com.great.signIn;

import java.io.IOException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.heima.test.Utils;

import net.sf.json.util.JSONStringer;

/**
 * Servlet implementation class SignInPlace
 */
public class SignInPlace extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SignInPlace() {
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
	         //String  sign_stuId = "170327099";  
	 		 //String   place_id = "East1"; 
   
	         String sign_stuId = request.getParameter("sign_stuId");
	         System.out.println("sign_stuId:"+sign_stuId);
	         String place_id = request.getParameter("place_id");
	         System.out.println("place_id:"+place_id);
	         String sign_stuName = request.getParameter("sign_stuName");
	         System.out.println("sign_stuName:"+sign_stuName);
	         String sign_stuSeat = request.getParameter("sign_stuSeat");
	         System.out.println("sign_stuSeat:"+sign_stuSeat);
	         String sign_courseId = request.getParameter("sign_courseId");
	         System.out.println("sign_courseId:"+sign_courseId);
	         String sign_courseName = request.getParameter("sign_courseName");
	         System.out.println("sign_courseName:"+sign_courseName);
	         
	         
	         
	        String sql="insert into t_signIn(sign_stuId,place_id,sign_stuName,sign_stuSeat,sign_courseId,sign_courseName) values('"+sign_stuId+"','"+place_id+"','"+sign_stuName+"','"+sign_stuSeat+"','"+sign_courseId+"','"+sign_courseName+"')";
	        Statement stm = Utils.connectDB(sql);
	        boolean isExecuted = stm.execute(sql);
	        System.out.println("isExecuted   "+isExecuted);
	        JSONStringer stringer = new JSONStringer();
			stringer.object();
			stringer.key("data");
			stringer.array();
	        if(isExecuted==false) {//Java API Statement类的execute的确返回Boolean 型。他指的是否返回ResultSet对象；对插入，更新,来说没有返回对象所以就是false!!!
//	        	JSONStringer stringer = Utils.showCollege(stm);
//	        	response.getOutputStream().write(stringer.toString().getBytes("utf-8"));
//				
//				String string = new String(stringer.toString().getBytes("utf-8"));
//				System.out.println(string);
//				System.out.println("json return success");
	        	
				
	        	stringer.object();
				stringer.key("state");
				stringer.value("SignSuccess");
				stringer.endObject();
	        }else {
	        	stringer.object();
				stringer.key("state");
				stringer.value("updateFailure");
				stringer.endObject();
	        	//response.getOutputStream().write("Executed fail".getBytes("utf-8"));
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
