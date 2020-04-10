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
	
	<div class="container">
		<div class="row">
			<h1>Point List Page</h1>
			<table class="table table-hover">
				<tr>
					<td>번호</td>
					<td>이름</td>
					<td>평균</td>
				</tr>
								<!-- requestScope 생략가능 -->
				<c:forEach items="${requestScope.list}" var="dto">
					<tr>
						<td>${dto.num}</td>
						<td><a href="./pointSelect?num=${dto.num}">${dto.name}</a></td>
						<td>${dto.avg}</td>
					</tr>
				</c:forEach> 
			
			</table> 
			
			<a href="./pointAdd" class="btn btn-primary">Point Add</a>
			
		</div>
	</div>
	
</body>
</html>