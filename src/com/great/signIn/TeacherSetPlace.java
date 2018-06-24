package com.great.signIn;

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
 * Servlet implementation class TeacherSetPlace
 */
public class TeacherSetPlace extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TeacherSetPlace() {
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
	        
	        //String place_id = "East1";
			//String place_longitude = "136.4509";
			//String place_latitude ="26.2445";
	        //String place_longitude = "180.000001";
	        //String place_latitude ="0.0000056";
	        String place_id = request.getParameter("place_id");
	        System.out.println("place_id"+ place_id );
	        String place_longitude = request.getParameter("place_longitude");
	        System.out.println("place_longitude"+ place_longitude );
	        String place_latitude = request.getParameter("place_latitude");
	        System.out.println("place_latitude"+ place_latitude );
	       
	        
	       
			 String sql = "update t_place set place_longitude='"+place_longitude+"' , place_latitude='"+place_latitude+"' where place_id='"+place_id+"'";
				
		        Statement stm = Utils.connectDB(sql);
						
				int executeUpdate = stm.executeUpdate(sql);
				System.out.println("executeUpdate   "+executeUpdate);
				JSONStringer stringer = new JSONStringer();
				stringer.object();
				stringer.key("data");
				stringer.array();
				//stringer.object();
				if(executeUpdate==1){
					//stringer.object();
					stringer.object();
					stringer.key("state");
					stringer.value("updateSuccess");
					//response.getWriter().write("success");
					//JSONStringer stringer = Utils.showTeacher(stm);
					//response.getOutputStream().write(stringer.toString().getBytes("utf-8"));

					//String string = new String(stringer.toString().getBytes("utf-8"));
					//System.out.println(string);
					//System.out.println("update success");
					//stringer.endArray();
					stringer.endObject();
					
				}else {
					//response.getOutputStream().write("updata failed".getBytes("utf-8"));
					//stringer.object();
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
