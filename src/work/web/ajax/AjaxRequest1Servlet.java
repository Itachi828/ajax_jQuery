package work.web.ajax;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

/**
 * @Author: Itachi
 * @Date: 2022/6/2 10:48
 * @Version: jdk1.8
 */
@WebServlet({"/ajaxrequest1"})
public class AjaxRequest1Servlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        out.println("<font color = 'red'>welcome study ajax</font>");
    }
}
