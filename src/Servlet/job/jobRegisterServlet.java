package Servlet.job;

import dao.jobDao;
import dao.jobDaoImpl;
import domain.Job;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/jobRegisterServlet")
public class jobRegisterServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        //获取表单传过来的数据
        String id = request.getParameter("deptid");
        int deptid = Integer.parseInt(id);
        String lname = request.getParameter("name");
        String remark = request.getParameter("remark");

        Job jobobj = new Job();
        jobobj.setName(lname);
        jobobj.setRemark(remark);
        jobobj.setDept_id(deptid);
        //将获取到的数据与数据库的数据进行判断
        jobDao jobDao = new jobDaoImpl();

//        if (jobDao.jobAddByName(lname)) {
//            response.setContentType("text/html;charset=utf-8");
//            PrintWriter out = response.getWriter();
//            out.print("<script language='javascript'>alert('此岗位已存在员工，请勿重新操作！');window.location='addJob.jsp'</script>");
//            out.flush();
//            out.close();
//        } else {
        if (jobDao.JobAdd(jobobj)) {
            response.setContentType("text/html;charset=utf-8");
            PrintWriter out = response.getWriter();
            out.print("<script language='javascript'>alert('添加成功！');window.location='jobFindAllServlet'</script>");
            out.flush();
            out.close();
        } else {
            response.setContentType("text/html;charset=utf-8");
            PrintWriter out = response.getWriter();
            out.print("<script language='javascript'>alert('添加失败！');window.location='jobFindAllServlet'</script>");
            out.flush();
            out.close();
//            }
        }
    }
}
