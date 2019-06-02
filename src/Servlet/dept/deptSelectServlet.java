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
import java.util.ArrayList;

@WebServlet("/deptSelectServlet")
public class deptSelectServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String name = request.getParameter("name");

        deptDao deptDao = new deptDaoImpl();
        if (deptDao.findDeptByName(name)) {
            ArrayList<Dept> list = deptDao.findDeptName(name);
            request.setAttribute("findall", list);
            request.getRequestDispatcher("/deptlist.jsp").forward(request, response);
        } else {
            response.setContentType("text/html;charset=utf-8");
            PrintWriter out = response.getWriter();
            out.print("<script language='javascript'>alert('查询数据为空');window.location='deptFindAllServlet'</script>");
            out.flush();
            out.close();
        }

    }
}
