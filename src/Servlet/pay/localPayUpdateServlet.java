package Servlet.pay;

import dao.localPayDao;
import dao.localPayDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/localPayUpdateServlet")
public class localPayUpdateServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String id = request.getParameter("id");
        int localPayId = Integer.parseInt(id);

        String localPay = request.getParameter("localpay");
        int localpay=Integer.parseInt(localPay);

        localPayDao localPayDao = new localPayDaoImpl();
        if (localPayDao.localPayUpdate(localpay,localPayId)) {
//            request.setAttribute("xiaoxi", "更新成功！");
//            request.getRequestDispatcher("/localPayFindAllServlet").forward(request, response);

            response.setContentType("text/html;charset=utf-8");
            PrintWriter out = response.getWriter();
            out.print("<script language='javascript'>alert('更新成功！');window.location='localPayFindAllServlet'</script>");
            out.flush();
            out.close();
        } else {
            response.sendRedirect("updateFail.jsp");
        }
    }
}
