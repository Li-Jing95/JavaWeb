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
            ResultSet rs = JDBC.selectSql("SELECT e.id,e.`name`,e.sex,e.tel,e.email,d.`name` AS dept,j.name AS job, d.localpay ,j.jobpay ,(localpay+jobpay) AS sum " +
                    "FROM employee_inf AS e,dept_inf AS d, job_inf AS j " +
                    "WHERE e.dept_id=d.id AND e.job_id=j.id;");
            while (rs.next()) {
                Employee employeeobj = new Employee();
                employeeobj.setId(rs.getInt("id"));
                employeeobj.setName(rs.getString("name"));
                employeeobj.setSex(rs.getString("sex"));
                employeeobj.setTel(rs.getString("tel"));
                employeeobj.setEmail(rs.getString("email"));
                employeeobj.setDept(rs.getString("Dept"));
                employeeobj.setJob(rs.getString("job"));
                employeeobj.setLocalpay(rs.getString("localpay"));
                employeeobj.setJobpay(rs.getString("jobpay"));
                employeeobj.setSum(rs.getInt("sum"));
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
