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

@WebServlet("/employeeUpdateServlet")
public class employeeUpdateServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String name=request.getParameter("name");
        String sex=request.getParameter("sex");
        String nation=request.getParameter("nation");
        String polic=request.getParameter("polic");
        String born=request.getParameter("born");
        String tel=request.getParameter("tel");
        String email=request.getParameter("email");
        String education=request.getParameter("education");
        String card_id=request.getParameter("card_id");
        String createdate= request.getParameter("createdate");
        String sid=request.getParameter("id");
        int id=Integer.parseInt(sid);
        employeeDao employeeDao = new employeeDaoImpl();
        if (employeeDao.EmployeeUpdate(name,sex,nation,polic,born,tel,email,education,card_id,createdate,id)) {
            request.setAttribute("xiaoxi", "更新成功！");
            request.getRequestDispatcher("/employeeFindAllServlet").forward(request, response);
        } else {
            response.sendRedirect("UpdateFail.jsp");
        }
    }
}
