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
import java.io.PrintWriter;

@WebServlet("/employeeAddOrdUserServlet")
public class employeeAddOrdUserServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        //获取表单传过来的数据
        String id1 = request.getParameter("id");
        int id = Integer.parseInt(id1);

        Employee employeeobj = new Employee();
        employeeobj.setId(id);

        employeeDao employeeDao = new employeeDaoImpl();

        if (employeeDao.isOrNotId(id)) {
            response.setContentType("text/html;charset=utf-8");
            PrintWriter out = response.getWriter();
            out.print("<script language='javascript'>alert('该用户已入库，请勿重复操作！');window.location='employeeFindAllServlet'</script>");
            out.flush();
            out.close();
        } else {

            if (employeeDao.idAdd(id)) {
                response.setContentType("text/html;charset=utf-8");
                PrintWriter out = response.getWriter();
                out.print("<script language='javascript'>alert('添加成功且初始密码为888！');window.location='employeeFindAllServlet'</script>");
                out.flush();
                out.close();

            } else {
                response.sendRedirect("addUser.jsp");
            }
        }
    }
}
