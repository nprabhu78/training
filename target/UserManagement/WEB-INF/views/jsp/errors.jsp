<%@ page session="false"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">


<body>

	<div class="container">

		<h1>Error Page</h1>

		<p>${exception.message}</p>

	</div>

</body>
</html>