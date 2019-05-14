package dao;

import domain.Dept;
import domain.Employee;
import domain.Job;
import erp.JDBC;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class employeeDaoImpl implements employeeDao {

    //增
    @Override
    public boolean EmployeeAdd(Employee obj) {
        boolean flag = false;
        JDBC.getCon();
        String s = "insert into employee_inf(name,sex,nation,polic,born,tel,email,education,card_id,createdate)" + " values(" +
                "'" + obj.getName() +
                "','" + obj.getSex() +
                "','" + obj.getNation() +
                "','" + obj.getPolic() +
                "','" + obj.getBorn() +
                "','" + obj.getTel() +
                "','" + obj.getEmail() +
                "','" + obj.getEducation() +
                "','" + obj.getCard_id() +
                "','" + obj.getCreatedate() + "')";
        int i = JDBC.addUpdDel(s);
        if (i > 0) {
            flag = true;
        }
        JDBC.Close();
        return flag;
    }

    @Override
    public boolean EmployeeDelete(int id) {
        boolean flag = false;
        JDBC.getCon();
        String sql = "delete from employee_inf where id='" + id + "'";
        int i = JDBC.addUpdDel(sql);
        if (i > 0) {
            flag = true;
        }
        JDBC.Close();
        return flag;
    }

    @Override
    public boolean EmployeeUpdate(String name, String sex, String nation,String polic,String born,String tel, String email, String education, String card_id, String createdate, int id) {
        boolean flag = false;
        JDBC.getCon();
        String sql = "update employee_inf set " +
                "name='" + name +
                "',sex='" + sex +
                "',nation='" + nation +
                "',polic='" + polic +
                "',born='" + born +
                "',tel='" + tel +
                "',email='" + email +
                "',education='" + education +
                "',card_id='" + card_id +
                "',createdate='" + createdate +
                "' where id='" + id + "'";
        int i = JDBC.addUpdDel(sql);
        if (i > 0) {
            flag = true;
        }
        JDBC.Close();
        return flag;
    }

    @Override
    public ArrayList<Employee> findEmployeeAll() {
        ArrayList<Employee> employeelist = new ArrayList<>();
        try {
            JDBC.getCon();
            ResultSet rs = JDBC.selectSql("SELECT * from employee_inf");
            while (rs.next()) {
                Employee employeeobj = new Employee();
                employeeobj.setId(rs.getInt("id"));
                employeeobj.setName(rs.getString("name"));
                employeeobj.setSex(rs.getString("sex"));
                employeeobj.setNation(rs.getString("nation"));
                employeeobj.setPolic(rs.getString("polic"));
                employeeobj.setBorn(rs.getString("born"));
                employeeobj.setTel(rs.getString("tel"));
                employeeobj.setEmail(rs.getString("email"));
                employeeobj.setEducation(rs.getString("education"));
                employeeobj.setCard_id(rs.getString("card_id"));
                employeeobj.setCreatedate(rs.getString("createdate"));
                employeelist.add(employeeobj);
            }
            JDBC.Close();
            return employeelist;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public ArrayList findEmployeeName(String name) {
        ArrayList<Employee> list = new ArrayList<>();
        try {
            JDBC.getCon();
            ResultSet rs = JDBC.selectSql("SELECT * FROM " +
                    "(SELECT e.id,e.`name`,e.sex,e.tel,e.email,j.`name` AS job,e.education,e.card_id,d.`name` AS dept,e.createdate FROM employee_inf AS e,dept_inf AS d ,job_inf AS j WHERE e.dept_id=d.emp_id AND e.job_id=j.emp_id) AS aaa " +
                    "WHERE aaa.`name`='" + name + "'");

            while (rs.next()) {
                Employee employeeobj = new Employee();
                employeeobj.setId(rs.getInt("id"));
                employeeobj.setName(rs.getString("name"));
                employeeobj.setSex(rs.getString("sex"));
                employeeobj.setTel(rs.getString("tel"));
                employeeobj.setEmail(rs.getString("email"));
                employeeobj.setJob(rs.getString("job"));
                employeeobj.setEducation(rs.getString("education"));
                employeeobj.setCard_id(rs.getString("card_id"));
                employeeobj.setDept(rs.getString("dept"));
                employeeobj.setCreatedate(rs.getString("createdate"));
                list.add(employeeobj);
            }
            JDBC.Close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public ArrayList<Employee> findEmployeeJob() {
        ArrayList<Employee> list = new ArrayList<>();
        try {
            JDBC.getCon();
            ResultSet rs = JDBC.selectSql("SELECT e.id,e.`name`,d.`name` AS dept,j.`name` AS job " +
                    "FROM employee_inf AS e,dept_inf AS d,job_inf AS j " +
                    "WHERE e.dept_id=d.id AND e.job_id=j.id;");
            while (rs.next()) {
                Employee employeeobj = new Employee();
                employeeobj.setId(rs.getInt("id"));
                employeeobj.setName(rs.getString("name"));
                employeeobj.setJob(rs.getString("job"));
                employeeobj.setDept(rs.getString("dept"));
                list.add(employeeobj);
            }
            JDBC.Close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public ArrayList<Employee> findEmployeeJobId(int id) {
        ArrayList<Employee> list = new ArrayList<>();
        try {
            JDBC.getCon();
            ResultSet rs = JDBC.selectSql("SELECT e.id,e.`name`,d.`name` AS dept,j.`name` AS job " +
                    "FROM employee_inf AS e,dept_inf AS d,job_inf AS j " +
                    "WHERE e.dept_id=d.id AND e.job_id=j.id AND e.id='" + id + "'");
            while (rs.next()) {
                Employee employeeobj = new Employee();
                employeeobj.setId(rs.getInt("id"));
                employeeobj.setName(rs.getString("name"));
                employeeobj.setJob(rs.getString("job"));
                employeeobj.setDept(rs.getString("dept"));
                list.add(employeeobj);
            }
            JDBC.Close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

}
