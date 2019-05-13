package Servlet;

import dao.jobPayDao;
import dao.jobPayDaoImpl;
import dao.localPayDao;
import dao.localPayDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

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
        int jobpay=Integer.parseInt(jobPay);

        jobPayDao jobPayDao = new jobPayDaoImpl();
        if (jobPayDao.jobPayUpdate(jobpay,jobPayId)) {
            request.setAttribute("xiaoxi", "更新成功！");
            request.getRequestDispatcher("/jobPayFindAllServlet").forward(request, response);
        } else {
            response.sendRedirect("updateFail.jsp");
        }
    }
}
