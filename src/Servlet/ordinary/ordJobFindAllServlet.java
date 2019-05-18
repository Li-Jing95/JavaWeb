package Servlet.ordinary;

import dao.ordinaryDao;
import dao.ordinaryDaoImpl;
import domain.Job;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/ordJobFindAllServlet")
public class ordJobFindAllServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        ordinaryDao ordinaryDao = new ordinaryDaoImpl();
//        jobDao jobDao = new jobDaoImpl();
        ArrayList<Job> list = ordinaryDao.ordFindJobAll();
        request.setAttribute("findall", list);
        request.getRequestDispatcher("/ordJobList.jsp").forward(request, response);
    }
}
