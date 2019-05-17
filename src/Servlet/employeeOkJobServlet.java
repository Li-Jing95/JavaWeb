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

@WebServlet("/employeeOkJobServlet")
public class employeeOkJobServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");

        String id = request.getParameter("id");
        int employeeOkJobId = Integer.parseInt(id);
        String name = request.getParameter("name");
        String dept = request.getParameter("brand");
        int deptid=Integer.parseInt(dept);
        String job = request.getParameter("jobNameList");
        int jobid=Integer.parseInt(job);

        Employee employeeobj = new Employee();
        employeeobj.setId(employeeOkJobId);
        employeeobj.setName(name);
        employeeobj.setDept_id(deptid);
        employeeobj.setJob_id(jobid);
        employeeobj.setJob_ostatus(1);

        employeeDao employeeDao = new employeeDaoImpl();

        if (employeeDao.employeeOkAdd(employeeobj)) {
            request.setAttribute("xiaoxi", "添加成功！");
            request.getRequestDispatcher("/employeeOkJobListServlet").forward(request, response);
        }else
            request.getRequestDispatcher("/login.jsp").forward(request, response);
    }
}
