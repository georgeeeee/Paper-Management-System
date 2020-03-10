package controller.studentArticle;

import service.StudentArticleRecordOperation;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by GeorgeYang on 2017/12/27.
 */
@WebServlet(name = "DeleteStudentArticleServlet", urlPatterns = {"/deletePaper"})
public class DeleteStudentArticleServlet extends HttpServlet {
    private StudentArticleRecordOperation articleOperation;

    public void init(){
        articleOperation = new StudentArticleRecordOperation();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=utf-8");

        String title = request.getParameter("title");

        articleOperation.deleteRecord(title);

        System.out.println("删除论文记录成功");

        response.sendRedirect("/paperList");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
