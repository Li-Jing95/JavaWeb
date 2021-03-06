package Servlet.job;

import dao.jobDao;
import dao.jobDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/jobUpdateServlet")
public class jobUpdateServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String id = request.getParameter("id");
        int deptId = Integer.parseInt(id);

        String name = request.getParameter("name");
        String remark = request.getParameter("remark");

        jobDao jobDao = new jobDaoImpl();
        if (jobDao.JobUpdate(name, remark, deptId)) {
//            request.setAttribute("xiaoxi", "更新成功！");
//            request.getRequestDispatcher("/jobFindAllServlet").forward(request, response);
            response.setContentType("text/html;charset=utf-8");
            PrintWriter out = response.getWriter();
            out.print("<script language='javascript'>alert('更新成功！');window.location='jobFindAllServlet'</script>");
            out.flush();
            out.close();
        } else {
            response.sendRedirect("UpdateFail.jsp");
        }
    }
}
