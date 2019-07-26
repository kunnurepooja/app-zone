<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<title>Manage Role</title>
</head>
<body>
<h1>${upadateRow}</h1>
  <h1>manage Role</h1>
   <form action="manageRole.do" method="post">
		Group Name : <select name="groupName">
		<option> ---select--- </option>
			<c:forEach items="${groups}" var="item">
				<option>${item}</option>
			</c:forEach>
			</select><br /><br />
		User Name : <select name="userName">
		<option> ---select--- </option>
			<c:forEach items="${userNames}" var="item">
				<option>${item}</option>
			</c:forEach>
			</select><br /><br />
		Roles : <select name="role">
		<option> ---select--- </option>
			<c:forEach items="${roles}" var="item">
				<option>${item}</option>
			</c:forEach><br /><br />
		</select>
		<br /><br />
		<button type="submit">Update</button>
		<button type="reset">Cancle</button>
   </form>

</body>
</html>