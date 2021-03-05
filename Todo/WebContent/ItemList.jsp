<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>	
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>To-do List</title>
<link rel="stylesheet" href="style/styles.css">
</head>
<body>
   	<table>
		<tbody>
			<tr class="BgTrWhite">
				<td colspan="4"><img id="todoImage" src="images/todo-200-100.png"
					alt=" TO DO ! " width="200" height="100"></td>
			</tr>
			<tr class = "HeadTxt"> 
			 <td colspan="2"><a href="new">Add New Item</a></td><td colspan="2"> </td> 
			</tr>
			<tr class = "HeadTxt"> 
				<th >To Do Item Name</th><th>Details</th><th>Completed</th><th>Action</th> 
			</tr>
		<c:forEach items="${todolist}" var="tdl">
			<tr >
				<td class = "tdList">${tdl.itemTitle}</td>
				<td class = "tdList">${tdl.itemDetails}</td>
				<td class = "tdList">
				${
				 tdl.itemComplete == 1 ?
				 "<img id='todoImage' src='images/check-mark-green-37-30.png'	alt=' Completed ! ' width='37' height='30'>"
				 : 
				 "<img id='todoImage' src='images/red-x-transparent-30-30.png'	alt=' Not Completed ! ' width='30' height='30'>"
				 }
				 </td>
				<td class = "tdList" >
				   <div class = "botton">
				   <a href="edit?id=<c:out value='${tdl.itemId}' />"> Edit </a>
				   </div>
				   <div class = "botton">
				   <a href="delete?id=<c:out value='${tdl.itemId}'/>"> Delete </a>
					</div>
				</td>
			</tr>
		</c:forEach>
		</tbody>
	</table>

</body>	

</body>
</html>