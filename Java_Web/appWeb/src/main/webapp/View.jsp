<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>View</title>
</head>
<body>

<!-- <form action="WebChat" method="post" id="indexForm" autocomplete ="off">
	
		User : <input type="text" name="user"> <br/>
		Pass : <input type="password" name="password"> <br/>
		Email : <input type="text" name="email"> <br/>
		BirthDate : <input type="date" name="dateBirth"><br/>
		
		<input type="submit" value="login">
	
	</form> -->
	
	<%String user = (String) request.getParameter("user");
	String password = (String) request.getParameter("password");
	String email = (String) request.getParameter("email");
	String dateBirth = (String) request.getParameter("dateBirth");%>
	
	User:<%=user%></br>
	Password:<%=password%></br>
	Email:<%=email%></br>
	DateBirth:<%=dateBirth%></br>
	
</body>
</html>