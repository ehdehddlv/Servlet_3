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
			
			<table class="table table-hover">
				<tr class="danger">
					<td>ID</td>
					<td>Name</td>
					<td>Age</td>
					<td>Phone</td>
					<td>Email</td>
				</tr>
								
				<tr class="info">
					<td>${sessionScope.member.id}</td>
					<td>${member.name}</td>
					<td>${member.age}</td>
					<td>${member.phone}</td>
					<td>${member.email}</td>
				</tr>
			</table>
			
			<button class="btn btn-primary" id="upd">Update</button>
			<button class="btn btn-danger" id="del">Delete</button>
			
		</div>
	</div>

	<script type="text/javascript">
		//js document.getElementById
		//js document.querySelector
		//jquery $(선택자)
	
		$("#upd").on("click", function() { 
			location.href="./memberUpdate?id=${member.id}";
		});
		
		$("#del").click(function() {
			var result = confirm("정말 탈퇴 하시겠습니까?");
			if(result){
				alert("회원정보가 삭제되었습니다.");
				location.href="./memberDelete";
				//location.href="./memberDelete?id=${member.id}";
			}
		});
		
	
	</script>

	

	
</body>
</html>