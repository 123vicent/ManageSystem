package server;

import basic.Car;
import dbcon.DBConnect;

import java.io.IOException;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@SuppressWarnings("serial")
public class LoginServlet extends HttpServlet {
    public void doPost(HttpServletRequest request,
                       HttpServletResponse response)
            throws ServletException, IOException {
        //建立数据库连接
        DBConnect db = new DBConnect();
        Statement stmt = db.connect();
        ResultSet rs = null;
        String userid = request.getParameter("username");
        String password = request.getParameter("password");
        System.out.println(userid);System.out.println(password);

        String access = request.getParameter("submit");
        RequestDispatcher view;
        if(access.equals("立即注册")){
            view = request.getRequestDispatcher("WEB-INF/register.jsp");
        }
        else if(access.equals("忘记密码"))
        {
            view = request.getRequestDispatcher("WEB-INF/forget.jsp");
        }
        else
        {
            try {
                rs = stmt.executeQuery("SELECT * FROM user where usr_name = '"+userid+"'and password =  '"+password+"'");
                rs.next();
                if(rs.getString(1).equals(null))
                {
                    request.setAttribute("msg","登录失败");
                    view=request.getRequestDispatcher("index.jsp");
                }
                else{
                    Car owncars = new Car();
                    owncars.setCar_id("0");
                    owncars.setBrand("RRR");
                    owncars.setModel("666");
                    owncars.setSeats("4");
                    owncars.setType("跑车");
                    owncars.setColor("red");
                    owncars.setPower("1000");

                    request.setAttribute("shopcar",owncars);

                    view = request.getRequestDispatcher("WEB-INF/firstpage.jsp");

                }
            } catch (SQLException e) {
                e.printStackTrace();
                request.setAttribute("msg","登录失败");
                view=request.getRequestDispatcher("index.jsp");
            }
        }
        view.forward(request,response);
    }

    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request,response);

    }
}