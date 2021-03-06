package dao;

import domain.Dept;
import erp.JDBC;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class deptDaoImpl implements deptDao {

    @Override
    public boolean DeptAdd(Dept obj) {
        boolean flag = false;
        JDBC.getCon();
        String s = "insert into dept_inf(name,remark)" + " values(" +
                "'" + obj.getName() + "','" + obj.getRemark() + "')";
        int i = JDBC.addUpdDel(s);
        if (i > 0) {
            flag = true;
        }
        System.out.println(i);
        JDBC.Close();
        return flag;
    }

    @Override
    public boolean DeptDelete(int id) {
        boolean flag = false;
        JDBC.getCon();
//        String sql = "DELETE d.*, j.* FROM dept_inf as d INNER JOIN job_inf AS j ON d.id=j.id where d.id='"+id+"'";
        String sql = "Delete  from dept_inf where id=" + id + "";
        int i = JDBC.addUpdDel(sql);
        if (i > 0) {
            flag = true;
        }
        JDBC.Close();
        return flag;
    }

    @Override
    public boolean DeptUpdate(String name, String remark, int id) {
        boolean flag = false;
        JDBC.getCon();
        String sql = "update dept_inf set name='" + name
                + "',remark='" + remark + "' where id='" + id + "'";
        int i = JDBC.addUpdDel(sql);
        if (i > 0) {
            flag = true;
        }
        JDBC.Close();
        return flag;
    }

    @Override
    public ArrayList<Dept> findDeptAll() {
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
    public boolean findDeptByName(String name) {
        boolean flag = false;
        try {
            JDBC.getCon();
            ResultSet rs = JDBC.selectSql("select * from dept_inf where name like'%" + name + "%'");
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
    public ArrayList<Dept> findDeptName(String name) {
        ArrayList<Dept> listdeptname = new ArrayList<>();
        try {
            JDBC.getCon();
            ResultSet rs = JDBC.selectSql("select id,`name`,remark from dept_inf where name like'%" + name + "%'");
            while (rs.next()) {
                Dept deptobj = new Dept();
                deptobj.setId(rs.getInt("id"));
                deptobj.setName(rs.getString("name"));
                deptobj.setRemark(rs.getString("remark"));
                listdeptname.add(deptobj);
            }
            JDBC.Close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listdeptname;
    }

    @Override
    public ArrayList<Dept> findNameAll() {
        ArrayList<Dept> list = new ArrayList<>();
        try {
            JDBC.getCon();
            ResultSet rs = JDBC.selectSql("select id,NAME FROM dept_inf;");
            while (rs.next()) {
                Dept deptobj = new Dept();
                deptobj.setId(rs.getInt("id"));
                deptobj.setName(rs.getString("name"));
                list.add(deptobj);
            }
            JDBC.Close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public boolean isOrNotjob(int id) {
        boolean flag = false;
        try {
            JDBC.getCon();
            ResultSet rs = JDBC.selectSql("SELECT * FROM (SELECT d.id,COUNT(*) from dept_inf AS d inner JOIN job_inf AS j ON d.id=j.dept_id GROUP BY d.id) AS a WHERE a.id=" + id + ";");
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
