package Servlet.job;

import dao.jobDao;
import dao.jobDaoImpl;
import dao.jobPayDao;
import dao.jobPayDaoImpl;
import domain.Job;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

@WebServlet("/jobPaySelectServlet")
public class jobPaySelectServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String name = request.getParameter("name");

        jobPayDao jobPayDao = new jobPayDaoImpl();
        jobDao jobDao = new jobDaoImpl();
        if (jobDao.findJobByName(name)) {
            ArrayList<Job> list = jobPayDao.findjobPayName(name);
            request.setAttribute("findall", list);
            request.getRequestDispatcher("/jobPayList.jsp").forward(request, response);
        } else {
            response.setContentType("text/html;charset=utf-8");
            PrintWriter out = response.getWriter();
            out.print("<script language='javascript'>alert('查询数据为空');window.location='jobPayFindAllServlet'</script>");
            out.flush();
            out.close();
        }
    }
}
