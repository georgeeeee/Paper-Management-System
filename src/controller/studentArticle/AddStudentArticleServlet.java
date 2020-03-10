package controller.studentArticle;

import bean.StudentArticleBean;
import service.StudentArticleRecordOperation;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;

/**
 * Created by GeorgeYang on 2017/12/27.
 */
@WebServlet(name = "AddStudentArticleServlet", urlPatterns = {"/addStudentPaper"})
@MultipartConfig
public class AddStudentArticleServlet extends HttpServlet {
    private StudentArticleRecordOperation articleOperation;
    private String contextPath;

    public void init(){
        articleOperation = new StudentArticleRecordOperation();
        contextPath = getServletContext().getRealPath("/Upload");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=utf-8");

        String studentID = request.getParameter("studentID");
        String title = request.getParameter("title");
        String content = request.getParameter("content");
        Part part = request.getPart("pic");
        String picAddr = "/" + title + ".jpeg";
        StudentArticleBean articleBean = new StudentArticleBean(studentID, title, content, picAddr);

        part.write(contextPath + picAddr);

        articleOperation.insertRecord(articleBean);
        System.out.println("插入论文记录成功");

        response.sendRedirect("/paperList");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
