package Servlet.ordinary;

import dao.ordinaryDao;
import dao.ordinaryDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/ordLoginServlet")
public class ordLoginServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        //获取表单传过来的数据
        String User = request.getParameter("loginname");
        HttpSession session = request.getSession();
        session.setAttribute("login", User);
        String Password = request.getParameter("password");
        //将获取到的数据与数据库的数据进行判断
        ordinaryDao ordinaryDao =new ordinaryDaoImpl();
        //账号密码正确，登录成功
        if (ordinaryDao.ordLogin(User, Password)) {
            request.getRequestDispatcher("/ordOk.jsp").forward(request, response);
        } else {
            response.setContentType("text/html;charset=utf-8");
            PrintWriter out = response.getWriter();
            out.print("<script language='javascript'>alert('用户名和密码错误，请重新输入！');window.location='ordLogin.jsp'</script>");
            out.flush();
            out.close();
        }
    }
}

