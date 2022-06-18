package work.web.utils;

import java.sql.*;
import java.util.ResourceBundle;

/**
 * @Author: Itachi
 * @Date: 2022/6/3 13:26
 * @Version: jdk1.8
 * @Description:链接数据库
 */
public class DButil {
    private static ResourceBundle bundle = ResourceBundle.getBundle("resource.jdbc");
    private static String driver = bundle.getString("driver");
    private static String url = bundle.getString("url");
    private static String user = bundle.getString("user");
    private static String password = bundle.getString("password");

    static {
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public static Connection getConnection() throws SQLException {
        Connection conn = DriverManager.getConnection(url,user,password);
        return conn;
    }

    public static void close(Connection conn, Statement stmt, ResultSet rs)  {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (stmt != null) {
            try {
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
