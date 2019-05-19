package dao;

import domain.User;
import erp.JDBC;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class userDaoImpl implements userDao {
    //登录
    @Override
    public boolean login(String User, String Password) {
        boolean flag = false;
        try {
            JDBC.getCon();
            ResultSet rs = JDBC.selectSql("select * from user_inf where loginname='" + User + "' AND password='" + Password + "' ");
            while (rs.next()) {
                if (rs.getString("loginname").equals(User) && rs.getString("password").equals(Password)) {
                    flag = true;
                }
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return flag;
    }

    //增加
    @Override
    public boolean add(User obj) {
        boolean flag = false;
        JDBC.getCon();
        String s = "insert into user_inf(loginname,password,createdate,username)" + " values(" +
                "'" + obj.getLoginname() + "','" + obj.getPassword() + "','" + obj.getCreatedate() + "','" + obj.getUsername() + "')";

//        int i = JDBC.addUpdDel(s);
//        System.out.println(i);
//        if (i > 0) {
//            flag = true;
//        }
//        JDBC.Close();
//        return flag;
        return JDBC.addUpdDel(s) > 0;
    }

    //删除
    @Override
    public boolean delete(int id) {
        boolean flag = false;
        JDBC.getCon();
        String sql = "delete from user_inf where id='" + id + "'";
        int i = JDBC.addUpdDel(sql);
        if (i > 0) {
            flag = true;
        }
        JDBC.Close();
        return flag;
    }

    @Override
    //改
    public boolean update(String loginname, String password, String createdate, String username, int id) {
        boolean flag = false;
        JDBC.getCon();
        String sql = "update user_inf set loginname='" + loginname
                + "',password='" + password
                + "',createdate='" + createdate
                + "',username='" + username + "' where id='" + id + "'";
        int i = JDBC.addUpdDel(sql);
        if (i > 0) {
            flag = true;
        }
        JDBC.Close();
        return flag;
    }

    @Override
    //查
    public ArrayList<User> findAll() {
        ArrayList<User> list = new ArrayList<>();
        try {
            JDBC.getCon();
            ResultSet rs = JDBC.selectSql("select * from user_inf");
            while (rs.next()) {
                User obj = new User();
                obj.setId(rs.getInt("id"));
                obj.setLoginname(rs.getString("loginname"));
                obj.setPassword(rs.getString("password"));
                obj.setCreatedate(rs.getString("createdate"));
                obj.setUsername(rs.getString("username"));
                list.add(obj);
            }
            JDBC.Close();
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public ArrayList<User> findName(String loginname) {
        ArrayList<User> listloginname = new ArrayList<>();
        try {
            JDBC.getCon();
            ResultSet rs = JDBC.selectSql("select * from user_inf where loginname='" + loginname + "'");
            while (rs.next()) {
                User obj = new User();
                obj.setId(rs.getInt("id"));
                obj.setLoginname(rs.getString("loginname"));
                obj.setPassword(rs.getString("password"));
                obj.setCreatedate(rs.getString("createdate"));
                obj.setUsername(rs.getString("username"));
                listloginname.add(obj);
            }
            JDBC.Close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listloginname;
    }
}
