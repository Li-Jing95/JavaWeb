package Servlet.employee;

import dao.employeeDao;
import dao.employeeDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/employeeDeleteServlet")
public class employeeDeleteServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String id = request.getParameter("id");
        int employeeId = Integer.parseInt(id);

        employeeDao employeeDao = new employeeDaoImpl();

        if (employeeDao.EmployeeDelete(employeeId)) {
            response.setContentType("text/html;charset=utf-8");
            PrintWriter out = response.getWriter();
            out.print("<script language='javascript'>alert('删除成功！');window.location='employeeFindAllServlet'</script>");
            out.flush();
            out.close();
        } else {
            response.setContentType("text/html;charset=utf-8");
            PrintWriter out = response.getWriter();
            out.print("<script language='javascript'>alert('删除失败！');window.location='employeeFindAllServlet'</script>");
            out.flush();
            out.close();
        }
    }
}


