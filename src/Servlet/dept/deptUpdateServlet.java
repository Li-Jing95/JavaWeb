package Servlet.dept;

import dao.deptDao;
import dao.deptDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/deptUpdateServlet")
public class deptUpdateServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String id = request.getParameter("id");
        int deptId = Integer.parseInt(id);

        String name = request.getParameter("name");
        String remark = request.getParameter("remark");

        deptDao deptDao = new deptDaoImpl();
        if (deptDao.DeptUpdate(name, remark, deptId)) {
            response.setContentType("text/html;charset=utf-8");
            PrintWriter out = response.getWriter();
            out.print("<script language='javascript'>alert('更新成功！');window.location='deptFindAllServlet'</script>");
            out.flush();
            out.close();
        } else {
            response.setContentType("text/html;charset=utf-8");
            PrintWriter out = response.getWriter();
            out.print("<script language='javascript'>alert('更新失败！');window.location='deptFindAllServlet'</script>");
            out.flush();
            out.close();
        }
    }
}
