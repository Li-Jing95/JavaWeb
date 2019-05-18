package Servlet.user;//登录判断

import dao.userDao;
import dao.userDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/loginServlet")
public class loginServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        //获取表单传过来的数据
        String User = request.getParameter("loginname");
        String Password = request.getParameter("password");
        //将获取到的数据与数据库的数据进行判断
        userDao dao = new userDaoImpl();
        //账号密码正确，登录成功
        if (dao.login(User, Password)) {
            request.getRequestDispatcher("/ok.jsp").forward(request, response);
        } else {
            response.setContentType("text/html;charset=utf-8");
            PrintWriter out = response.getWriter();
            out.print("<script language='javascript'>alert('用户名和密码错误，请重新输入！');window.location='login.jsp'</script>");
            out.flush();
            out.close();
        }
    }
}
