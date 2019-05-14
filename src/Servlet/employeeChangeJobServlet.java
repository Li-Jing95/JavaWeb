package Servlet;

import dao.employeeDao;
import dao.employeeDaoImpl;
import dao.jobDao;
import dao.jobDaoImpl;
import domain.Employee;
import domain.Job;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

//调岗servlet
@WebServlet("/employeeChangeJobServlet")
public class employeeChangeJobServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        employeeDao employeeDao = new employeeDaoImpl();
        String id = request.getParameter("id");
        int employeeChangeJobId = Integer.parseInt(id);
        ArrayList<Employee> list = employeeDao.findEmployeeJobId(employeeChangeJobId);
        request.setAttribute("findall", list);
        request.getRequestDispatcher("/employeeChangeJobList.jsp").forward(request, response);
    }

}
