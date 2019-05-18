package dao;

import domain.Dept;
import domain.Employee;
import domain.Job;
import erp.JDBC;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ordinaryDaoImpl implements ordinaryDao {
    @Override
    public boolean ordLogin(String login, String psd) {
        boolean flag = false;
        try {
            JDBC.getCon();
            ResultSet rs = JDBC.selectSql("select * from orduser_inf where loginname='" + login + "' AND password='" + psd + "' ");
            while (rs.next()) {
                if (rs.getString("loginname").equals(login) && rs.getString("password").equals(psd)) {
                    flag = true;
                }
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return flag;
    }

    @Override
    public ArrayList<Dept> ordFindDeptAll() {
        ArrayList<Dept> deptlist = new ArrayList<>();
        try {
            JDBC.getCon();
            ResultSet rs = JDBC.selectSql("select id,`name`,remark from dept_inf");
            while (rs.next()) {
                Dept deptobj = new Dept();
                deptobj.setId(rs.getInt("id"));
                deptobj.setName(rs.getString("name"));
                deptobj.setRemark(rs.getString("remark"));
                deptlist.add(deptobj);
            }
            JDBC.Close();
            return deptlist;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public ArrayList<Job> ordFindJobAll() {
        ArrayList<Job> joblist = new ArrayList<>();
        try {
            JDBC.getCon();
            ResultSet rs = JDBC.selectSql("select id,`name`,remark from job_inf");
            while (rs.next()) {
                Job jobobj = new Job();
                jobobj.setId(rs.getInt("id"));
                jobobj.setName(rs.getString("name"));
                jobobj.setRemark(rs.getString("remark"));
                joblist.add(jobobj);
            }
            JDBC.Close();
            return joblist;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public ArrayList<Employee> ordFindEmployeeAll() {
        ArrayList<Employee> employeelist = new ArrayList<>();
        try {
            JDBC.getCon();
            ResultSet rs = JDBC.selectSql("SELECT e.id,e.`name`,e.sex,e.nation,e.tel,e.email,e.education,d.`name` AS dept,j.`name` AS job" +
                    "FROM employee_inf AS e , dept_inf AS d, job_inf AS j" +
                    "WHERE e.dept_id=d.id AND e.job_id=j.id;");
            while (rs.next()) {
                Employee employeeobj = new Employee();
                employeeobj.setId(rs.getInt("id"));
                employeeobj.setName(rs.getString("name"));
                employeeobj.setSex(rs.getString("sex"));
                employeeobj.setNation(rs.getString("nation"));
                employeeobj.setTel(rs.getString("tel"));
                employeeobj.setEmail(rs.getString("email"));
                employeeobj.setEducation(rs.getString("education"));
                employeeobj.setDept(rs.getString("dept"));
                employeeobj.setJob(rs.getString("job"));
                employeelist.add(employeeobj);
            }
            JDBC.Close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employeelist;
    }
}
