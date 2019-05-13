package Servlet;

import dao.jobDao;
import dao.jobDaoImpl;
import domain.Job;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/jobRegisterServlet")
public class jobRegisterServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        //获取表单传过来的数据
        String id=request.getParameter("deptid");
        int deptid=Integer.parseInt(id);
        String lname = request.getParameter("name");
        String remark = request.getParameter("remark");

        Job jobobj = new Job();
        jobobj.setId(deptid);
        jobobj.setName(lname);
        jobobj.setRemark(remark);
        //将获取到的数据与数据库的数据进行判断
        jobDao jobDao = new jobDaoImpl();

        if (jobDao.JobAdd(jobobj)) {
            request.setAttribute("xiaoxi", "添加成功！");
            request.getRequestDispatcher("/jobFindAllServlet").forward(request, response);
        } else {
            response.sendRedirect("addJob.jsp");
        }
    }
}
