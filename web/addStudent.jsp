<%--
  Created by IntelliJ IDEA.
  User: GeorgeYang
  Date: 2017/12/26
  Time: 19:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <title>addArticle</title>
    <link rel="stylesheet" href="bootstrap-3.3.7-dist/css/bootstrap.css">
    <link rel="stylesheet" href="font-awesome-4.7.0/css/font-awesome.css">
    <script type="text/javascript" src="jquery-3.2.1.min.js"></script>
    <script type="text/javascript" src="bootstrap-3.3.7-dist/js/bootstrap.js"></script>
    <style>

    </style>
</head>
<body>
<div class="container">
    <ul class="nav nav-pills">
        <li role="presentation" class="active"><a href="#">首页</a> </li>
        <li role="presentation" class="dropdown">
            <a class="dropdown-toggle" data-toggle="dropdown" href="#" role="button" aria-haspopup="true" aria-expanded="false">
                学生个人信息 <span class="caret"></span>
            </a>
            <ul class="dropdown-menu">
                <li><a href="/studentList">查看学生列表</a></li>
                <li><a href="addStudent.jsp">添加学生</a> </li>
            </ul>
        </li>
        <li role="presentation" class="dropdown">
            <a class="dropdown-toggle" data-toggle="dropdown" href="#" role="button" aria-haspopup="true" aria-expanded="false">
                学生论文 <span class="caret"></span>
            </a>
            <ul class="dropdown-menu">
                <li><a href="#">查看论文列表</a> </li>
            </ul>
        </li>
    </ul>
</div>
<div class="container" style="margin-top: 20px; margin-bottom: 20px">
    <form class="form-horizontal" method="post" action="/addStudent" >
        <div class="form-group" style="margin-top: 20px">
            <div class="col-lg-2"></div>
            <label for="inputStudentID" class="col-lg-2 control-label">学生ID</label>
            <div class="col-lg-5">
                <input type="text" name="studentID" class="form-control" id="inputStudentID" placeholder="StudentID">
            </div>
        </div>
        <div class="form-group">
            <div class="col-lg-2"></div>
            <label for="inputStudentName" class="col-lg-2 control-label">学生姓名</label>
            <div class="col-lg-5">
                <input type="text" name="studentName" class="form-control" id="inputStudentName" placeholder="StudentName">
            </div>
        </div>
        <div class="form-group">
            <div class="col-lg-2"></div>
            <label for="inputStudentCollege" class="col-lg-2 control-label">所在学院</label>
            <div class="col-lg-5">
                <input type="text" name="studentCollege" class="form-control" id="inputStudentCollege" placeholder="StudentCollege">
            </div>
        </div>
        <div class="form-group">
            <button type="submit" class="btn btn-success center-block" style="width: 200px">保存</button>
        </div>
    </form>
</div>
</body>
</html>
