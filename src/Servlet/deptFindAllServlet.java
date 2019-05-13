package Servlet;

import dao.deptDao;
import dao.deptDaoImpl;
import domain.Dept;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/deptFindAllServlet")
public class deptFindAllServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        deptDao deptDao = new deptDaoImpl();
        ArrayList<Dept> list = deptDao.findDeptAll();
        request.setAttribute("findall", list);
        request.getRequestDispatcher("/deptlist.jsp").forward(request, response);
    }
}
