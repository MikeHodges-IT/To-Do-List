<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>To-do List</title>
<link rel="stylesheet" href="style/styles.css">
<script type="text/javascript" src="javaScript/javaScript.js"></script> 
</head>
<body>
  <c:if test="${todoItem != null}">
   <form name="todoItemForm" action="update" onsubmit="return validateForm()" method="post">
   <input type="hidden" name="itemId" value="<c:out value='${todoItem.itemId}' />" />
   </c:if>
   <c:if test="${todoItem == null}">
   <form name="todoItemForm" action="insert" onsubmit="return validateForm()" method="post">
   </c:if>
		<table>
			<tbody>
				<tr class="BgTrWhite">
					<td colspan="4"><img id="todoImage" src="images/todo-200-100.png"
						alt=" TO DO ! " width="200" height="100"></td>
				</tr>
				<tr> 
			    <td colspan="2" ><a href="list">View List</a></td>
			    <td colspan="2">
			    <c:if test="${todoItem != null}">
                 Edit To Do Item
                </c:if>
                <c:if test="${todoItem == null}">
                 Add To Do Item
                </c:if>
			    </td> 
			    </tr>
				<tr> 
				<td colspan="2"> <p id = "itemTitleError"> &nbsp; </p></td><td colspan="2"></td>
				</tr>
				
				<tr>
					<td><p id = "title">Title:</p></td>
					<td>                 <input type="text" name="itemTitle" size="55"
                   value="<c:out value='${todoItem.itemTitle}' />"
                  />
					</td><td colspan="2"></td>
				</tr>
				
				<tr>
					<td>Details:</td>
					<td><textarea rows="3" cols="65" name="itemDetails" value=""><c:out value='${todoItem.itemDetails}' /></textarea>
					</td><td colspan="2"></td>
				</tr>
				<tr>
					<td>Complete:</td>
					<td>
					<input type="checkbox" name="itemComplete" value="complete" 
						${todoItem != null && todoItem.itemComplete != 0 ? "checked":""} 
						 />
					</td>
					<td colspan="2"></td>
				</tr>
				<tr>
					<td></td>
					<td><input type="reset" value="Reset" name="clear" onclick="clearErrorMsg(this)" /> <input
						type="Submit" value="Submit" name="submit" /></td><td colspan="2"></td>
				</tr>
			</tbody>
		</table>
	</form>
</body>
</html>