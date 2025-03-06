<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
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
h2{
width: 90%;
background-color: goldenrod;
height:30px;
}
a{
color:blue;
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
</style>
</head>
<body>
<div align="center">
<h1>Books at Java Learning Center</h1>
<h2 align="right"> ${FROM} to ${TO} of ${TotalBooks} </h2>
<table class="mytable">
<tr>
<th>Book ID</th>
<th>Book Name</th>
<th>Author</th>
<th>Price</th>
<th>Category</th>
<th>Publications </th>
<th colspan="2" align="center">
<form:form action="addEditBookForm">
<input type="hidden" name="bookId" value="0"/>
<input type="submit" value="Add New Book" />
</form:form> </th>
</tr>
<c:forEach var="mybook" items="${MyBooksList}">
<tr>
<td> <a href="viewBook?bookId=${mybook.bid }"> ${mybook.bid } </a> </td>
<td>${mybook.bname }</td>
<td>${mybook.author }</td>
<td>${mybook.price }</td>
<td>${mybook.category }</td>
<td>${mybook.pub }</td>
<td>
<form:form action="addEditBookForm">
<input type="hidden" name="bookId" value="${mybook.bid }"/>
<input type="submit" value=" Edit " />
</form:form>
</td>
<td>
<form:form action="deleteBook">
<input type="hidden" name="bookId" value="${mybook.bid }"/>
<input type="submit" value="Delete" />
</form:form>
</td>
</tr>
</c:forEach>
</table>
<h2>
<c:if test="${ShowPrevious eq 'TRUE' }">
<a href="previousBooks">Previous </a> </c:if>
&nbsp; &nbsp;
<c:if test="${ShowNext eq 'TRUE' }">
<a href="nextBooks">Next </a> </c:if>
</h2>
</div>
</body>
</html>