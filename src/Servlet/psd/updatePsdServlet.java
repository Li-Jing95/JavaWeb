package Servlet.psd;

import dao.ordinaryDao;
import dao.ordinaryDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/updatePsdServlet")
public class updatePsdServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String id = request.getParameter("id");
        int loginid = Integer.parseInt(id);
        String name = request.getParameter("name");
        String psd = request.getParameter("password");

        ordinaryDao ordinaryDao = new ordinaryDaoImpl();

        if (ordinaryDao.ordMiMaUpdate(name, psd, loginid)) {
            response.setContentType("text/html;charset=utf-8");
            PrintWriter out = response.getWriter();
            out.print("<script language='javascript'>alert('修改成功！');window.location='userPsdFindAllServlet'</script>");
            out.flush();
            out.close();
        } else {
            response.sendRedirect("updateFail.jsp");
        }
    }
}
