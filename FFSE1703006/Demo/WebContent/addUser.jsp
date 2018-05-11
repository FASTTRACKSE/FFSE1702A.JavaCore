<jsp:include page="/templates/header.jsp" /> 
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="namdv.model.UserModel,namdv.model.*,java.util.*"%>
<body>
	<div class="container">
		<h2>Create New User</h2>
		<hr>
		<h6>Please fill this form and submit to add a new user record to the database.</h6>
		<%
		if (request.getParameter("submit") != null) {
			String username=request.getParameter("username");
			String password=request.getParameter("password");
			String email=request.getParameter("email");
			String sex=request.getParameter("sex");
			String country=request.getParameter("country");
			User u = new User(null, username, password, email, sex, country);
			if (!username.isEmpty() && UserModel.add(u) > 0) {
				response.sendRedirect("index.jsp");
				System.out.println("Thêm thành công!");
			} else {
				out.print("<p style = 'color: red'>Sorry, an error occurred!</p>");
				System.err.println("Thêm thất bại!");
			}
		}
		%>
		<form action="addUser.jsp" method='POST'>
		  <div class="form-group">
		    <h5>Username</h5>
		    <input type="text" class="form-control" name="username" required>
		  </div>
		  <div class="form-group">
		    <h5>Password</h5>
		    <input type="password" class="form-control" name="password" required>
		  </div>
		  <div class="form-group">
		    <h5>Email</h5>
		    <input type="email" class="form-control" name="email" required>
		  </div>
		  <div class="form-group">
		    <h5>Sex</h5>
		    <div class="custom-control custom-radio custom-control-inline">
	          <input class="form-check-input" type="radio" name="sex" value="Male" required>
	          <label class="form-check-label">Male</label>
	        </div>
	        <div class="custom-control custom-radio custom-control-inline">
	          <input class="form-check-input" type="radio" name="sex" value="Female" required>
	          <label class="form-check-label">Female</label>
	          <div class="invalid-feedback">Please choose a sex.</div>
	        </div>
		  </div>
		  <div class="form-group">
		    <h5>Country</h5>
		    <select class="custom-select mr-sm-2" name="country" required>
		       <option value="">Choose...</option>
		       <option value="Vietnam">Vietnam</option>
		       <option value="USA">USA</option>
		       <option value="China">China</option>
		    </select>
		    <div class="invalid-feedback">Please choose a country.</div>
		  </div>
		  <button type="submit" name="submit" class="btn btn-primary">Submit</button>
		  <a href="index.jsp"><button type="button" class="btn btn-outline-secondary">Cancel</button></a>
		</form>
	</div>
</body>
</html>