package server;

import DAO.DAOFactory;
import DAO.ShopuserDAO;
import model.Car;
import model.Shopuser;

import java.io.IOException;
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
            if(userid.equals(""))
            {
                request.setAttribute("msg0", "请输入用户名");
                view  = request.getRequestDispatcher("index.jsp");
            }
            else if(password.equals(""))
            {
                request.setAttribute("msg1", "请输入密码");
                view  = request.getRequestDispatcher("index.jsp");
            }
            else {
                //rs = stmt.executeQuery("SELECT * FROM user where usr_name = '"+userid+"'and password =  '"+password+"'");
                //rs.next();
                ShopuserDAO shopuserdao = DAOFactory.getShopuserDAO();
                Shopuser shopuser = shopuserdao.findById(userid);
                if (shopuser.getPswd()!=null&&shopuser.getPswd().equals(password)) {
                    //request.setAttribute("msg","登录失败");
                    //view=request.getRequestDispatcher("index.jsp");
                    Car owncars = new Car();
                    owncars.setCar_id("0");
                    owncars.setBrand("RRR");
                    owncars.setModel("666");
                    owncars.setSeats("4");
                    owncars.setType("跑车");
                    owncars.setColor("red");
                    owncars.setPower("1000");



                    view = request.getRequestDispatcher("WEB-INF/firstpage.jsp");
                } else {
                    request.setAttribute("msg2", "登录失败");
                    view = request.getRequestDispatcher("index.jsp");

                }
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