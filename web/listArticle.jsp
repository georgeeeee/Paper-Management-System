<%@ page import="java.util.List" %>
<%@ page import="bean.StudentArticleAuthorityBean" %><%--
  Created by IntelliJ IDEA.
  User: GeorgeYang
  Date: 2017/12/26
  Time: 19:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>ListArticle</title>
    <link rel="stylesheet" href="bootstrap-3.3.7-dist/css/bootstrap.css">
    <link rel="stylesheet" href="font-awesome-4.7.0/css/font-awesome.css">
    <script type="text/javascript" src="jquery-3.2.1.min.js"></script>
    <script type="text/javascript" src="bootstrap-3.3.7-dist/js/bootstrap.js"></script>
    <style>
        table img{
            width: 100px;
            height: 150px;
        }
        table a{
            color: white;
        }
    </style>
    <script>
        var $title;
        function getTitle(str) {
            $title = str;
            $("#ensure").modal('show');
        }
        $(function () {
            $("#delete").click(function () {
                window.location.href = $(this).attr("href") + $title;
            })
        })
    </script>
</head>
<body>
<div class="container">
    <ul class="nav nav-pills">
        <li role="presentation" ><a href="#">首页</a> </li>
        <li role="presentation" class="dropdown">
            <a class="dropdown-toggle" data-toggle="dropdown" href="#" role="button" aria-haspopup="true" aria-expanded="false">
                学生个人信息 <span class="caret"></span>
            </a>
            <ul class="dropdown-menu">
                <li><a href="/studentList">查看学生列表</a></li>
                <li><a href="addStudent.jsp">添加学生</a> </li>
            </ul>
        </li>
        <li role="presentation" class="dropdown active">
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
    <table class="table table-hover table-bordered">
        <tr>
            <th>学生ID</th>
            <th>论文标题</th>
            <th>论文封面</th>
            <th>操作</th>
        </tr>

        <c:if test="${articleList.size() > 0}">
            <c:forEach items="${articleList}" var="order">
                <tr>
                    <td><c:out value="${order.studentId}"/></td>
                    <td><c:out value="${order.title}"/></td>
                    <td><img src="../Upload${order.pictureAddr}"/></td>
                    <td>
                        <button class="btn btn-primary"><a href="#">查看内容</a></button>
                        <c:if test="${order.hasAuthority == true}">
                            <button class="btn btn-warning"><a href="editArticle.jsp?studentID=${order.studentId}&title=${order.title}&picAddr=${order.pictureAddr}&content=${order.content}">修改</a></button>
                            <button class="btn btn-danger" onclick="getTitle('${order.title}')">删除</button>
                        </c:if>
                    </td>
                </tr>
            </c:forEach>
        </c:if>
        <div class="modal fade" tabindex="-1" role="dialog" id="ensure" aria-hidden="true">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                        <h4 class="modal-title">确定删除该记录？</h4>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                        <button type="button" id="delete" class="btn btn-danger" data-dismiss="modal" href="/deletePaper?title=">删除</button>
                    </div>
                </div><!-- /.modal-content -->
            </div><!-- /.modal-dialog -->
        </div><!-- /.modal -->
    </table>
</div>

<div class="container">
    <nav aria-label="Page navigator">
        <ul class="pagination " style="margin-left: 40%">

            <c:if test="${pageBean.getCurrentPage() > 1}">
                <li>
                    <a href="paperList?currentPage=${pageBean.getCurrentPage() - 1}" aria-label="Previous">
                        <span aria-hidden="true">上一页</span>
                    </a>
                </li>
            </c:if>
            <li>
                <span aria-hidden="true">共${pageBean.getTotalPage()}页</span>
            </li>
            <li>
                <span aria-hidden="true">第${pageBean.getCurrentPage()}页</span>
            </li>
            <c:if test="${pageBean.getCurrentPage() < pageBean.getTotalPage()}">
                <li>
                    <a href="paperList?currentPage=${pageBean.getCurrentPage() + 1}" aria-label="Next">
                        <span aria-hidden="true">下一页</span>
                    </a>
                </li>
            </c:if>
        </ul>
    </nav>
</div>
</body>
</html>
