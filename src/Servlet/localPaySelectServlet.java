package Servlet;

import dao.localPayDao;
import dao.localPayDaoImpl;
import domain.Dept;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/localPaySelectServlet")
public class localPaySelectServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String name = request.getParameter("name");

        localPayDao localPayDao = new localPayDaoImpl();
        ArrayList<Dept> list = localPayDao.findlocalPayName(name);
        request.setAttribute("findall", list);
        request.getRequestDispatcher("/localPayList.jsp").forward(request, response);
    }
}
