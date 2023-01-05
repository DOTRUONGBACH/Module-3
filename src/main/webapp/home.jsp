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

<form action="/search" method="get">
    <input  placeholder="Nhập tên"  name = "search">
    <button type="submit" >Search</button>
    </form>
    <button data-toggle="modal" data-target="#myModal">Add</button>
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
                    <a type="button" class="btn btn-danger" href=/delete?id=${p.id} >Delete</a>
                </td>
            </tr>
        </c:forEach>

    </table>
    <div class="modal" id="myModal">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="container mt-3" style="height: 710px">
                    <h2>Thêm</h2>
                    <form action="/home" method="post">
                        <div class="mb-3 mt-3">
                            <label>Name:</label>
                            <input style="width: 550px" type="text" class="form-control" placeholder="Enter name" name="name">
                        </div>
                        <div class="mb-3">
                            <label>date of birth:</label>
                            <input style="width: 550px" type="date" class="form-control" placeholder="Enter date" name="dateofbirth">
                        </div>
                        <div class="mb-3">
                            <label>Address</label>
                            <input style="width: 550px" type="text" class="form-control" placeholder="Enter Address" name="address">
                        </div>
                        <div class="mb-3">
                            <label>Phone:</label>
                            <input style="width: 550px" type=text class="form-control" placeholder="Enter age" name="phone">
                        </div>
                        <div class="mb-3">
                            <label>Classroom:</label>
                            <input style="width: 550px" type="text" class="form-control" placeholder="Enter classroom" name="classroom">
                        </div>
                        <div class="mb-3">
                            <label>Email:</label>
                            <input style="width: 550px" type="text" class="form-control" placeholder="Enter email" name="email">
                        </div>

                        <button type="submit" class="btn btn-primary" style="text-align: right">Thêm mới</button>
                        <br>
                    </form>
                </div>
            </div>
        </div>
    </div>
    </body>
</html>
