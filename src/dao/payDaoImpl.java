package dao;

import domain.Pay;
import erp.JDBC;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class payDaoImpl implements payDao {
    @Override
    public boolean payAdd(Pay obj) {
        boolean flag = false;
        JDBC.getCon();
        String s = "insert into pay_inf(id,name,dept,job,month,sum,wuxian,shuihou,realpay)" + " values(" +
                "'" + obj.getId() +
                "','" + obj.getName() +
                "','" + obj.getDept() +
                "','" + obj.getJob() +
                "','" + obj.getMonth() +
                "','" + obj.getSum() +
                "','" + obj.getWuxian() +
                "','" + obj.getShuihou() +
                "','" + obj.getRealpay() + "')";
        int i = JDBC.addUpdDel(s);
        if (i > 0) {
            flag = true;
        }
        JDBC.Close();
        return flag;
    }

    @Override
    public ArrayList<Pay> findPayAll() {
        ArrayList<Pay> list = new ArrayList<>();
        try {
            JDBC.getCon();
            ResultSet rs = JDBC.selectSql("SELECT * FROM pay_inf");
            while (rs.next()) {
                Pay payobj = new Pay();
                payobj.setId(rs.getInt("id"));
                payobj.setName(rs.getString("name"));
                payobj.setDept(rs.getString("dept"));
                payobj.setJob(rs.getString("job"));
                payobj.setMonth(rs.getString("month"));
                payobj.setSum(rs.getDouble("sum"));
                payobj.setWuxian(rs.getDouble("wuxian"));
                payobj.setShuihou(rs.getDouble("shuihou"));
                payobj.setRealpay(rs.getDouble("realpay"));
                list.add(payobj);
            }
            JDBC.Close();
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public ArrayList<Pay> findPayByMonth(String month) {
        ArrayList<Pay> list = new ArrayList<>();
        try {
            JDBC.getCon();
            ResultSet rs = JDBC.selectSql("select * from pay_inf where month='" + month + "'");
            while (rs.next()) {
                Pay payobj = new Pay();
                payobj.setId(rs.getInt("id"));
                payobj.setName(rs.getString("name"));
                payobj.setDept(rs.getString("dept"));
                payobj.setJob(rs.getString("job"));
                payobj.setMonth(rs.getString("month"));
                payobj.setSum(rs.getDouble("sum"));
                payobj.setWuxian(rs.getDouble("wuxian"));
                payobj.setShuihou(rs.getDouble("shuihou"));
                payobj.setRealpay(rs.getDouble("realpay"));
                list.add(payobj);
            }
            JDBC.Close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public ArrayList<Pay> findPayById(int id) {
        ArrayList<Pay> list = new ArrayList<>();
        try {
            JDBC.getCon();
            ResultSet rs = JDBC.selectSql("select * from pay_inf where id='" + id + "'");
            while (rs.next()) {
                Pay payobj = new Pay();
                payobj.setId(rs.getInt("id"));
                payobj.setName(rs.getString("name"));
                payobj.setDept(rs.getString("dept"));
                payobj.setJob(rs.getString("job"));
                payobj.setMonth(rs.getString("month"));
                payobj.setSum(rs.getDouble("sum"));
                payobj.setWuxian(rs.getDouble("wuxian"));
                payobj.setShuihou(rs.getDouble("shuihou"));
                payobj.setRealpay(rs.getDouble("realpay"));
                list.add(payobj);
            }
            JDBC.Close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public boolean isOrNotHaveMonth(String month) {
        boolean flag = false;
        try {
            JDBC.getCon();
            ResultSet rs = JDBC.selectSql("SELECT * from pay_inf AS p WHERE p.`month`='" + month + "'");
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
