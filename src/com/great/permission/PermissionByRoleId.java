package com.great.permission;

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
 * Servlet implementation class PermissionByRoleId
 */
public class PermissionByRoleId extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PermissionByRoleId() {
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
	        
	        String role_id = request.getParameter("role_id");
	         System.out.println("role_id"+ role_id );
			String sql;
			sql="select * from v_role_permission where role_id ='"+role_id+"'";

			Statement stm;
			stm = Utils.connectDB(sql);
			ResultSet resultSet = stm.executeQuery(sql);
			JSONStringer stringer = new JSONStringer();
			stringer.object();
			stringer.key("data");
			stringer.array();
			while (resultSet.next()) {
				String id = resultSet.getString("id");
				System.out.println("id      "+id);
				String name = resultSet.getString("name");
				System.out.println("name    "+name);
				String keys = resultSet.getString("keys");
				System.out.println("keys    "+keys);
				String desc = resultSet.getString("desc");
				System.out.println("desc    "+desc);
				String createdby = resultSet.getString("createdby");
				System.out.println("createdby    "+createdby);
				String createdtime = resultSet.getString("createdtime");
				System.out.println("createdtime    "+createdtime);
				String modifyby = resultSet.getString("modifyby");
				System.out.println("modifyby    "+modifyby);
				String modifytime = resultSet.getString("modifytime");
				System.out.println("modifytime    "+modifytime);
				String record_id = resultSet.getString("record_id");
				System.out.println("record_id    "+record_id);
				String role_idBack = resultSet.getString("role_id");
				System.out.println("role_id    "+role_idBack);
				String perms_id1 = resultSet.getString("perms_id1");
				System.out.println("perms_id1    "+perms_id1);
				String perms_name = resultSet.getString("perms_name");
				System.out.println("perms_name    "+perms_name);
				
				//student_id
				System.out.println("utils success");
				stringer.object();
				stringer.key("id");
				stringer.value(id);
				
				stringer.key("name");
				stringer.value(name);
				
				stringer.key("keys");
				stringer.value(keys);
				
				stringer.key("desc");
				stringer.value(desc);
				
				stringer.key("createdby");
				stringer.value(createdby);
				
				stringer.key("createdtime");
				stringer.value(createdtime);
				
				stringer.key("modifyby");
				stringer.value(modifyby);
				
				stringer.key("modifytime");
				stringer.value(modifytime);
				
				stringer.key("record_id");
				stringer.value(record_id);
				
				
				//stringer.key("role_id");
				//stringer.value(role_id);
				
				stringer.key("perms_id1");
				stringer.value(perms_id1);
				
				stringer.key("perms_name");
				stringer.value(perms_name);
				
				
				
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
