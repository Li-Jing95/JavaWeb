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

@WebServlet("/deletePsdServlet")
public class deletePsdServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取表单传过来的数据
        String id = request.getParameter("id");
        int Id = Integer.parseInt(id);
        //将获取到的数据与数据库的数据进行判断
        ordinaryDao ordinaryDao = new ordinaryDaoImpl();

        if (ordinaryDao.deleteOrdMiMa(Id)) {
            response.setContentType("text/html;charset=utf-8");
            PrintWriter out = response.getWriter();
            out.print("<script language='javascript'>alert('删除成功！');window.location='userPsdFindAllServlet'</script>");
            out.flush();
            out.close();
        } else {
            response.setContentType("text/html;charset=utf-8");
            PrintWriter out = response.getWriter();
            out.print("<script language='javascript'>alert('删除失败！');window.location='userPsdFindAllServlet'</script>");
            out.flush();
            out.close();
        }
    }
}


