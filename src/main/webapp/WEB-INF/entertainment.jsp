<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Irina.Petrovskaya
  Date: 6/17/2016
  Time: 5:32 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>entertainment</title>
</head>
<body>
principal: ${principal_name}
<p/>
${entertainment_attr1}
<p>
    All Books:
    <c:forEach items="${allBooks}" var="book">
<p>${book.author} ${book.name}</p>
</c:forEach>
</p>
Child Books:
<c:forEach items="${childBooks}" var="book">

</c:forEach>
<p>
    Child Movies:
    <c:forEach items="${childMovies}" var="film">
<p>${film.name}</p>
</c:forEach>
</p>
<p>
    X Movies:
    <c:forEach items="${x_films}" var="film">
        <p>${film.name}</p>
    </c:forEach>
</p>
X Books:
<c:forEach items="${x_books}" var="book">
    <p> ${book.name}  ${book.author} </p>
</c:forEach>
<p>
My Books:
<c:forEach items="${my_books}" var="book">
    <p> ${book.name}  ${book.author} </p>
</c:forEach>
<p>
</body>
</html>
