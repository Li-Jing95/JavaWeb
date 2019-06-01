package dao;

import domain.Pay;

import java.util.ArrayList;

public interface payDao {
    boolean payAdd(Pay obj);//增

    ArrayList<Pay> findPayAll();//查看所有实发薪资

    ArrayList<Pay> findPayByMonth(String month);//通过月份查实发薪资

    ArrayList<Pay> findPayById(int id);//用户 通过编号查看薪资

    boolean isOrNotHaveMonth(String month, int id);//在实发薪资插入到数据库之前先判断此月工资是否已存在
}
