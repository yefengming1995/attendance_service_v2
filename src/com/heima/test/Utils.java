package com.heima.test;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.PreparedStatement;

import net.sf.json.util.JSONStringer;

public class Utils {
	
	public static Statement connectDB(String sql) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");
		java.sql.Connection connection =  DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/database","root", "admin");
		 System.out.println("connection2 success");
		
		Statement ptmt = connection.createStatement();
		//ptmt.execute();
		return ptmt;
	}
	public static JSONStringer show(Statement ptmt) throws SQLException {
		String sql;
		sql="select * from t_user";
		ResultSet resultSet = ptmt.executeQuery(sql);
		JSONStringer stringer = new JSONStringer();
		stringer.object();
		stringer.key("data");
		stringer.array();
		
			while (resultSet.next()) {
					String name = resultSet.getString("name");
					System.out.println("name      "+name);
					String password = resultSet.getString("password");
					System.out.println("password    "+password);
					String role = resultSet.getString("role");
					System.out.println("role    "+role);
					
					System.out.println("utils success");
					stringer.object();
					stringer.key("name");
					stringer.value(name);
					
					stringer.key("password");
					stringer.value(password);
					
					stringer.key("role");
					stringer.value(role);
					
					
					stringer.endObject();
					//response.reset();
			}
			stringer.endArray();
			stringer.endObject();
		return stringer;
	}
	public static JSONStringer showStudent(Statement ptmt) throws SQLException {
		String sql;
		sql="select * from t_student";
		ResultSet resultSet = ptmt.executeQuery(sql);
		JSONStringer stringer = new JSONStringer();
		stringer.object();
		stringer.key("data");
		stringer.array();
		
			while (resultSet.next()) {
					String id = resultSet.getString("id");
					System.out.println("id      "+id);
					String entranceYear = resultSet.getString("entranceYear");
					System.out.println("entranceYear    "+entranceYear);
					String department = resultSet.getString("department");
					System.out.println("department    "+department);
					String major = resultSet.getString("major");
					System.out.println("major    "+major);
					String name = resultSet.getString("name");
					System.out.println("name    "+name);
					String sex = resultSet.getString("sex");
					System.out.println("sex    "+sex);
					System.out.println("utils success");
					stringer.object();
					stringer.key("id");
					stringer.value(id);
					
					stringer.key("entranceYear");
					stringer.value(entranceYear);
					
					stringer.key("department");
					stringer.value(department);
					
					stringer.key("major");
					stringer.value(major);
					
					stringer.key("department");
					stringer.value(department);
					stringer.key("name");
					stringer.value(name);
					stringer.key("sex");
					stringer.value(sex);
					stringer.endObject();
					//response.reset();
			}
			stringer.endArray();
			stringer.endObject();
		return stringer;
	}

}
