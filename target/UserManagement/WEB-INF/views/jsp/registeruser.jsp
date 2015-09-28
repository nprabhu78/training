<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>User Registration Form</title>
		<link href="<c:url value='/resources/css/bootstrap.css' />" rel="stylesheet"></link>
		<link href="<c:url value='/resources/css/app.css' />" rel="stylesheet"></link>
</head>
<body>
	<div class="generic-container">
    <div class="well lead">User Registration Form</div>
  
	    <sf:form method="POST" modelAttribute="user" class="form-horizontal">
	        <sf:input type="hidden" path="id" id="id"/>
	        <div class="row">
            	<div class="form-group col-md-12">
	                <label class="col-md-3 control-lable" for="fname">First Name: </label>
	                <div class="col-md-7">
	                	<sf:input path="firstName" id="fname" class="form-control input-sm"/>
	               		<div class="has-error">
	               			<sf:errors path="firstName" class="help-inline"/>
	               		</div>
	               	</div>
	            </div>
	        </div>
	
	        <div class="row">
            	<div class="form-group col-md-12">
	                <label class="col-md-3 control-lable" for="lname">Last Name: </label>
	                <div class="col-md-7">
	                	<sf:input path="lastName" id="lname" class="form-control input-sm"/>
	               		<div class="has-error">
	               			<sf:errors path="lastName" class="help-inline"/>
	               		</div>
	               	</div>
	            </div>
	        </div>
	
	        <div class="row">
            	<div class="form-group col-md-12">
	                <label class="col-md-3 control-lable" for="logID">User ID: </label>
	                <div class="col-md-7">
	                	<sf:input path="loginId" id="logID" class="form-control input-sm"/>
	                	<div class="has-error">
	                		<c:if test="{userExists}"></c:if>
	                		<sf:errors path="loginId" class="help-inline"/>
	               		</div>
	               	</div>
	            </div>
	        </div>
	
	        <div class="row">
            	<div class="form-group col-md-12">
	                <label class="col-md-3 control-lable" for="pwd">Password: </label>
	                <div class="col-md-7">
	                	<sf:password path="password" id="pwd" class="form-control input-sm"/>
	                	<div class="has-error">
	               			<sf:errors path="password" class="help-inline"/>
	               		</div>
	               	</div>
	            </div>
	        </div>
	
<%--		<div class="row">
            	<div class="form-group col-md-12">
	                <label class="col-md-3 control-lable" for="confpwd">Confirm Password: </label>
	                <div class="col-md-7">
	                	<sf:password path="confirmPassword" id="confpwd" class="form-control input-sm"/>
	                	<div class="has-error">
	               			<sf:errors path="confirmPassword" class="help-inline"/>
	               		</div>
	               	</div>
	            </div>
	        </div>	--%>
	        
	        <div class="row">
            	<div class="form-group col-md-12">
	                <label class="col-md-3 control-lable" for="addr">Address: </label>
	                <div class="col-md-7">
	                	<sf:textarea path="address" rows="5" id="addr" class="form-control input-sm"/>
	                	<div class="has-error">
	               			<sf:errors path="address" class="help-inline"/>
	               		</div>
	               	</div>
	            </div>
	        </div>
	            
	        <div class="row">
            	<div class="form-group col-md-12">
	                <label class="col-md-3 control-lable" for="email">Email: </label>
	                <div class="col-md-7">
	                	<sf:input path="email" id="email" class="form-control input-sm"/>
	                	<div class="has-error">
	               			<sf:errors path="email" class="help-inline"/>
	               		</div>
	               	</div>
	            </div>
	        </div>
	
	        <div class="row">
            	<div class="form-group col-md-12">
	                <label class="col-md-3 control-lable" for="ph">Phone: </label>
	                <div class="col-md-7">
	                	<sf:input path="phone" id="ph" class="form-control input-sm"/>
	                	<div class="has-error">
	               			<sf:errors path="phone" class="help-inline"/>
	               		</div>
	               	</div>
	            </div>
	        </div>            
	            
	        <div class="row">
            	<div class="form-group col-md-12">
	                <label class="col-md-3 control-lable" for="doj">Joining Date: </label>
	                <div class="col-md-7">
	                	<sf:input path="joinDate" id="doj" class="form-control input-sm"/>
	                	<div class="has-error">
	          				<sf:errors path="joinDate" class="help-inline"/>
	               		</div>
	               	</div>
	            </div>
	        </div>
	
	     
        <div class="row">
            <div class="form-actions floatLeft">
	            <c:choose>
	                <c:when test="${edit}">
	                    <input type="submit" value="Update" class="btn btn-primary btn-sm"/> or <a href="<c:url value='/list' />">Cancel</a>
	                </c:when>
	                <c:otherwise>
	                    <input type="submit" value="Register" class="btn btn-primary btn-sm"/> or <a href="<c:url value='/list' />">Cancel</a>
	                </c:otherwise>
	            </c:choose>
			</div>
		</div>

		</sf:form>
	</div>	

</body>
</html>