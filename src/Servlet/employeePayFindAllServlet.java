package Servlet;

import dao.employeeDao;
import dao.employeeDaoImpl;
import dao.employeePayDao;
import dao.employeePayDaoImpl;
import domain.Employee;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/employeePayFindAllServlet")
public class employeePayFindAllServlet extends HttpServlet{
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        employeePayDao employeepaydao=new employeePayDaoImpl();
        ArrayList<Employee> list=employeepaydao.findEmployeePayAll();
        request.setAttribute("findall", list);
        request.getRequestDispatcher("/employeePayList.jsp").forward(request, response);
    }
}
