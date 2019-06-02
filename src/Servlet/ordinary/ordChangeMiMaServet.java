package Servlet.ordinary;

import dao.ordinaryDao;
import dao.ordinaryDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/ordChangeMiMaServet")
public class ordChangeMiMaServet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        //获取表单传过来的数据
        HttpSession session = request.getSession();
        String name = String.valueOf(session.getAttribute("login"));
        String pword = request.getParameter("newpsd");
        ordinaryDao ordinaryDao = new ordinaryDaoImpl();
        if (ordinaryDao.miMaUpdate(pword, name)) {
//            request.setAttribute("xiaoxi","修改成功！");
//            request.getRequestDispatcher("ordLogin.jsp").forward(request, response);

            response.setContentType("text/html;charset=utf-8");
            PrintWriter out = response.getWriter();
            out.print("<script language='javascript'>alert('修改成功！');window.location='ordLogin.jsp'</script>");
            out.flush();
            out.close();
        } else {
            response.sendRedirect("addUser.jsp");
        }
    }
}
