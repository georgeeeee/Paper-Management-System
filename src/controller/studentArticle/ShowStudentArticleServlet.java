package controller.studentArticle;

import bean.PageBean;
import bean.StudentArticleAuthorityBean;
import bean.StudentArticleBean;
import service.PageDividing;
import service.StudentArticlePageDividing;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by GeorgeYang on 2017/12/27.
 */
@WebServlet(name = "ShowStudentArticleServlet", urlPatterns = {"/paperList"})
public class ShowStudentArticleServlet extends HttpServlet {
    private PageBean page;
    private PageDividing pageDividing;
    private static final int RECORD_PER_PAGE = 10;

    public void init(){
        page = new PageBean();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=utf-8");

        String loginStudentID = (String) request.getSession().getAttribute("state");
        pageDividing = new StudentArticlePageDividing(loginStudentID);

        page.setCurrentPage(
                pageDividing.pageCounting(
                        request.getParameter("currentPage")
                )
        );
        page.setRecordPerPage(RECORD_PER_PAGE);
        page.setTotalRecord(pageDividing.getTotalRecord());
        List<StudentArticleAuthorityBean> articleList = pageDividing.getList(page);

        request.setAttribute("pageBean", page);
        request.setAttribute("articleList", articleList);
        System.out.println("articleList长度：" + articleList.size());
        request.getRequestDispatcher("listArticle.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
