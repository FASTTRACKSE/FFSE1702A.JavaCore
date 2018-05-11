<jsp:include page="/templates/header.jsp" /> 
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="namdv.model.*,java.util.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<body>
<div class="container">
		<h3 style="width: 50%; float: left">Users list</h3>
		<p style="width: 50%; float: right; text-align: right">
			<a href="UserController?action=insert"><button type="button" class="btn btn-success">Add New User</button></a>
		</p>
		<table class="table table-striped">
		  <thead>
		    <tr>
		      <th scope="col">#</th>
		      <th scope="col">Username</th>
		      <th scope="col">Email</th>
		      <th scope="col">Sex</th>
		      <th scope="col">Country</th>
		      <th scope="col">Action</th>
		    </tr>
		  </thead>
		  <tbody>
			<%	@SuppressWarnings("unchecked")
			List<User> list = (List<User>) request.getAttribute("users");
			for(User u : list) {
				System.out.println(u.getName());
			};
			%>
			<c:forEach items="${users}" var="u">  
				<tr>
					<td>${u.getId()}</td>
					<td>${u.getName()}</td>
					<td>${u.getEmail()}</td>  
					<td>${u.getSex()}</td>
					<td>${u.getCountry()}</td>
					<th style="color:#377bb5; letter-spacing: 5px;">
				      <a href="UserController?action=edit&userId=${u.getId()}"><i class="fa fa-pencil"></i></a>
				      <a href="UserController?action=delete&userId=${u.getId()}"><i class="fa fa-trash"></i></a>
				    </th>
				</tr>  
			</c:forEach>
		  </tbody>
		</table>
	</div>
</body>
</html>