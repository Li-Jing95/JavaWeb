package dao;

import domain.Job;

import java.util.ArrayList;

public interface jobDao {
    boolean JobAdd(Job deptobj);//增

    boolean JobDelete(int id);//删

    boolean JobUpdate(String name, String remark, int id);//改

    ArrayList<Job> findJobAll();//查

    ArrayList findJobName(String name);//通过部门名字查找
    ArrayList<Job> findNameAll();
}
