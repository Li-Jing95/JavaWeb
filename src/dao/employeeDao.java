package dao;

import domain.Dept;
import domain.Employee;
import domain.Job;

import java.util.ArrayList;

public interface employeeDao {
    boolean EmployeeAdd(Employee deptobj);//增

    boolean EmployeeDelete(int id);//删

    boolean EmployeeUpdate(String name, String sex,String nation,String polic,String born, String tel, String email, String education, String card_id, String createdate, int id);//改

    ArrayList<Employee> findEmployeeAll();//查

    ArrayList findEmployeeName(String name);//通过名字查找
//    ArrayList<Dept> findDept();
//    ArrayList<Job> findJob();
}
