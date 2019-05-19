package Servlet.dept;

import dao.deptDao;
import dao.deptDaoImpl;
import domain.Dept;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/deptRegisterServlet")
public class deptRegisterServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        //获取表单传过来的数据
//        String id=request.getParameter("deptid");
//        int deptid=Integer.parseInt(id);
        String name = request.getParameter("name");
        String remark = request.getParameter("remark");

        Dept deptobj = new Dept();
        deptobj.setName(name);
        deptobj.setRemark(remark);
        //将获取到的数据与数据库的数据进行判断

        deptDao deptDao = new deptDaoImpl();

        if (deptDao.DeptAdd(deptobj)) {
            response.setContentType("text/html;charset=utf-8");
            PrintWriter out = response.getWriter();
            out.print("<script language='javascript'>alert('添加成功！');window.location='deptFindAllServlet'</script>");
            out.flush();
            out.close();
        } else {
            response.sendRedirect("addUser.jsp");
        }
    }
}
