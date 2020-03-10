package controller.student;

import bean.StudentBean;
import service.StudentRecordOperation;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by GeorgeYang on 2017/12/27.
 */
@WebServlet(name = "ModifyStudentServlet", urlPatterns = {"/modifyStudent"})
public class ModifyStudentServlet extends HttpServlet {
    private StudentRecordOperation stuOperation;

    public void init(){
        stuOperation = new StudentRecordOperation();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=utf-8");

        String elderStudentID = request.getParameter("elderStudentID");
        String studentID = request.getParameter("studentID");
        String studentName = request.getParameter("studentName");
        String studentCollege = request.getParameter("studentCollege");
        StudentBean studentBean = new StudentBean(studentID, studentName, studentCollege);
        stuOperation.modifyRecord(studentBean, elderStudentID);

        System.out.println("学生信息修改成功");

        response.sendRedirect("/studentList");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
