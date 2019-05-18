package Servlet.dept;

import dao.deptDao;
import dao.deptDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

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
            request.setAttribute("xiaoxi", "更新成功！");
            request.getRequestDispatcher("/deptFindAllServlet").forward(request, response);
        } else {
            response.sendRedirect("UpdateFail.jsp");
        }
    }
}
