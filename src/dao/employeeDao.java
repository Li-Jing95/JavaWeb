package dao;

import domain.Employee;

import java.util.ArrayList;

public interface employeeDao {
    boolean EmployeeAdd(Employee deptobj);//增

    boolean EmployeeDelete(int id);//删 删除员工信息也删除账号密码信息

    boolean employeeDeleteById(int id);//删除员工信息

    boolean EmployeeUpdate(String name, String sex, String nation, String polic, String born, String tel, String email, String education, String card_id, String createdate, int id);//改

    ArrayList<Employee> findEmployeeAll();//查

    boolean findEmployeeByName(String name);//通过名字查找查看是否存在此数据

    ArrayList<Employee> findEmployeeName(String name);//通过名字查找

    ArrayList<Employee> findEmployeeJobId(int id);

    ArrayList<Employee> findEmployeeOkJobListAll();//员工岗位列表

    boolean employeeOkJobUpdate(int id, int dept_id, int job_id);

    ArrayList<Employee> findManOrWomanAll();//男女比例

    ArrayList<Employee> findEducationalAll();//学历层次

    ArrayList<Employee> findPoliticalAll();//政治层次

    ArrayList<Employee> findEmployeePayById(int id);//通过id值查找用户薪资信息

    ArrayList<Employee> findEmployeeById(int id);//通过id值显示员工信息

    boolean isOrNotId(int loginname);//入库之前先查看库中是否存在此数据

    boolean idAdd(int id);//入库

    ArrayList<Employee> findMyInfById(int id);//通过登录名查找自己信息

    boolean isOrNotTel(String tel, String card_id);//添加信息前查看数据库中的电话是否已经存在
}
