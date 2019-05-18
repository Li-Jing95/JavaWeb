package Servlet.employee;

import dao.employeeDao;
import dao.employeeDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

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
            request.setAttribute("xiaoxi", "删除成功！");
            request.getRequestDispatcher("/employeeFindAllServlet").forward(request, response);
        } else {
            request.setAttribute("xiaoxi", "删除失败！");
            request.getRequestDispatcher("/employeeFindAllServlet").forward(request, response);
        }
    }
}


