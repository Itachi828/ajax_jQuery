package work.web.ajax;

import com.alibaba.fastjson.JSON;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import work.web.bean.Emp;
import work.web.utils.DButil;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Itachi
 * @Date: 2022/6/4 12:35
 * @Version: jdk1.8
 * @Description: 使用JSON动态展示部员列表
 */
@WebServlet("/ajaxrequest6")
public class AjaxRequest6Servlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //链接数据库
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        List<Emp> empList = new ArrayList<>();
        String jsonStr = "";
        try {
            conn = DButil.getConnection();
            String sql = "select empno,ename,job,sal from emp order by sal";
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            int i = 0 ;
            while (rs.next()){
                String empno = rs.getString("empno");
                String ename = rs.getString("ename");
                String job = rs.getString("job");
                String sal = rs.getString("sal");

                Emp emp = new Emp(empno,ename,job,sal);

                empList.add(emp);
            }
            jsonStr = JSON.toJSONString(empList);

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DButil.close(conn,ps,rs);
        }
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.print(jsonStr);
    }
}
