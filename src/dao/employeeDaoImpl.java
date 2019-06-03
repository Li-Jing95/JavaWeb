package dao;

import domain.Employee;
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

        String s = "insert into employee_inf(name,sex,nation,polic,born,tel,email,education,card_id,dept_id,job_id,createdate)" + " values(" +
                "'" + obj.getName() +
                "','" + obj.getSex() +
                "','" + obj.getNation() +
                "','" + obj.getPolic() +
                "','" + obj.getBorn() +
                "','" + obj.getTel() +
                "','" + obj.getEmail() +
                "','" + obj.getEducation() +
                "','" + obj.getCard_id() +
                "','" + obj.getDept_id() +
                "','" + obj.getJob_id() +
                "','" + obj.getCreatedate() + "')";
//        int i = JDBC.addUpdDel(s);
//        if (i > 0) {
//            flag = true;
//        }
//        JDBC.Close();
//        return flag;
        return JDBC.addUpdDel(s) > 0;
    }

    @Override
    public boolean EmployeeDelete(int id) {
        boolean flag = false;
        JDBC.getCon();
//        String sql = "delete from employee_inf where id='" + id + "'";
        String sql = "DELETE employee_inf ,orduser_inf FROM employee_inf ,orduser_inf  " +
                "WHERE employee_inf.id=orduser_inf.loginname AND employee_inf.id='" + id + "';";
        int i = JDBC.addUpdDel(sql);
        if (i > 0) {
            flag = true;
        }
        JDBC.Close();
        return flag;
    }

    @Override
    public boolean employeeDeleteById(int id) {
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
    public boolean EmployeeUpdate(String name, String sex, String nation, String polic, String born, String tel, String email, String education, String card_id, String createdate, int id) {
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
            ResultSet rs = JDBC.selectSql("SELECT e.id,e.`name`,e.sex,e.nation,e.polic,e.born,e.tel,e.email,e.education,e.card_id,d.`name` AS dept,j.`name` AS job,e.createdate " +
                    "FROM employee_inf AS e , dept_inf AS d, job_inf AS j " +
                    "WHERE e.dept_id=d.id AND e.job_id=j.id;");
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
                employeeobj.setDept(rs.getString("dept"));
                employeeobj.setJob(rs.getString("job"));
                employeeobj.setCreatedate(rs.getString("createdate"));
                employeelist.add(employeeobj);
            }
            JDBC.Close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employeelist;
    }

    @Override
    public boolean findEmployeeByName(String name) {
        boolean flag = false;
        try {
            JDBC.getCon();
            ResultSet rs = JDBC.selectSql("SELECT e.id,e.`name`,e.sex,e.nation,e.polic,e.born,e.tel,e.email,e.education,e.card_id,d.`name` AS dept,j.`name` AS job,e.createdate\n" +
                    "FROM employee_inf AS e , dept_inf AS d, job_inf AS j\n" +
                    "WHERE e.dept_id=d.id AND e.job_id=j.id AND e.`name`='" + name + "' ");
            while (rs.next()) {
                flag = true;
            }
            JDBC.Close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return flag;
    }

    @Override
    public ArrayList<Employee> findEmployeeName(String name) {
        ArrayList<Employee> list = new ArrayList<>();
        try {
            JDBC.getCon();
            ResultSet rs = JDBC.selectSql("SELECT e.id,e.`name`,e.sex,e.nation,e.polic,e.born,e.tel,e.email,e.education,e.card_id,d.`name` AS dept,j.`name` AS job,e.createdate\n" +
                    "FROM employee_inf AS e , dept_inf AS d, job_inf AS j\n" +
                    "WHERE e.dept_id=d.id AND e.job_id=j.id AND e.`name`='" + name + "' ");
            while (rs.next()) {
                Employee employeeobj = new Employee();
                employeeobj.setName(rs.getString("name"));
                employeeobj.setId(rs.getInt("id"));
                employeeobj.setSex(rs.getString("sex"));
                employeeobj.setNation(rs.getString("nation"));
                employeeobj.setPolic(rs.getString("polic"));
                employeeobj.setBorn(rs.getString("born"));
                employeeobj.setTel(rs.getString("tel"));
                employeeobj.setEmail(rs.getString("email"));
                employeeobj.setEducation(rs.getString("education"));
                employeeobj.setCard_id(rs.getString("card_id"));
                employeeobj.setDept(rs.getString("dept"));
                employeeobj.setJob(rs.getString("job"));
                employeeobj.setCreatedate(rs.getString("createdate"));
                list.add(employeeobj);
            }
            JDBC.Close();
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public ArrayList<Employee> findEmployeeJobId(int id) {
        ArrayList<Employee> list = new ArrayList<>();
        try {
            JDBC.getCon();
            ResultSet rs = JDBC.selectSql("SELECT e.id,e.`name`,d.`name` AS dept,j.`name` AS job " +
                    "FROM employee_inf AS e , dept_inf AS d, job_inf AS j " +
                    "WHERE e.dept_id=d.id AND e.job_id=j.id AND e.id='" + id + "'");
            while (rs.next()) {
                Employee employeeobj = new Employee();
                employeeobj.setId(rs.getInt("id"));
                employeeobj.setName(rs.getString("name"));
                employeeobj.setDept(rs.getString("dept"));
                employeeobj.setJob(rs.getString("job"));
                list.add(employeeobj);
            }
            JDBC.Close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public ArrayList<Employee> findEmployeeOkJobListAll() {
        ArrayList<Employee> list = new ArrayList<>();
        try {
            JDBC.getCon();
            ResultSet rs = JDBC.selectSql("SELECT * from employeejob_inf");
            while (rs.next()) {
                Employee employeeobj = new Employee();
                employeeobj.setId(rs.getInt("id"));
                employeeobj.setName(rs.getString("name"));
                employeeobj.setDept_id(rs.getInt("dept_id"));

                employeeobj.setJob_id(rs.getInt("job_id"));
                list.add(employeeobj);
            }
            JDBC.Close();
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean employeeOkJobUpdate(int id, int dept_id, int job_id) {
        boolean flag = false;
        JDBC.getCon();
        String sql = "update employee_inf set " +
                "dept_id='" + dept_id +
                "',job_id='" + job_id +
                "' where id='" + id + "'";
        int i = JDBC.addUpdDel(sql);
        if (i > 0) {
            flag = true;
        }
        JDBC.Close();
        return flag;
    }

    @Override
    public ArrayList<Employee> findManOrWomanAll() {
        ArrayList<Employee> list = new ArrayList<>();
        try {
            JDBC.getCon();
//            ResultSet rs = JDBC.selectSql("SELECT e.sex ,COUNT(e.sex) AS count FROM employee_inf AS e GROUP BY sex;");
            ResultSet rs = JDBC.selectSql("SELECT e.sex,(ROUND(COUNT(e.sex)/(SELECT COUNT(*)FROM employee_inf)*100,1)) AS count " +
                    "FROM employee_inf AS e GROUP BY sex;");
            while (rs.next()) {
                Employee employeeobj = new Employee();
                employeeobj.setSex(rs.getString("sex"));
                employeeobj.setCount(rs.getFloat("count"));
                list.add(employeeobj);
            }
            JDBC.Close();
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public ArrayList<Employee> findEducationalAll() {
        ArrayList<Employee> list = new ArrayList<>();
        try {
            JDBC.getCon();
//            ResultSet rs = JDBC.selectSql("SELECT e.sex ,COUNT(e.sex) AS count FROM employee_inf AS e GROUP BY sex;");
            ResultSet rs = JDBC.selectSql("SELECT e.education,(ROUND(COUNT(e.education)/(SELECT COUNT(*)FROM employee_inf)*100,1)) AS count\n" +
                    "FROM employee_inf AS e GROUP BY education;");
            while (rs.next()) {
                Employee employeeobj = new Employee();
                employeeobj.setEducation(rs.getString("education"));
                employeeobj.setCount(rs.getFloat("count"));
                list.add(employeeobj);
            }
            JDBC.Close();
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public ArrayList<Employee> findPoliticalAll() {
        ArrayList<Employee> list = new ArrayList<>();
        try {
            JDBC.getCon();
//            ResultSet rs = JDBC.selectSql("SELECT e.sex ,COUNT(e.sex) AS count FROM employee_inf AS e GROUP BY sex;");
            ResultSet rs = JDBC.selectSql("SELECT e.polic,(ROUND(COUNT(e.polic)/(SELECT COUNT(*)FROM employee_inf)*100,1)) AS count\n" +
                    "FROM employee_inf AS e GROUP BY polic;");
            while (rs.next()) {
                Employee employeeobj = new Employee();
                employeeobj.setPolic(rs.getString("polic"));
                employeeobj.setCount(rs.getInt("count"));
                list.add(employeeobj);
            }
            JDBC.Close();
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public ArrayList<Employee> findEmployeePayById(int id) {
        ArrayList<Employee> list = new ArrayList<>();
        try {
            JDBC.getCon();
            ResultSet rs = JDBC.selectSql("SELECT e.id,e.`name`,d.`name` AS dept,j.name AS job,(localpay+jobpay) AS sum FROM employee_inf AS e,dept_inf AS d, job_inf AS j " +
                    "WHERE e.dept_id=d.id AND e.job_id=j.id AND e.id='" + id + "'");
            while (rs.next()) {
                Employee employeeobj = new Employee();
                employeeobj.setName(rs.getString("name"));
                employeeobj.setDept(rs.getString("dept"));
                employeeobj.setJob(rs.getString("job"));
                employeeobj.setSum(rs.getInt("sum"));
                employeeobj.setId(rs.getInt("id"));
                list.add(employeeobj);
            }
            JDBC.Close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public ArrayList<Employee> findEmployeeById(int id) {
        ArrayList<Employee> list = new ArrayList<>();
        try {
            JDBC.getCon();
            ResultSet rs = JDBC.selectSql("SELECT id,`name`,sex,nation,polic,born,tel,email,education,card_id,createdate " +
                    "FROM employee_inf " +
                    "WHERE id='" + id + "'");
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
                list.add(employeeobj);
            }
            JDBC.Close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public boolean isOrNotId(int loginname) {
        boolean flag = false;
        try {
            JDBC.getCon();
            //ResultSet rs = JDBC.selectSql("SELECT loginname FROM orduser_inf WHERE loginname='201917'");
            ResultSet rs = JDBC.selectSql("select loginname from orduser_inf where loginname='" + loginname + "'");
            while (rs.next()) {
                flag = true;
            }
            JDBC.Close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return flag;
    }

    @Override
    public boolean idAdd(int id) {
        boolean flag = false;
        JDBC.getCon();
        String s = "INSERT INTO orduser_inf(loginname,password)" + "VALUES(" +
                "'" + id +
                "','888')";
        int i = JDBC.addUpdDel(s);
        if (i > 0) {
            flag = true;
        }
        JDBC.Close();
        return flag;
    }

    @Override
    public ArrayList<Employee> findMyInfById(int id) {
        ArrayList<Employee> list = new ArrayList<>();
        try {
            JDBC.getCon();
            ResultSet rs = JDBC.selectSql("SELECT e.id,e.`name`,e.sex,e.nation,e.polic,e.born,e.tel,e.email,e.education,e.card_id,d.`name` AS dept,j.`name` AS job,e.createdate\n" +
                    "FROM employee_inf AS e , dept_inf AS d, job_inf AS j\n" +
                    "WHERE e.dept_id=d.id AND e.job_id=j.id AND e.`id`='" + id + "'");
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
                employeeobj.setDept(rs.getString("dept"));
                employeeobj.setJob(rs.getString("job"));
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
    public boolean isOrNotTel(String tel, String card_id) {
        boolean flag = false;
        try {
            JDBC.getCon();
            //ResultSet rs = JDBC.selectSql("SELECT loginname FROM orduser_inf WHERE loginname='201917'");
            ResultSet rs = JDBC.selectSql("select tel,card_id from employee_inf where tel='" + tel + "' OR card_id='" + card_id + "' ");
            while (rs.next()) {
                flag = true;
            }
            JDBC.Close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return flag;
    }
}
