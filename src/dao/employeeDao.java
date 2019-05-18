package dao;

import domain.Employee;

import java.util.ArrayList;

public interface employeeDao {
    boolean EmployeeAdd(Employee deptobj);//增

    boolean EmployeeDelete(int id);//删

    boolean EmployeeUpdate(String name, String sex,String nation,String polic,String born, String tel, String email, String education, String card_id, String createdate, int id);//改

    ArrayList<Employee> findEmployeeAll();//查

    ArrayList<Employee> findEmployeeByName(String name);//通过名字查找

    ArrayList<Employee> findEmployeeJobId(int id);

    ArrayList<Employee> findEmployeeOkJobListAll();//员工岗位列表

    boolean employeeOkJobUpdate(int id,int dept_id,int job_id);

    ArrayList<Employee> findManOrWomanAll();//男女比例

    ArrayList<Employee> findEducationalAll();//学历层次

    ArrayList<Employee> findPoliticalAll();//政治层次

    ArrayList<Employee> findEmployeePayById(int id);//通过id值查找用户薪资信息

    ArrayList<Employee> findEmployeeById(int id);//通过id值显示员工信息

}
