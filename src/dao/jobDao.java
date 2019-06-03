package dao;

import domain.Job;

import java.util.ArrayList;

public interface jobDao {
    boolean jobAddByName(String name);//添加岗位之前先查看数据库中时候存在（经理岗位只能有一个）

    boolean JobAdd(Job deptobj);//增

    boolean JobDelete(int id);//删

    boolean JobUpdate(String name, String remark, int id);//改

    ArrayList<Job> findJobAll();//查

    ArrayList<Job> findJobName(String name);//通过查找岗位名显示数据

    boolean findJobByName(String name);//通过岗位名字查找数据库中是否存在

    ArrayList<Job> findNameAll();

    ArrayList<Job> findJobListByDeptId(Integer deptId);

    boolean isOrNotHaveEmployee(int id);//判断岗位下是否有员工


}
