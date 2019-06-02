package dao;

import domain.Job;

import java.util.ArrayList;

public interface jobDao {
    boolean JobAdd(Job deptobj);//增

    boolean JobDelete(int id);//删

    boolean JobUpdate(String name, String remark, int id);//改

    ArrayList<Job> findJobAll();//查

    ArrayList<Job> findJobName(String name);

    boolean findJobByName(String name);//通过岗位名字查找

    ArrayList<Job> findNameAll();

    ArrayList<Job> findJobListByDeptId(Integer deptId);

    boolean isOrNotHaveEmployee(int id);//判断岗位下是否有员工


}
