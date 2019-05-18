package Servlet.job;

import dao.deptDao;
import dao.deptDaoImpl;
import dao.jobDao;
import dao.jobDaoImpl;
import domain.Dept;
import domain.Job;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/jobFindNameAllServlet")
public class jobFindNameAllServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        jobDao jobDao = new jobDaoImpl();
        ArrayList<Job> list = jobDao.findNameAll();
        request.setAttribute("findall", list);
//        request.getRequestDispatcher("/deptlist.jsp").forward(request, response);
    }
}
