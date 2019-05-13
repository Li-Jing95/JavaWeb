package erp;

import java.sql.*;

public class JDBC {
    private static final String URL = "jdbc:mysql://localhost:3306/personal?useUnicode=true&characterEncoding=UTF-8";
    private static final String USER = "root";
    private static final String PASSWORD = "root";
    static Connection con = null;
    static ResultSet rs = null;
    static PreparedStatement prep = null;

    //取得与数据库的连接
    public static Connection getCon() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            System.out.println("SQL驱动程序初始化失败！");
            e.printStackTrace();
        }
        return con;
    }

    //数据库增删改异常
    public static int addUpdDel(String sql) {
        int i = 0;
        try {
            prep = con.prepareStatement(sql);
            i = prep.executeUpdate();
        } catch (SQLException e) {
            System.out.println("SQL数据库增删改异常！");
            e.printStackTrace();
        }
        return i;
    }

    //数据库查询异常
    public static ResultSet selectSql(String sql) {
        try {
            prep = con.prepareStatement(sql);
            rs = prep.executeQuery();
        } catch (SQLException e) {
            System.out.println("SQL数据库查询异常！");
            e.printStackTrace();
        }
        return rs;
    }

    //关闭与数据库的连接
    public static void Close() {
        try {
            con.close();
        } catch (SQLException e) {
            System.out.println("SQL数据库关闭异常！");
            e.printStackTrace();
        }
    }

}
