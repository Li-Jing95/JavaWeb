package Servlet.ordinary;

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

@WebServlet("/ordDeptSelectServlet")
public class ordDeptSelectServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String name = request.getParameter("name");

        deptDao deptDao = new deptDaoImpl();
        ArrayList<Dept> list = deptDao.findDeptByName(name);
        request.setAttribute("findall", list);
        request.getRequestDispatcher("/ordDeptList.jsp").forward(request, response);
    }
}
