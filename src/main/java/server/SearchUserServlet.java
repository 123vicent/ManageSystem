package server;

import dbcon.DBConnect;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import basic.Shopuser;

/*
 * 根据id查询用户信息
 */
@WebServlet(name = "SearchUserServlet",urlPatterns = {"/SearchUserServlet"})//注释方法配置web.xml
public class SearchUserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userid = request.getParameter("userid");

        System.out.println(userid);
        List<Shopuser> shopusers = new ArrayList<Shopuser>();
        request.setAttribute("",shopusers);

        request.getRequestDispatcher("");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
