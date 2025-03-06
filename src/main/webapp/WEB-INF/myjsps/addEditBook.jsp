<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html> <head>
<title>Welcome to CC!</title>
<style>
table,td,th{
border:0px rgb(180, 151, 151) solid;
border-collapse: collapse;
font-size: 25px;
}
.mytable{
width: 90%;
}
tr:nth-child(odd){
background-color: azure;
}
tr:nth-child(even){
background-color:lavender;;
}
input[type=submit]{
color: blue;
font-family: verdana;
font-size: 20px;
font-weight:bold;
padding: 5px 5px;
margin: 5px 5px;
}
input{
color: blue;
font-family: verdana;
font-size: 20px;
font-weight:bold;
padding: 5px 5px;
margin: 5px 5px;
}
</style> 
</head>
<body>
<div align="center">
<form:form action="saveUpdateBook" method="post" modelAttribute="mybook">
<table>
<tr>
<c:if test="${OpType eq 'ADD' }">
<td align="center" colspan="3">Add New Book</td>
</c:if>
<c:if test="${OpType eq 'UPDATE' }">
<td align="center" colspan="3">Update Book</td>
</c:if>
</tr>
<tr>
<td> Book Name</td>
<td><form:input path="bname" /></td>
<td><font color=red size=4><form:errors path="bname" /></font></td>
</tr>
<tr>
<td>Author</td>
<td><form:input path="author" /></td>
<td><font color=red size=4><form:errors path="author" /></font></td>
</tr>
<tr>
<td>Price</td>
<td><form:input path="price" /></td>
<td><font color=red size=4><form:errors path="price" /></font></td>
</tr>
<tr>
<td>Category</td>
<td><form:input path="category" /></td>
<td><font color=red size=4><form:errors path="category" /></font></td>
</tr>
<tr>
<td>Publications</td>
<td><form:input path="pub" /></td>
<td><font color=red size=4><form:errors path="pub" /></font></td>
</tr>
<tr>
<td align="center" colspan="3">
<input type="hidden" name="OpType" value="${OpType}"/>
<c:if test="${OpType eq 'ADD' }">
<input type="submit" value="Add New Book" />
</c:if>
<c:if test="${OpType eq 'UPDATE' }">
<input type="submit" value="Update Book" />
<form:hidden path="bid" />
</c:if>
</td>
</tr> </table>
</form:form>
</div> 
</body> 
</html>