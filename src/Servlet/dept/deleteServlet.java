package Servlet.dept;

import dao.userDao;
import dao.userDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/deleteServlet")
public class deleteServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取表单传过来的数据
        String id = request.getParameter("id");
        int userId = Integer.parseInt(id);
        //将获取到的数据与数据库的数据进行判断
        userDao dao = new userDaoImpl();
        if (dao.delete(userId)) {
            response.setContentType("text/html;charset=utf-8");
            PrintWriter out = response.getWriter();
            out.print("<script language='javascript'>alert('删除成功！');window.location='findAllServlet'</script>");
            out.flush();
            out.close();
        }
        else {
            response.setContentType("text/html;charset=utf-8");
            PrintWriter out = response.getWriter();
            out.print("<script language='javascript'>alert('删除成功！');window.location='findAllServlet'</script>");
            out.flush();
            out.close();
        }
    }
}
