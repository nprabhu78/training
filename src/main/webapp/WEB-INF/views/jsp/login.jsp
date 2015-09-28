<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
	<head>
        <meta http-equiv="Content-Type" content="text/html">
        <title>Login</title>
    </head>
	
<body>
	<sf:form method="post" action="login" modelAttribute="loginBean">
		<sf:label path="userName">Enter your user-name</sf:label>
        <sf:input id="userName" name="username" path="userName" /><br>
		<sf:label path="password">Please enter your password</sf:label>
		<sf:password id="password" name="password" path="password" /><br>
        <input type="submit" value="Submit" />
	</sf:form>
	<a href="<c:url value='/new' />">New User..? - Register</a>
</body>
</html>
