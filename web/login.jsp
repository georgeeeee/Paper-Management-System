<%--
  Created by IntelliJ IDEA.
  User: GeorgeYang
  Date: 2017/12/26
  Time: 19:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Login</title>
    <meta charset="UTF-8">
    <link href="css/bootstrap.css" rel="stylesheet">
    <link href="font-awesome-4.7.0/css/font-awesome.css" rel="stylesheet">
    <script src="js/jquery-3.2.1.min.js"></script>
    <script src="js/bootstrap.js"></script>
    <style>
        form{
            max-width: 450px;
            margin: 0 auto;
            padding: 50px;
        }
        body{
            background-color: #eeeeee;
        }
    </style>
    <script type="text/javascript">
        $(function () {
            $(".close").click(function () {
                $(".alert").hide();
            })
        })
    </script>
</head>
<body>
    <div class="container">

        <form class="form-horizontal" action="/login" method="post" id="login">
            <div class="form-group" style="text-align: center">
                <h2>Login</h2>
            </div>

            <div class="form-group">
                <div class="input-group">
                    <span class="input-group-addon"><span class="fa fa-envelope"></span></span>
                    <input type="text" class="form-control" name="studentID" id="account" placeholder="StudentID">
                </div>
            </div>

            <div class="form-group">
                <div class="input-group">
                    <span class="input-group-addon"><span class="fa fa-key"></span></span>
                    <input type="password" class="form-control" name="password" id="password" placeholder="Password">
                </div>
            </div>

            <div class="form-group">
                <button href="" type="submit" class="btn btn-success form-control">Login</button>
            </div>

            <c:if test="${warning != null}">
                <div class="alert alert-warning alert-dismissable fade in" role="alert">
                    <button type="button" class="close" data-dismiss="alert">
                        <span aria-hidden="true">x</span>
                    </button>
                        ${warning}
                </div>
            </c:if>
        </form>
    </div>
</body>
</html>
