package Servlet;

import dao.jobDao;
import dao.jobDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/jobDeleteServlet")
public class jobDeleteServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取表单传过来的数据
        String id = request.getParameter("id");
        int jobId = Integer.parseInt(id);
        //将获取到的数据与数据库的数据进行判断
        jobDao jobDao = new jobDaoImpl();
        if (jobDao.JobDelete(jobId)) {
            request.setAttribute("xiaoxi", "删除成功！");
            request.getRequestDispatcher("/jobFindAllServlet").forward(request, response);
        } else {
            request.setAttribute("xiaoxi", "删除失败！");
            request.getRequestDispatcher("/jobFindAllServlet").forward(request, response);
        }
    }
}
