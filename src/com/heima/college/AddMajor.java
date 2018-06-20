package com.great.college;

import java.io.IOException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.heima.test.Utils;

import net.sf.json.util.JSONStringer;

/**
 * Servlet implementation class AddMajor
 */
public class AddMajor extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddMajor() {
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
	         
   
	         String id = request.getParameter("id");
	         System.out.println("id:"+id);
	         String name = request.getParameter("name");
	         System.out.println("name:"+name);
	         String collegeId =request.getParameter("collegeId");
	         System.out.println("collegeId:"+collegeId);
	         
	         
	         
	        String sql="insert into t_major(id,name,collegeId) values('"+id+"','"+name+"','"+collegeId+"')";
	        Statement stm = Utils.connectDB(sql);
	       
	        boolean isExecuted = stm.execute(sql);
	        System.out.println("isExecuted   "+isExecuted);
	        if(isExecuted==false) {//Java API Statement类的execute的确返回Boolean 型。他指的是否返回ResultSet对象；对插入，更新,来说没有返回对象所以就是false!!!
	        	JSONStringer stringer = Utils.showMajor(stm);
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
