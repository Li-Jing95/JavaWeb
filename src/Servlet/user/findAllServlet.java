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
import java.util.ArrayList;

@WebServlet("/findAllServlet")
public class findAllServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        userDao dao = new userDaoImpl();
        ArrayList<User> list = dao.findAll();
        request.setAttribute("findall",list);
        request.getRequestDispatcher("/userlist.jsp").forward(request, response);
    }
}
