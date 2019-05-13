package dao;

import domain.Dept;

import java.util.ArrayList;

public interface localPayDao {
    boolean localPayUpdate(int localPay, int id);//改

    ArrayList<Dept> findlocalPayAll();//查

    ArrayList<Dept> findlocalPayName(String name);//按部门名字查

}
