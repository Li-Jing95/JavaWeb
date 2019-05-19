package Servlet.job;

import dao.jobPayDao;
import dao.jobPayDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/jobPayUpdateServlet")
public class jobPayUpdateServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String id = request.getParameter("id");
        int jobPayId = Integer.parseInt(id);

        String jobPay = request.getParameter("jobpay");
        int jobpay = Integer.parseInt(jobPay);

        jobPayDao jobPayDao = new jobPayDaoImpl();
        if (jobPayDao.jobPayUpdate(jobpay, jobPayId)) {
            response.setContentType("text/html;charset=utf-8");
            PrintWriter out = response.getWriter();
            out.print("<script language='javascript'>alert('更新成功！');window.location='jobPayFindAllServlet'</script>");
            out.flush();
            out.close();
        } else {
            response.sendRedirect("updateFail.jsp");
        }
    }
}
