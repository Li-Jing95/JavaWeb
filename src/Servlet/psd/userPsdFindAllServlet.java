package Servlet.psd;

import dao.ordinaryDao;
import dao.ordinaryDaoImpl;
import domain.ordUser;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/userPsdFindAllServlet")
public class userPsdFindAllServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        ordinaryDao ordinaryDao = new ordinaryDaoImpl();
        ArrayList<ordUser> list = ordinaryDao.ordPsdFindAll();
        request.setAttribute("findall", list);
        request.getRequestDispatcher("/ordPsdList.jsp").forward(request, response);
    }
}
