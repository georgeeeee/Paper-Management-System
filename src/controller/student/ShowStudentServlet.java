package controller.student;

import bean.DBConnect;
import bean.PageBean;
import bean.StudentBean;
import service.PageDividing;
import service.StudentPageDividing;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by GeorgeYang on 2017/12/27.
 */
@WebServlet(name = "ShowStudentServlet", urlPatterns = {"/studentList"})
public class ShowStudentServlet extends HttpServlet {
    private PageBean page;
    private PageDividing pageDividing;
    private static final int RECORD_PER_PAGE = 10;

    public void init(){
        page = new PageBean();
        pageDividing = new StudentPageDividing();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=utf-8");

        page.setCurrentPage(
                pageDividing.pageCounting(
                        request.getParameter("currentPage")
                )
        );
        page.setRecordPerPage(RECORD_PER_PAGE);
        page.setTotalRecord(pageDividing.getTotalRecord());
        List<StudentBean> stuList = pageDividing.getList(page);

        request.setAttribute("pageBean", page);
        request.setAttribute("stuList", stuList);
        request.getRequestDispatcher("listStudent.jsp").forward(request, response);
        stuList.clear();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
