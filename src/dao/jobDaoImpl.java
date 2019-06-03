package dao;

import domain.Job;
import erp.JDBC;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class jobDaoImpl implements jobDao {

    @Override
    public boolean jobAddByName(String name) {
        boolean flag = false;
        try {
            JDBC.getCon();
            ResultSet rs = JDBC.selectSql("SELECT * FROM job_inf WHERE job_inf.`name` LIKE'" + name + "';");
            while (rs.next()) {
                flag = true;
            }
            JDBC.Close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return flag;
    }

    @Override
    public boolean JobAdd(Job obj) {
        boolean flag = false;
        JDBC.getCon();
        String s = "insert into job_inf(name,remark,dept_id)" + " values(" +
                "'" + obj.getName() +
                "','" + obj.getRemark() +
                "','" + obj.getDept_id() + "')";

        int i = JDBC.addUpdDel(s);
        if (i > 0) {
            flag = true;
        }
        JDBC.Close();
        return flag;
    }

    @Override
    public boolean JobDelete(int id) {
        boolean flag = false;
        JDBC.getCon();
        String sql = "delete from job_inf where id='" + id + "'";
        int i = JDBC.addUpdDel(sql);
        if (i > 0) {
            flag = true;
        }
        JDBC.Close();
        return flag;
    }

    @Override
    public boolean JobUpdate(String name, String remark, int id) {
        boolean flag = false;
        JDBC.getCon();
        String sql = "update job_inf set name='" + name
                + "',remark='" + remark + "' where id='" + id + "'";
        int i = JDBC.addUpdDel(sql);
        if (i > 0) {
            flag = true;
        }
        JDBC.Close();
        return flag;
    }

    @Override
    public ArrayList<Job> findJobAll() {
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
    public boolean findJobByName(String name) {
        boolean flag = false;
        try {
            JDBC.getCon();
//            ResultSet rs = JDBC.selectSql("select id,`name`,remark from job_inf where name='" + name + "'");
            ResultSet rs = JDBC.selectSql("select id,`name`,remark from job_inf where name like'%" + name + "%'");
            while (rs.next()) {
                flag = true;
            }
            JDBC.Close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return flag;
    }

    @Override
    public ArrayList<Job> findJobName(String name) {
        ArrayList<Job> listjobname = new ArrayList<>();
        try {
            JDBC.getCon();
//            ResultSet rs = JDBC.selectSql("select id,`name`,remark from job_inf where name='" + name + "'");
            ResultSet rs = JDBC.selectSql("select id,`name`,remark from job_inf where name like'%" + name + "%'");
            while (rs.next()) {
                Job jobobj = new Job();
                jobobj.setId(rs.getInt("id"));
                jobobj.setName(rs.getString("name"));
                jobobj.setRemark(rs.getString("remark"));
                listjobname.add(jobobj);
            }
            JDBC.Close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listjobname;
    }

    @Override
    public ArrayList<Job> findNameAll() {
        ArrayList<Job> listjobname = new ArrayList<>();
        try {
            JDBC.getCon();
            ResultSet rs = JDBC.selectSql("SELECT j.`name` FROM dept_inf AS d ,job_inf AS j WHERE d.id=j.id;");
            while (rs.next()) {
                Job jobobj = new Job();
//                jobobj.setId(rs.getInt("id"));
                jobobj.setName(rs.getString("name"));
                listjobname.add(jobobj);
            }
            JDBC.Close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listjobname;
    }

    @Override
    public ArrayList<Job> findJobListByDeptId(Integer deptId) {
        ArrayList<Job> listjobname = new ArrayList<>();
        try {
            JDBC.getCon();
            ResultSet rs = JDBC.selectSql("select id,`name`,remark from job_inf where dept_id='" + deptId + "'");
            while (rs.next()) {
                Job jobobj = new Job();
                jobobj.setId(rs.getInt("id"));
                jobobj.setName(rs.getString("name"));
                jobobj.setRemark(rs.getString("remark"));
                listjobname.add(jobobj);
            }
            JDBC.Close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listjobname;
    }

    @Override
    public boolean isOrNotHaveEmployee(int id) {
        boolean flag = false;
        try {
            JDBC.getCon();
            ResultSet rs = JDBC.selectSql("SELECT * FROM (SELECT j.id,COUNT(*) from job_inf AS j inner JOIN employee_inf AS e ON j.id=e.job_id GROUP BY j.id) AS a WHERE a.id=" + id + ";");
            while (rs.next()) {
                flag = true;
            }
            JDBC.Close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return flag;
    }
}
