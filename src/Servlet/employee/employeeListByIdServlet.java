package Servlet.employee;

import dao.employeeDao;
import dao.employeeDaoImpl;
import domain.Employee;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/employeeListByIdServlet")
public class employeeListByIdServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");

        String employeeid = request.getParameter("id");
        int id = Integer.parseInt(employeeid);

        employeeDao employeeDao = new employeeDaoImpl();
        ArrayList<Employee> list = employeeDao.findEmployeeById(id);
        request.setAttribute("findall", list);
        request.getRequestDispatcher("/employeeListById.jsp").forward(request, response);
    }
}
