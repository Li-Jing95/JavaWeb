package Servlet;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet("/deptLinkJobServlet")
public class deptLinkJobServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException{
        doPost(request,response);
    }
    public void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
        request.setCharacterEncoding("utf-8");
        String deptId=request.getParameter("deptId");
        jobDao jobDao=new jobDaoImpl();
        List<Job> jobList=jobDao.findJobListByDeptId(Integer.valueOf(deptId));
        //设置返回
        //设置服务器端编码
        response.setCharacterEncoding("utf-8");
        //设置浏览器端解码
        response.setContentType("application/json;charset=utf-8");
        PrintWriter writer = response.getWriter();


//        List<Map<String, Object>> result = new ArrayList<>();
//        for (Job job:jobList){
//            Map<String, Object> map = new HashMap<>();
//            map.put("id",job.getId());
//            map.put("name",job.getName());
//            result.add(map);
//        }

//        String resultString = JSONArray.toJSONString(result);
//        writer.write(resultString);
        JSONArray jobJsonArray = new JSONArray();
        for (Job job:jobList){
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("id",job.getId());
            jsonObject.put("name",job.getName());
            jobJsonArray.add(jsonObject);
        }

        writer.write(jobJsonArray.toJSONString());
        writer.flush();
    }
}
