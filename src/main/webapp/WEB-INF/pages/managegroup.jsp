<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>

<title>Manage Group</title>
</head>
<style>
.navBar{
	color:white;
	margin-left:70%
}
</style>
<body>
<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
 <h1 style="color:white">App Zone</h1>
 <h1 class="navBar">Xworkz</h1> 
 
</nav>
	


	<h1>Manage Group here</h1>
	<h1>${sendMessage}</h1>
	<form action="manageGroup.do" method="post">
		Group Name : <select name="groupName">
			<c:forEach items="${groupName}" var="item">
				<option>${item}</option>
			</c:forEach>
		</select><br /> <br /> email : <input type="email" name="emailId"><br />
		<br />
		<button type="submit">Invite</button>
		<button type="reset">Cancle</button>
		</form>

	<%-- </form><h1>${successOrFailure}</h1>
	   <form action="manageGroup.do" method="post">
	<div class="login">
	<br/>
  <div class="login-header">
    <h1>Create Group</h1>
  </div>
  <div class="login-form">

    <input type="text" placeholder="Enter the Group Name " required/>
    <br/>
    <br/>
    
    <button type="submit"  class="login-button"/>create</button>&bnsp;
    <button type="reset" value="cancle" class="login-button"/>cancle</button>
    <br>
  
  </div>
</div>
	 --%>


</body>
</html>