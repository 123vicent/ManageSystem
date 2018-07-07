package server;

import DAO.DAOFactory;
import DAO.ShopuserDAO;
import DAO.ShopuserDAOImpl;
import basic.Appointment;
import basic.Car;
import dbcon.DBConnect;
import model.Shopuser;

import java.io.IOException;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
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
            ShopuserDAO shopuserdao = DAOFactory.getShopuserDAO();
            Shopuser shopuser = shopuserdao.findById(userid);
            if(shopuser.getPswd().equals(password))
            {
                List<Car> cars = new ArrayList<Car>();
                Car owncars = new Car();
                owncars.setCar_id("0");
                owncars.setBrand("RRR");
                owncars.setModel("666");
                owncars.setSeats("4");
                owncars.setType("跑车");
                owncars.setColor("red");
                owncars.setPower("1000");
                cars.add(owncars);

                Appointment apm  = new Appointment();
                apm.setAppoint_id("212");
                apm.setAppoint_state("保养预约");
                apm.setAppoint_time("2018-08-08");
                apm.setAppoint_type("已处理");
                apm.setCustomer_call("65165156");
                apm.setCustomer_name("sfsdfsf");

                request.setAttribute("shopcar",cars);
                request.setAttribute("appointment",apm);

                view = request.getRequestDispatcher("WEB-INF/firstpage.jsp");
            }
            else{
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