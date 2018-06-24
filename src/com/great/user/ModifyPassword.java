package com.great.user;

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
 * Servlet implementation class ModifyPassword
 */
public class ModifyPassword extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModifyPassword() {
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
			
			String userid = request.getParameter("userid");
			//String userid = "170327099";
			System.out.println("userid   "+userid);
			//String password = "888888";
	        String password = request.getParameter("password");
	        System.out.println("password   "+password);

	        
	        
	         String sql = "update t_user set password='"+password+"' where  userid='"+userid+"' ";
			
	        Statement stm = Utils.connectDB(sql);
					
			int executeUpdate = stm.executeUpdate(sql);
			System.out.println("executeUpdate   "+executeUpdate);
			JSONStringer stringer = new JSONStringer();
			stringer.object();
			stringer.key("data");
			stringer.array();
			if(executeUpdate==1){
				stringer.object();
				stringer.key("state");
				stringer.value("updateSuccess");
				stringer.endObject();
				
			}else {
				stringer.object();
				stringer.key("state");
				stringer.value("updateFailure");
				//System.out.println("update failure");
				//stringer.endArray();
				stringer.endObject();
				
			}
			stringer.endArray();
			stringer.endObject();
			
            response.getOutputStream().write(stringer.toString().getBytes("utf-8"));
            String string = new String(stringer.toString().getBytes("utf-8"));
			System.out.println(string);
			
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
