package Servlet.pay;

import dao.payDao;
import dao.payDaoImpl;
import domain.Pay;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/realPayServlet")
public class realPayServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        //获取表单传过来的数据
        String id1 = request.getParameter("id");
        int id = Integer.parseInt(id1);
        String name = request.getParameter("name");
        String dept = request.getParameter("dept");
        String job = request.getParameter("job");
        String month = request.getParameter("month");
        String suml = request.getParameter("sum");
        Double sumpay = Double.valueOf(suml);
        String wuxian1 = request.getParameter("wuxian");
        Double wuxian = Double.valueOf(wuxian1);
        String shuihou1 = request.getParameter("shuihou");
        Double shuihou = Double.valueOf(shuihou1);
        String realpay1 = request.getParameter("realpay");
        Double realpay = Double.valueOf(realpay1);

        Pay payobj = new Pay();
        payobj.setId(id);
        payobj.setName(name);
        payobj.setDept(dept);
        payobj.setJob(job);
        payobj.setMonth(month);
        payobj.setSum(sumpay);
        payobj.setWuxian(wuxian);
        payobj.setShuihou(shuihou);
        payobj.setRealpay(realpay);

        //将获取到的数据与数据库的数据进行判断

        payDao payDao = new payDaoImpl();

        if (payDao.payAdd(payobj)) {
//            request.setAttribute("xiaoxi", "添加成功！");
//            request.getRequestDispatcher("/realPayFindAllServlet").forward(request, response);
            response.setContentType("text/html;charset=utf-8");
            PrintWriter out = response.getWriter();
            out.print("<script language='javascript'>alert('添加成功！');window.location='realPayFindAllServlet'</script>");
            out.flush();
            out.close();
        } else {
            response.sendRedirect("addUser.jsp");
        }
    }
}
