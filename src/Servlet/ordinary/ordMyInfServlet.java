package Servlet.ordinary;

import dao.employeeDao;
import dao.employeeDaoImpl;
import domain.Employee;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/ordMyInfServlet")
public class ordMyInfServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        HttpSession session = request.getSession();
        String a = session.getAttribute("login").toString();
        int b = Integer.parseInt(a);

        employeeDao employeeDao = new employeeDaoImpl();
        ArrayList<Employee> list = employeeDao.findMyInfById(b);
        request.setAttribute("findall", list);
        request.getRequestDispatcher("/ordMyInfList.jsp").forward(request, response);
    }
}
