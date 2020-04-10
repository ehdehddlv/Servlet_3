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
	<form action="./noticeAdd" method="post">
	    <div class="form-group">
	      <label for="No">No:</label>
	      <input type="text" class="form-control" placeholder="Enter No" id="no" name="no">
	    </div>
	
	    <div class="form-group">
	      <label for="Title">Title:</label>
	      <input type="text" class="form-control" id="title" placeholder="Enter title" name="title">
	    </div> 
	       
	    <div class="form-group">
	      <label for="Id">Writer:</label>
	      <input type="text" value="admin" readonly="readonly" class="form-control" id="id" name="id">
	    </div>  
	    
	    <div class="form-group">
	      <label for="Writedate">WriteDate:</label>
	      <input type="datetime" class="form-control" id="writedate" placeholder="Enter writedate" name="writedate">
	    </div>  
	    
	    <div class="form-group">
	      <label for="Views">Views:</label>
	      <input type="text" class="form-control" id="views" placeholder="Enter views" name="views">
	    </div>          
	 
	    <button type="submit" class="btn btn-default">Add</button>
	    
  </form>
	</div>
</div>
	
	<h1>Add notice</h1>
</body>
</html>