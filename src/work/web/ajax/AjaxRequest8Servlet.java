package work.web.ajax;

import com.alibaba.fastjson.JSON;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import work.web.bean.Dept;
import work.web.bean.Emp;
import work.web.utils.DButil;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Itachi
 * @Date: 2022/6/6 12:31
 * @Version: jdk1.8
 * @Description: 动态实现部门和部员联动
 */
@WebServlet("/ajaxrequest8")
public class AjaxRequest8Servlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String deptno1 = request.getParameter("deptno");
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Dept> deptList = new ArrayList<>();
        List<Emp> empList = new ArrayList<>();
        String s = "";
        try {
            conn = DButil.getConnection();
            if (deptno1 == null) {
                String sql = "select deptno,dname from dept";
                ps = conn.prepareStatement(sql);
                rs = ps.executeQuery();
                while (rs.next()) {
                    String deptno = rs.getString("deptno");
                    String dname = rs.getString("dname");
                    Dept dept = new Dept(deptno,dname);
                    deptList.add(dept);
                }
                s = JSON.toJSONString(deptList);
            }else {
                String sql = "select ename,empno from emp where deptno = ?";
                ps = conn.prepareStatement(sql);
                ps.setString(1,deptno1);
                rs = ps.executeQuery();
                while (rs.next()) {
                    String empno = rs.getString("empno");
                    String ename = rs.getString("ename");
                    Emp emp = new Emp(empno,ename);
                    empList.add(emp);
                }
                s = JSON.toJSONString(empList);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        response.setContentType("text/html;charset=UTF-8");
        // String html = "<option value='001'>河南省</option>";
        response.getWriter().print(s);
    }
}
