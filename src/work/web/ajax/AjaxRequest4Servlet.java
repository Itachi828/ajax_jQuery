package work.web.ajax;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

/**
 * @Author: Itachi
 * @Date: 2022/6/3 11:07
 * @Version: jdk1.8
 */
@WebServlet("/ajaxrequest4")
public class AjaxRequest4Servlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String uname = request.getParameter("uname");
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        boolean flag = false;
        try {
            // 1、注册驱动
            Class.forName("com.mysql.cj.jdbc.Driver");
            //2、获取链接
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bjpowernode?serverTimezone=UTC","root","3333");
            //3、获取预编译的数据库对象
            String sql = "select username from t_user where username = ?";
            //4、执行sql语句
            ps = conn.prepareStatement(sql);
            ps.setString(1,uname);
            rs = ps.executeQuery();
            //5、处理查询结果集
            if (rs.next()) {
                flag = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //6、释放资源
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (ps != null) {
                try {
                    ps.close();
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
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        if(flag){
            //提示用户名存在
            out.print("<font color='red'>对不起，用户名已存在</font>");
        }else {
            //提示用户名可以使用
            out.print("<font color='green'>用户名可以使用</font>");
        }
    }
}
