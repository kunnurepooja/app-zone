<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Create Group</title>
</head>
<body>
<h1>${successOrFailure}</h1>
<form action="createGroup.do" method="post">
Group name : <input type="text" name="groupName" placeholder="Enter the group name"><br/><br/>
<button type="submit">Create Group</button>
<button type="reset">cancle</button>
</form>
</body>
</html>