package Servlet.user;

import dao.userDao;
import dao.userDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/updateServlet")
public class updateServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String id = request.getParameter("id");
        int userId = Integer.parseInt(id);

        String loginname = request.getParameter("loginname");
        String password = request.getParameter("password");
        String createdate = request.getParameter("createdate");
        String username = request.getParameter("username");

        userDao dao = new userDaoImpl();
        if (dao.update(loginname, password, createdate, username, userId)) {
            request.setAttribute("xiaoxi", "更新成功！");
            request.getRequestDispatcher("/findAllServlet").forward(request, response);
        } else {
            response.sendRedirect("UpdateFail.jsp");
        }
    }
}
