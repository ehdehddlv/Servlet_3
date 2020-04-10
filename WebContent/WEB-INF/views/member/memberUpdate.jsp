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
	<form action="./memberUpdate" method="post">
	
	<div class="form-group">
      <label for="Id">ID:</label>
      <input type="text" value="${member.id}" readonly="readonly" class="form-control" id="id" name="id">
    </div>
	
    <div class="form-group">
      <label for="Name">Name:</label>
      <input type="text" value="${member.name}" class="form-control" id="name" placeholder="Enter Name" name="name">
    </div>

    <div class="form-group">
      <label for="Age">Age:</label>
      <input type="text" value="${member.age}" class="form-control" id="age" placeholder="Enter Age" name="age">
    </div> 
       
    <div class="form-group">
      <label for="Phone">Phone:</label>
      <input type="text" value="${member.phone}" class="form-control" id="phone" placeholder="Enter Phone" name="phone">
    </div>  
    
    <div class="form-group">
      <label for="Email">Email:</label>
      <input type="email" value="${member.email}" class="form-control" id="email" placeholder="Enter Email" name="email">
    </div>  
    
              
   
    <button type="submit" class="btn btn-default">Update</button>
    
  </form>
	</div>
</div>

</body>
</html>