<jsp:include page="/templates/header.jsp" /> 
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="namdv.model.*,java.util.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<body>
	<jsp:forward page="/UserController?action=listUser" />
</body>
</html>