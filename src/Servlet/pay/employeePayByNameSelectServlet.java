package Servlet.pay;

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
import java.io.PrintWriter;
import java.util.ArrayList;

@WebServlet("/employeePayByNameSelectServlet")
public class employeePayByNameSelectServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String name = request.getParameter("name");

        employeePayDao employeePayDao = new employeePayDaoImpl();
        employeeDao employeeDao = new employeeDaoImpl();
        if (employeeDao.findEmployeeByName(name)) {
            ArrayList<Employee> list = employeePayDao.findEmployeePayName(name);
            request.setAttribute("findall", list);
            request.getRequestDispatcher("/employeePayList.jsp").forward(request, response);
        } else {
            response.setContentType("text/html;charset=utf-8");
            PrintWriter out = response.getWriter();
            out.print("<script language='javascript'>alert('查询数据为空');window.location='employeePayFindAllServlet'</script>");
            out.flush();
            out.close();
        }
    }
}
