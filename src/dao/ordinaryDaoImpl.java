package dao;

import domain.Dept;
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
    public boolean miMaUpdate(String psd) {
        boolean flag = false;
        JDBC.getCon();
        String sql = "update orduser_inf set password='" + psd + "'";
        int i = JDBC.addUpdDel(sql);
        if (i > 0) {
            flag = true;
        }
        JDBC.Close();
        return flag;
    }

}
