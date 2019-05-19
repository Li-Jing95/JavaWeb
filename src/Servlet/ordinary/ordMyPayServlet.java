package Servlet.ordinary;

import dao.payDao;
import dao.payDaoImpl;
import domain.Pay;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/ordMyPayServlet")
public class ordMyPayServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        HttpSession session = request.getSession();
        String a = session.getAttribute("login").toString();
        int b = Integer.parseInt(a);

        payDao payDao = new payDaoImpl();
        ArrayList<Pay> list = payDao.findPayById(b);

        request.setAttribute("findall", list);
        request.getRequestDispatcher("/ordMyPayList.jsp").forward(request, response);
    }
}
