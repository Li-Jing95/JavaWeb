package dao;

import domain.Dept;
import domain.Employee;
import domain.Job;

import java.util.ArrayList;

public interface ordinaryDao {
    boolean ordLogin(String loginname, String password);

    ArrayList<Dept> ordFindDeptAll();//查所有部门

    ArrayList<Job> ordFindJobAll();//岗位

    ArrayList<Employee> ordFindEmployeeAll();//员工
}
