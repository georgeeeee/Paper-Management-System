<%--
  Created by IntelliJ IDEA.
  User: GeorgeYang
  Date: 2017/12/26
  Time: 19:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Main</title>
    <link rel="stylesheet" href="bootstrap-3.3.7-dist/css/bootstrap.css">
    <link rel="stylesheet" href="font-awesome-4.7.0/css/font-awesome.css">
    <script type="text/javascript" src="jquery-3.2.1.min.js"></script>
    <script type="text/javascript" src="bootstrap-3.3.7-dist/js/bootstrap.js"></script>
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
          <li><a href="/paperList">查看论文列表</a> </li>
        </ul>
      </li>
    </ul>
  </div>

    <div class="container">
      <div class="jumbotron">
        <h1>欢迎来到学生与学生论文管理系统</h1>
      </div>
    </div>
  </body>
</html>
