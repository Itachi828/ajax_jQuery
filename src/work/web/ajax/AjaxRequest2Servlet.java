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
 * @Date: 2022/6/2 12:58
 * @Version: jdk1.8
 */
@WebServlet("/ajaxrequest2")
public class AjaxRequest2Servlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String usercord = request.getParameter("usercord");
        String pwd = request.getParameter("pwd");

        PrintWriter out = response.getWriter();
        out.println("usercord="+usercord+"pwd="+pwd);
    }
}
