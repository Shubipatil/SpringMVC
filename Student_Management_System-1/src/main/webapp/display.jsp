<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
	<!-- isELIgnored = "false" ->  it is an attribute which is used  inside the directive
	 tag in JSP file in order to print/dispaly the data in the desired format
	 
	-> The default value for it is "true", so it will take data  in String format
	=> we nedd to change it to false to take the specific   satic data which  we are 
	reciving inside an object.
	 -->

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body align="center"
	style="background-image: url(https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQQlxvh8CxaZjRytX6m4thsCuAMZTqVAWJCgg&usqp=CAU); background-size: 100vw 100vh;background-repeat: no-repeat;
	background-position:;">

	<!-- In this JSP page we have created a table to represent our data exactly how it 
is saved inside the database.

 -->

<h1 style="color:blue">Student Details</h1>
<hr>
	<table border="2px" align="center" >
		<tr>
		<
			<th style="color:red">Student_Id</th>
			<th style="color:red">Student_Name</th>
			<th style="color:red">Student_Email</th>
			<th style="color:red">Student_Password</th>
			<th style="color:red">EDIT</th>
			<th style="color:red">DELETE</th>
			
		</tr>
		
		
		<!-- must be same which is present in  add Object
we have declare a c:foreach loop in order to iterate through list of data we have recieved
from the displayStudenr()

var="student" -> it is the  reference variable of Student type which will
 be used to invoke all the get() 
 
 ${students} -> it is an attribute  of c:foreach loop which will accepts  the key we have 
 set  inside he displayStuednts() for the (list of Students)
 
 
 NOTE:- we are surrounded  the values   with $() in order to recive the
 data in whatever  state it is present 
 -->
		<c:forEach var="student" items="${students}">
			<tr>
				<td>${student.getId()}</td>
				<td>${student.getName()}</td>
				<td>${student.getEmail()}</td>
				<td>${student.getPassword()}</td>
				
				<!-- Inside this <td> tag we have use an anchor tag<a> tag where 
				the value is EDIT and the href is (updateStudent).So when we click on EDIT 
				it  will go in  search of a @RequestMapping (/updateStudent)


				we have also taking the id of that particular student  object for 
				which request will be given to update as we know ID will be the primary key
				in the database with the help of which we cab fetch that student Object from the  database
				-->
				<td><a href="updateStudent?id=${student.getId()}">EDIT</a></td>
				
				<!-- Inside this <td> tag we have use an anchor tag<a> tag where 
				the value is delete and the href is (deleteStudent).So when we click on delete 
				it  will go in  search of a @RequestMapping (/deleteStudent)


				we have also taking the id of that particular student  object for 
				which request will be given to update as we know (ID) will be the primary key
				in the database with the help of which we can fetch that student Object from the  database
				-->
				<td><a href="deleteStudent?id=${student.getId()}">DELETE</a></td>
			</tr>
		</c:forEach>

	</table>




</body>
</html>