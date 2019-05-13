package dao;

import domain.User;

import java.util.ArrayList;

public interface userDao {
    boolean login(String User, String Password);//登录

    boolean add(User obj);//增

    boolean delete(int id);//删

    boolean update(String loginname, String password, String createdate, String username, int id);//改

    ArrayList<User> findAll();//查

    ArrayList findName(String name);//通过登录名查找

}
