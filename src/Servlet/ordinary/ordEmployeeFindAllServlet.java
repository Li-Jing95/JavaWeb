package Servlet.ordinary;

import dao.ordinaryDao;
import dao.ordinaryDaoImpl;
import domain.Employee;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/ordEmployeeFindAllServlet")
public class ordEmployeeFindAllServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");

        ordinaryDao ordinaryDao = new ordinaryDaoImpl();
        ArrayList<Employee> list = ordinaryDao.ordFindEmployeeAll();
        request.setAttribute("findall", list);
        request.getRequestDispatcher("/ordEmployeeList.jsp").forward(request, response);
    }
}
