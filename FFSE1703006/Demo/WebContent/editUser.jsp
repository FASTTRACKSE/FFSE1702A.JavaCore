<jsp:include page="/templates/header.jsp" /> 
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="namdv.model.UserModel,namdv.model.*,java.util.*"%>
<body>
	<div class="container">
		<h2>Update User Info</h2>
		<hr>
		<h6>Please edit the input values and submit to update the record.</h6>
		<%
		String id=request.getParameter("id");
		User u = UserModel.getRecordById(id);
		if (request.getParameter("submit") != null) {
			String username=request.getParameter("username");
			String password=request.getParameter("password");
			String email=request.getParameter("email");
			String sex=request.getParameter("sex");
			String country=request.getParameter("country");
			u = new User(id, username, password, email, sex, country);
			if (!username.isEmpty() && UserModel.update(u) > 0) {
				response.sendRedirect("index.jsp");
				System.out.println("Sửa thành công!");
			} else {
				out.print("<p style = 'color: red'>Sorry, an error occurred!</p>");
				System.err.println("Sửa thất bại!");
			}
		}
		%>
		<form action="" method='POST'>
		  <div class="form-group">
		    <h5>Username</h5>
		    <input type="text" class="form-control" name="username" value="<%=u.getName() %>" required>
		  </div>
		  <div class="form-group">
		    <h5>Password</h5>
		    <input type="password" class="form-control" name="password" value="<%=u.getPassword() %>" required>
		  </div>
		  <div class="form-group">
		    <h5>Email</h5>
		    <input type="email" class="form-control" name="email" value="<%=u.getEmail() %>" required>
		  </div>
		  <div class="form-group">
		    <h5>Sex</h5>
		    <div class="custom-control custom-radio custom-control-inline">
	          <input class="form-check-input" type="radio" name="sex" value="Male" <% if(u.getSex().equals("Male")) { out.print("checked"); } %> required>
	          <label class="form-check-label">Male</label>
	        </div>
	        <div class="custom-control custom-radio custom-control-inline">
	          <input class="form-check-input" type="radio" name="sex" value="Female" <% if(u.getSex().equals("Female")) { out.print("checked"); } %> required>
	          <label class="form-check-label">Female</label>
	        </div>
		  </div>
		  <div class="form-group">
		    <h5>Country</h5>
		    <select class="custom-select mr-sm-2" name="country" required>
		       <option value="">Choose...</option>
		       <option value="Vietnam" <% if(u.getCountry().equals("Vietnam")) { out.print("selected"); } %>>Vietnam</option>
		       <option value="USA" <% if(u.getCountry().equals("USA")) { out.print("selected"); } %>>USA</option>
		       <option value="China" <% if(u.getCountry().equals("China")) { out.print("selected"); } %>>China</option>
		    </select>
		  </div>
		  <button type="submit" name="submit" class="btn btn-primary">Submit</button>
		  <a href="index.jsp"><button type="button" class="btn btn-outline-secondary">Cancel</button></a>
		</form>
	</div>
</body>
</html>