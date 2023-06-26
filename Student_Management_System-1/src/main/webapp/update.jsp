<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
button {
	background-color: black;
	color: white;
	border-radius: 30px;
}
</style>
</head>
<body align="center"
	style="background-image: url(https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcR3GorApnPGD1dt2PN4Ltpwrxigj-5CKQSxUA&usqp=CAU); background-size: 100vw 100vh; background-repeat: no-repeat; background-position:;">

	<!-- After upadate Student() method is executed in the controller class this "upadate.jsp" page is rendered
on the browser
and  a student object which is found  from the database on the "id" is coming here.

 modelAttribute -> Here we have taken the key "existingStudent " we had set
 for the object that was found.
 
 All the data for the variable which is already existing  inside the database will be displayed on the browser
 inside "input" tags, where e can change the data we want to update and click on the "update" button.
 
 
 After we click on update  then it will go in search of a @RequestMapping (/saveUpdateStudent) as the action  is given for that
 -->
	<h1>Update Student Details</h1>
	<hr>
	<f:form action="saveUpdatedStudent" modelAttribute="existingStudent">

		<!--read only : You cannot change /alter the value present here int this input tag  -->
		<f:input path="id" readonly="true" />
		<br>
		<f:input path="name" />
		<br>
		<f:input path="email" />
		<br>
		<f:input path="password" />
		<br>
		<br>
		<!-- <input type="submit" value="update" style="color:green">
 -->
		<button>Update</button>
	</f:form>

</body>
</html>