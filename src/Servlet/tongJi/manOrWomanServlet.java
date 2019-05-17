package Servlet.tongJi;

import dao.deptDao;
import dao.deptDaoImpl;
import dao.employeeDao;
import dao.employeeDaoImpl;
import domain.Dept;
import domain.Employee;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/manOrWomanServlet")
public class manOrWomanServlet extends HttpServlet{
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        employeeDao employeeobj=new employeeDaoImpl();
        ArrayList<Employee> list = employeeobj.findManOrWomanAll();
        request.setAttribute("findall", list);
        request.getRequestDispatcher("/manOrWoman.jsp").forward(request, response);
    }
}
