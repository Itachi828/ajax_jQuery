package work.web.ajax;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

/**
 * @Author: Itachi
 * @Date: 2022/6/6 12:19
 * @Version: jdk1.8
 * @Description: 动态获取部员信息_XML
 */
@WebServlet("/ajaxrequest7")
public class AjaxRequest7Servlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }
}
