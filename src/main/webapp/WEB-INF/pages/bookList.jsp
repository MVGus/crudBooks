<%--
  Created by IntelliJ IDEA.
  User: mikhailgusar
  Date: 09.02.2018
  Time: 14:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Books List</title>
    <!-- Bootstrap CSS -->
   <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
    <style type="text/css">
        .myrow-container {
            margin: 0 auto;
        }


    </style>
</head>
<body class=".container-fluid">
<div class="container myrow-container">
    <div class="panel panel-success">
        <div class="panel-heading">
            <h3 class="panel-title">
                <div align="left"><b>Books List</b> </div>
                <div align="right"><a href="createBook">Add New Book</a></div>
            </h3>
        </div>
        <div class="panel-body">
            <c:if test="${empty bookList}">
                There are no Books
            </c:if>
            <c:if test="${not empty bookList}">

                <form action="searchBook">
                    <div class="row">
                        <div class="col-md-4">Search Books: <input type='text' name='searchTitle' id='searchTitle'/> </div>
                        <div class="col-md-4"><input class="btn btn-success" type='submit' value='Search'/></div>
                    </div>
                </form>

                <table class="table table-hover table-bordered">
                    <thead style="background-color: lightgray;">
                    <tr>
                        <th>Id</th>
                        <th>Title</th>
                        <th>Author</th>
                        <th>Price</th>
                        <th>Edit</th>
                        <th>Delete</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${bookList}" var="book">
                        <tr>
                            <th><c:out value="${book.id}"/></th>
                            <th><c:out value="${book.title}"/></th>
                            <th><c:out value="${book.author}"/></th>
                            <th><c:out value="${book.price}"/></th>
                            <th><a href="editBook?id=<c:out value='${book.id}'/>">Edit</a></th>
                            <th><a href="deleteBook?id=<c:out value='${book.id}'/>">Delete</a></th>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </c:if>
        </div>
    </div>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>

    <%-- <script src="<c:url value="/resources/js/jquery-2.1.3.js"/>"></script>
    <script src="<c:url value="/resources/js/bootstrap.min.js"/>"></script>
     --%>

</body>
</html>
