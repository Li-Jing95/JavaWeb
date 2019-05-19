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

@WebServlet("/deptDeleteServlet")
public class deptDeleteServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取表单传过来的数据
        String id = request.getParameter("id");
        int deptId = Integer.parseInt(id);
        //将获取到的数据与数据库的数据进行判断
        deptDao deptDao = new deptDaoImpl();

        if (deptDao.isOrNotjob(deptId)) {
            response.setContentType("text/html;charset=utf-8");
            PrintWriter out = response.getWriter();
            out.print("<script language='javascript'>alert('该部门下有岗位，请勿删除！');window.location='deptFindAllServlet'</script>");
            out.flush();
            out.close();
        } else {
            if (deptDao.DeptDelete(deptId)) {
                response.setContentType("text/html;charset=utf-8");
                PrintWriter out = response.getWriter();
                out.print("<script language='javascript'>alert('删除成功！');window.location='deptFindAllServlet'</script>");
                out.flush();
                out.close();
            } else {
                response.setContentType("text/html;charset=utf-8");
                PrintWriter out = response.getWriter();
                out.print("<script language='javascript'>alert('删除失败！');window.location='deptFindAllServlet'</script>");
                out.flush();
                out.close();
            }
        }
    }
}
