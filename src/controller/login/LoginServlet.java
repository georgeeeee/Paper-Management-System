package controller.login;

import service.Login;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by GeorgeYang on 2017/12/27.
 */
@WebServlet(name = "LoginServlet", urlPatterns = {"/login"})
public class LoginServlet extends HttpServlet {
    private Login login;

    public void init(){
        login = new Login();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.addHeader("Content-Type", "application/json");

        String studentID = request.getParameter("studentID");
        String password = request.getParameter("password");
        System.out.println(studentID + " " + password);

        if(studentID == null || password == null){
            response.sendRedirect("/login.jsp");
        }
        if (password.equals(login.getPassword(studentID))){
            request.getSession().setAttribute("state", studentID);
            System.out.println(request.getSession().getAttribute("state"));
            response.sendRedirect("/index.jsp");
            System.out.println("登陆成功");
        } else {
            request.setAttribute("warning", "账号或密码错误");
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
