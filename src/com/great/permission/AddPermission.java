package com.great.permission;

import java.io.IOException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.heima.test.Utils;

import net.sf.json.util.JSONStringer;

/**
 * Servlet implementation class AddPermission
 */
public class AddPermission extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddPermission() {
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
	         
    
	         String perms_id = request.getParameter("perms_id");
	         System.out.println("perms_id"+ perms_id );
	         String perms_name= request.getParameter("perms_name");
	         System.out.println("perms_name"+ perms_name);
	         String perms_httpUrl = request.getParameter("perms_httpUrl");
	         String perms_httpType  = request.getParameter("perms_httpType");
	         String value_isDefault = request.getParameter("value_isDefault");
	         String  perms_isPage = request.getParameter("perms_isPage");
	         String perms_isAction = request.getParameter("perms_isAction");
	         String perms_descript = request.getParameter("perms_descript");
	         String perms_level = request.getParameter("perms_level");
	         String  perms_position = request.getParameter("perms_position");
	         String  perms_path = request.getParameter("perms_path");
	         String   parentId  = request.getParameter("parentId");
	         //String perms_set_time = request.getParameter("perms_set_time");
	         String  perms_set_pers = request.getParameter("perms_set_pers");
	         //String  perms_mdfy_time = request.getParameter("perms_mdfy_time");
	         String   perms_mdfy_pers  = request.getParameter("perms_mdfy_pers");
	         String   perms_isMenu  = request.getParameter("perms_isMenu");
	        
	         
	         //时间处理
	         Date date = new Date();
	         SimpleDateFormat dateFormat= new SimpleDateFormat("yyyy-MM-dd");
	         String perms_set_time = dateFormat.format(date);
	         System.out.println(dateFormat.format(date));
	         String  perms_mdfy_time = dateFormat.format(date);
	         
	         //String perms_set_time = request.getParameter("perms_set_time");
	         
	         //String sql="";
	      // String sql="insert into t_permission1(perms_id,perms_name,perms_httpUrl,perms_httpType,value_isDefault,perms_isPage,perms_isAction,perms_descript,perms_lsevel,perms_position,perms_path,parentId,perms_set_time,perms_set_pers,perms_mdfy_time,perms_mdfy_pers,perms_isMenu) values('"+perms_id+"','"+perms_name+"','"+perms_httpUrl+"','"+perms_httpType+"','"+value_isDefault+"','"+perms_isPage+"','"+perms_isAction+"','"+perms_descript+"','"+perms_level+"','"+perms_position+"','"+perms_path+"','"+parentId+"','"+perms_set_time+"','"+perms_set_pers+"','"+perms_mdfy_time+"','"+perms_mdfy_pers+"','"+perms_isMenu+"')";
	        
	         //String sql="insert into t_permission1(perms_id,perms_name,perms_httpUrl,perms_httpType,value_isDefault,perms_isPage,perms_isAction,perms_descript,perms_level,perms_position,perms_path,parentId,perms_set_time,perms_set_pers,perms_mdfy_time,perms_mdfy_pers,perms_isMenu) values('11','23','67','45','89','123','67u','567','78','6','3ev','897','2018-6-19','45r','2018-6-20','dfg','789')"; 
	        // String sql="insert into t_permission1(perms_id,perms_name,perms_httpUrl,perms_httpType,value_isDefault,perms_isPage,perms_isAction,perms_descript,perms_level,perms_position,perms_path,parentId,perms_set_time,perms_set_pers,perms_mdfy_time,perms_mdfy_pers,perms_isMenu) values('437','wer','345','678','n','n','n','34r','1','3','456i','56','2018-6-30','099','2018-6-29','098','y')"; 
	         String sql="insert into t_permission1(perms_id,perms_name,perms_httpUrl,perms_httpType,value_isDefault,perms_isPage,perms_isAction,perms_descript,perms_level,perms_position,perms_path,parentId,perms_set_time,perms_set_pers,perms_mdfy_time,perms_mdfy_pers,perms_isMenu) values('"+perms_id+"','"+perms_name+"','"+perms_httpUrl+"','"+perms_httpType+"','"+value_isDefault+"','"+perms_isPage+"','"+perms_isAction+"','"+perms_descript+"','"+perms_level+"','"+perms_position+"','"+perms_path+"','"+parentId+"','"+perms_set_time+"','"+perms_set_pers+"','"+perms_mdfy_time+"','"+perms_mdfy_pers+"','"+perms_isMenu+"')"; 
	         
	         Statement stm = Utils.connectDB(sql);
	       
	        boolean isExecuted = stm.execute(sql);
	        System.out.println("isExecuted   "+isExecuted);
	        if(isExecuted==false) {//Java API Statement类的execute的确返回Boolean 型。他指的是否返回ResultSet对象；对插入，更新,来说没有返回对象所以就是false!!!
	        	JSONStringer stringer = Utils.showPermission(stm);
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
