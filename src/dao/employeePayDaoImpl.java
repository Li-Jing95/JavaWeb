package dao;

import domain.Employee;
import erp.JDBC;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class employeePayDaoImpl implements employeePayDao {
    @Override
    public ArrayList<Employee> findEmployeePayAll() {
        ArrayList<Employee> employeepaylist = new ArrayList<>();
        try {
            JDBC.getCon();
            ResultSet rs = JDBC.selectSql("SELECT e.id,e.`name`,e.sex,e.card_id, d.`name` AS dept ,j.name AS job,d.localpay AS localpay,j.jobpay AS jobpay,localpay+jobpay AS sum,e.createdate\n" +
                    "FROM employee_inf AS e,dept_inf AS d,job_inf AS j \n" +
                    "WHERE e.dept_id=d.emp_id AND e.job_id= j.emp_id;");
            while (rs.next()) {
                Employee employeeobj = new Employee();
                employeeobj.setId(rs.getInt("id"));
                employeeobj.setName(rs.getString("name"));
                employeeobj.setSex(rs.getString("sex"));
                employeeobj.setCard_id(rs.getString("card_id"));
                employeeobj.setDept(rs.getString("dept"));
                employeeobj.setJob(rs.getString("job"));
                employeeobj.setLocalpay(rs.getString("localpay"));
                employeeobj.setJobpay(rs.getString("jobpay"));
                employeeobj.setSum(rs.getInt("sum"));
                employeeobj.setCreatedate(rs.getString("createdate"));
                employeepaylist.add(employeeobj);
            }
            JDBC.Close();
            return employeepaylist;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;

    }
}
