<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: dell
  Date: 1/4/2023
  Time: 10:50 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Student Table</title>
    <title>Bootstrap Example</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body>


    <input placeholder="Nhập tên"><button>Search</button>
    <button data-bs-toggle="modal" data-bs-target="#myModal">Add</button>
    <table class="table">
    <tr>
        <th>Name</th>
        <th>Date of Birth</th>
        <th>Email</th>
        <th>Address</th>
        <th>Action</th>
    </tr>

        <c:forEach var="p" items="${students}">
            <tr>
                <td>${p.name}</td>
                <td>${p.dateOfbirth}</td>
                <td>${p.email}</td>
                <td>${p.address}</td>
                <td>
                    <a type="button" class="btn btn-success" >Edit</a>
                    <a type="button" class="btn btn-danger" href="/delete" ?id="${p.id}" >Delete</a>
                </td>
            </tr>
        </c:forEach>

    </table>
    <div class="modal" id="myModal">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="container mt-3" style="height: 710px">
                    <h2>Đăng ký</h2>
                    <form action="/register" method="post">
                        <div class="mb-3 mt-3">
                            <label>User:</label>
                            <input type="text" class="form-control" placeholder="Enter username" name="username">
                        </div>
                        <div class="mb-3">
                            <label>Password:</label>
                            <input type="password" class="form-control" placeholder="Enter password" name="password">
                        </div>
                        <div class="mb-3">
                            <label>Full name:</label>
                            <input type="text" class="form-control" placeholder="Enter full name" name="fullName">
                        </div>
                        <div class="mb-3">
                            <label>Age:</label>
                            <input type="number" class="form-control" placeholder="Enter age" name="age">
                        </div>
                        <div class="mb-3">
                            <label>Number Phone:</label>
                            <input type="text" class="form-control" placeholder="Enter number" name="phone">
                        </div>
                        <div class="mb-3">
                            <label>Email:</label>
                            <input type="text" class="form-control" placeholder="Enter email" name="email">
                        </div>
                        <div class="form-check mb-3">
                            <label class="form-check-label">
                                <input class="form-check-input" type="checkbox" name="remember"> Remember me
                            </label>
                        </div>
                        <button type="submit" class="btn btn-primary" style="text-align: right">Đăng ký</button>
                        <br>
                    </form>
                </div>
            </div>
        </div>
    </div>
    </body>
</html>
