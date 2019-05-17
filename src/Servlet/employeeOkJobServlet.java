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
        int deptid = Integer.parseInt(dept);
        String job = request.getParameter("jobNameList");
        int jobid = Integer.parseInt(job);

        Employee employeeobj = new Employee();
        employeeobj.setId(employeeOkJobId);
        employeeobj.setName(name);
        employeeobj.setDept_id(deptid);
        employeeobj.setJob_id(jobid);

        employeeDao employeeDao = new employeeDaoImpl();

        if (employeeDao.employeeOkJobUpdate(employeeOkJobId, deptid, jobid)) {
            request.setAttribute("xiaoxi", "更新成功！");
            request.getRequestDispatcher("/employeeFindAllServlet").forward(request, response);
        } else
            request.getRequestDispatcher("/index.jsp").forward(request, response);
    }
}
