<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  </head>
  
  <body>
    This is my JSP page. <br>
    
    <form action="Add">
    
    <br>使用get方式提交数据到服务器<br>
    <br>ID<br><input type="text" name="id">
    <br>用户名<br><input type="text" name="username">
    <br>密码<br><input type="password" name="password">
    <br>角色<br><input type="text" name="role">
    <br>
    <input type="submit">
    </form>
    
    
    <form action="Add" method="post">
    <br>使用post方式提交数据到服务器<br>
    <br>ID<br><input type="text" name="id">
    <br>用户名<br><input type="text" name="username">
    <br>密码<br><input type="password" name="password">
    <br>角色<br><input type="text" name="role">
    <br>
    <input type="submit">
    </form>
    
     <form action="Delete">
    
    <br>使用get方式提交数据到服务器<br>
    <br>用户名<br><input type="text" name="username">
    <br>
    <input type="submit">
    </form>
    
    
    <form action="Delete" method="post">
    <br>使用post方式提交数据到服务器<br>
    <br>用户名<br><input type="text" name="username">
    <br>
    <input type="submit">
    </form>
    
    
    <form action="Update">
    
    <br>使用get方式提交数据到服务器<br>
     <br>ID<br><input type="text" name="id">
    <br>用户名<br><input type="text" name="username">
    <br>电话<br><input type="text" name="phone">
    <br>
    <input type="submit">
    </form>
    
    
    <form action="Update" method="post">
     <br>ID<br><input type="text" name="id">
    <br>用户名<br><input type="text" name="username">
    <br>电话<br><input type="text" name="phone">
    <br>
    <input type="submit">
    </form>
    
    <form action="LoginServlet">
    
    <br>使用get方式提交数据到服务器<br>
    <br>用户名<br><input type="text" name="username">
    <br>
    <input type="submit">
    </form>
    
    
    <form action="LoginServlet" method="post">
    <br>使用post方式提交数据到服务器<br>
    <br>用户名<br><input type="text" name="username">
    <br>
    <input type="submit">
    </form>
    
    
  </body>
</html>
