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
 * Servlet implementation class StudentGetPlace
 */
public class StudentGetPlace extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentGetPlace() {
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
	       
	        // String place_longitude = request.getParameter("place_longitude");
	        //System.out.println("place_longitude"+ place_longitude );
	        //String place_latitude = request.getParameter("place_latitude");
	        //System.out.println("place_latitude"+ place_latitude );
	       
	        
	       
			 String sql = "select * from t_place where place_id ='"+place_id+"'";
				
		        Statement stm = Utils.connectDB(sql);
						
				
				ResultSet resultSet = stm.executeQuery(sql);
				
				JSONStringer stringer = new JSONStringer();
				stringer.object();
				stringer.key("data");
				stringer.array();
				
				
					while (resultSet.next()) {
							String place_longitude = resultSet.getString("place_longitude");
							System.out.println("place_longitude      "+place_longitude);
							String place_latitude= resultSet.getString("place_latitude");
							System.out.println("place_latitude        "+place_latitude  );
							
							
							
							stringer.object();
							
							stringer.key("place_longitude");
							stringer.value(place_longitude);
							
							stringer.key("place_latitude");
							stringer.value(place_latitude);
							
							
							
							
							stringer.endObject();
							//response.reset();
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
