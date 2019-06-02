package Servlet.ordinary;

import dao.jobDao;
import dao.jobDaoImpl;
import domain.Job;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

@WebServlet("/ordJobSelectServlet")
public class ordJobSelectServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String name = request.getParameter("selectname");

        jobDao jobDao = new jobDaoImpl();
        if (jobDao.findJobByName(name)) {
            ArrayList<Job> list = jobDao.findJobName(name);
            request.setAttribute("findall", list);
            request.getRequestDispatcher("/ordJobList.jsp").forward(request, response);
        } else {
            response.setContentType("text/html;charset=utf-8");
            PrintWriter out = response.getWriter();
            out.print("<script language='javascript'>alert('查询数据为空！');window.location='ordJobFindAllServlet'</script>");
            out.flush();
            out.close();
        }
    }
}
