<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
<title>Create Group</title>
</head>
<style>
.navBar{
	color:white;
	margin-left:70%
}

.login {
  margin:0 auto;
  max-width:500px;
  margin-top:7%;
  background-color:black
}
.login-header {
  color:#fff;
  text-align:center;
  font-size:300%;
}
/* .login-header h1 {
   text-shadow: 0px 5px 15px #000; */
}
.login-form {
  border:.5px solid #fff;
  background:#4facff;
  border-radius:10px;
  box-shadow:0px 0px 10px #000;
}
.login-form h3 {
  text-align:left;
  margin-left:40px;
  color:#fff;
}
.login-form {
  box-sizing:border-box;
  padding-top:15px;
	padding-bottom:10%;
  margin:5% auto;
  text-align:center;
}
.login input[type="text"],
.login input[type="password"] {
  max-width:400px;
	width: 100%;
  line-height:3em;
  font-family: 'Ubuntu', sans-serif;
  margin:1em 2em;
  border-radius:5px;
  border:2px solid #f2f2f2;
  outline:none;
  padding-left:10px;
}
.login-form button[type="submit"],
.login-form button[type="reset"]{
  height:30px;
  width:100px;
  background:#fff;
  border:1px solid #f2f2f2;
  border-radius:20px;
  color: slategrey;
  text-transform:uppercase;
  font-family: 'Ubuntu', sans-serif;
  cursor:pointer;
  color:black
}




/*Media Querie*/
@media only screen and (min-width : 150px) and (max-width : 530px){
  .login-form h3 {
    text-align:center;
    margin:0;
  }
  
  .login-button {
    margin-bottom:10px;
  }
}
</style>
<body>
 <nav class="navbar navbar-expand-sm bg-dark navbar-dark">
 <h1 style="color:white">App Zone</h1>
 <h1 class="navBar">Xworkz</h1> 
 <h1 class="navBar">Welcome ${sessionScope.user}</h1>
</nav>
	<%-- <h1>${successOrFailure}</h1>
	<form action="createGroup.do" method="post">
		Group name : <input type="text" name="groupName"
			placeholder="Enter the group name" required><br />
		<br />
		<button type="submit">Create Group</button>
		<button type="reset">cancle</button>
	</form>  --%>
	 <h1>${successOrFailure}</h1>
	<form action="createGroup.do" method="post">
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
</form>
</body>
</html>