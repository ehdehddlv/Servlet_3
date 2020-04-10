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
			<h1>noticeList</h1>
			<table class="table table-hover">
				<tr>
					<td>NO</td>
					<td>Title</td>
					<td>Writer</td>
					<td>WriteDate</td>
					<td>Views</td>
				</tr>
								<!-- requestScope 생략가능 -->
				<c:forEach items="${requestScope.nolist}" var="nolist">
					<tr>
						<td>${nolist.no}</td>
						<td><a href="./noticeSelect">${nolist.title}</a> </td>
						<td>${nolist.id}</td>
						<td>${nolist.writedate}</td>
						<td>${nolist.views}</td>
					</tr>
				</c:forEach> 
			
			</table> 
			
			<c:if test="${member.id eq 'admin'}">
			<a href="./noticeAdd?" class="btn btn-primary" id="noadd">Notice Add</a>
			</c:if>
			
		</div>
	</div>


	
</body>
</html>