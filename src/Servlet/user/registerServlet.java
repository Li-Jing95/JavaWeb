package Servlet.user;


import dao.userDao;
import dao.userDaoImpl;
import domain.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/registerServlet")
public class registerServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        //获取表单传过来的数据
        String lname = request.getParameter("loginname");
        String pword = request.getParameter("password");
        String cdate = request.getParameter("createdate");
        String uname = request.getParameter("username");

        User obj = new User();
        obj.setLoginname(lname);
        obj.setPassword(pword);
        obj.setCreatedate(cdate);
        obj.setUsername(uname);
        //将获取到的数据与数据库的数据进行判断

        userDao dao = new userDaoImpl();

        if (dao.add(obj)) {
            request.setAttribute("xiaoxi","添加成功！");
            request.getRequestDispatcher("/findAllServlet").forward(request, response);
        } else {
            response.sendRedirect("addUser.jsp");
        }
    }
}
