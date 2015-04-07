<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <body>
    <form action="login.action" method="post">
    	用户名：<input type="text" name="user.username" size="25"><br>
    	密&nbsp;&nbsp;码：<input type="password" name="user.password" size="25"><br>
    	<input type="submit" value="登陆" >
    	<input type="button" value="注册" onClick="window.location='register.jsp'">
    </form>
  </body>
</html>

