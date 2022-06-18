package work.web.ajax;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import work.web.utils.DButil;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @Author: Itachi
 * @Date: 2022/6/3 12:59
 * @Version: jdk1.8
 * @Description:发送AJAX请求动态展示部员列表
 */
@WebServlet("/ajaxrequest5")
public class AjaxRequest5Servlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        //字符串拼接
        StringBuilder html = new StringBuilder();
        //链接数据库
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = DButil.getConnection();
            String sql = "select empno,ename,job,sal from emp";
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            int i = 0 ;
            while (rs.next()){
                String empno = rs.getString("empno");
                String ename = rs.getString("ename");
                String job = rs.getString("job");
                String sal = rs.getString("sal");

                html.append("<tr align='center'>");
                html.append("<td>"+ ++i +"</td>");
                html.append("<td>"+empno+"</td>");
                html.append("<td>"+ename+"</td>");
                html.append("<td>"+job+"</td>");
                html.append("<td>"+sal+"</td>");
                html.append("</tr>");
                // out.print(html);
                // System.out.println(ename);
            }
            out.print(html);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DButil.close(conn,ps,rs);
        }
    }
}
