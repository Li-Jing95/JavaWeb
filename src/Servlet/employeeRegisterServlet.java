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

@WebServlet("/employeeRegisterServlet")
public class employeeRegisterServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        //获取表单传过来的数据
        String lname = request.getParameter("name");
        String sex = request.getParameter("sex");
        String nation=request.getParameter("nation");
        String polic=request.getParameter("polic");
        String born=request.getParameter("born");
        String tel = request.getParameter("tel");
        String email = request.getParameter("email");
        String education = request.getParameter("education");
        String card_id = request.getParameter("card_id");
        String createdate = request.getParameter("createdate");

        Employee employeeobj = new Employee();
        employeeobj.setName(lname);
        employeeobj.setSex(sex);
        employeeobj.setTel(tel);
        employeeobj.setNation(nation);
        employeeobj.setPolic(polic);
        employeeobj.setBorn(born);
        employeeobj.setEmail(email);
        employeeobj.setEducation(education);
        employeeobj.setCard_id(card_id);
        employeeobj.setCreatedate(createdate);

        //将获取到的数据与数据库的数据进行判断
        employeeDao employeeDao = new employeeDaoImpl();

        if (employeeDao.EmployeeAdd(employeeobj)) {
            request.setAttribute("xiaoxi", "添加成功！");
            request.getRequestDispatcher("/employeeFindAllServlet").forward(request, response);
        } else {
            response.sendRedirect("addEmployee.jsp");
        }
    }
}
