package dao;

import domain.Dept;

import java.util.ArrayList;

public interface deptDao {
    boolean DeptAdd(Dept obj);//增

    boolean DeptDelete(int id);//删

    boolean DeptUpdate(String name, String remark, int id);//改

    ArrayList<Dept> findDeptAll();//查所有

    ArrayList findDeptByName(String name);//通过部门名字查找

    ArrayList<Dept> findNameAll();//显示部门名字，为添加岗位信息做准备

    boolean isOrNotjob(int id);//判断部门下是否有岗位



}
