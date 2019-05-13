package dao;

import domain.Job;
import erp.JDBC;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class jobPayDaoImpl implements jobPayDao {
    @Override
    public boolean jobPayUpdate(int jobPay, int id) {
        boolean flag = false;
        JDBC.getCon();
        String sql = "update job_inf set " +
                "jobpay='" + jobPay +
                "' where id='" + id + "'";
        int i = JDBC.addUpdDel(sql);
        if (i > 0) {
            flag = true;
        }
        JDBC.Close();
        return flag;
    }

    @Override
    public ArrayList<Job> findjobPayAll() {
        ArrayList<Job> joblist = new ArrayList<>();
        try {
            JDBC.getCon();
            ResultSet rs = JDBC.selectSql("select * from job_inf");
            while (rs.next()) {
                Job jobobj = new Job();
                jobobj.setId(rs.getInt("id"));
                jobobj.setName(rs.getString("name"));
                jobobj.setRemark(rs.getString("remark"));
                jobobj.setJobpay(rs.getInt("jobpay"));
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
    public ArrayList<Job> findjobPayName(String name) {
        ArrayList<Job> listjobname = new ArrayList<>();
        try {
            JDBC.getCon();
            ResultSet rs = JDBC.selectSql("select * from job_inf where name='" + name + "'");
            while (rs.next()) {
                Job jobobj = new Job();
                jobobj.setId(rs.getInt("id"));
                jobobj.setName(rs.getString("name"));
                jobobj.setRemark(rs.getString("remark"));
                jobobj.setJobpay(rs.getInt("jobpay"));
                listjobname.add(jobobj);
            }
            JDBC.Close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listjobname;
    }
}

