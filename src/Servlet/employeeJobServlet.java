package Servlet;

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

@WebServlet("/employeeJobServlet")
public class employeeJobServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");

        employeeDao employeeDao = new employeeDaoImpl();
        ArrayList<Employee> list = employeeDao.findEmployeeJob();
        request.setAttribute("findall", list);
        request.getRequestDispatcher("/employeeJobList.jsp").forward(request, response);
    }
}
