package Servlet.pay;

import dao.payDao;
import dao.payDaoImpl;
import domain.Pay;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/paySelectByMonthServlet")
public class paySelectByMonthServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String month = request.getParameter("month");

        payDao payDao = new payDaoImpl();
        ArrayList<Pay> list = payDao.findPayByMonth(month);
        request.setAttribute("findall", list);
        request.getRequestDispatcher("/realPayList.jsp").forward(request, response);
    }
}
