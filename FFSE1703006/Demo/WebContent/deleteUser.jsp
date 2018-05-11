<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Delete</title>
</head>
<body>
	<%@page import="namdv.model.UserModel,namdv.model.*,java.util.*"%>  
	<%  
		String id=request.getParameter("id");
		if (UserModel.delete(id) > 0) {
			System.out.println("Xóa thành công!");
		} else { 
			System.err.println("Xóa thất bại!");
		}
		response.sendRedirect("index.jsp");
	%>
</body>
</html>