package dao;

import domain.Pay;

import java.util.ArrayList;

public interface payDao {
    boolean payAdd(Pay obj);//增

    ArrayList<Pay> findPayAll();

    ArrayList<Pay> findPayByMonth();//通过月份查
}
