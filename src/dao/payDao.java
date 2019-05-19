package dao;

import domain.Pay;

import java.util.ArrayList;

public interface payDao {
    boolean payAdd(Pay obj);//增

    ArrayList<Pay> findPayAll();

    ArrayList<Pay> findPayByMonth(String month);//通过月份查

    ArrayList<Pay> findPayById(int id);//用户 通过编号查看自己的薪资
}
