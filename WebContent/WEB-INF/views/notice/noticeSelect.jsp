<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<c:import url="../template/boot.jsp"></c:import>

</head>
<body>

	<c:import url="../template/header.jsp"></c:import>

	

	<h1>notice select</h1>
	
	<button class="btn btn-primary" id="upd">Update</button>
	<button class="btn btn-danger" id="del">Delete</button>
	
	<script type="text/javascript">
		$("#upd").click(function() {
			location.href="./noticeMod";
		});
	</script>
	
</body>
</html>