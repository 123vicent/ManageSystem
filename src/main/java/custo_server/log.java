package custo_server;

import DAO.*;
import basic.KeyValuePair;
import model.Car;
import model.Customeruser;
import model.Shopuser;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "log",urlPatterns = {"/log"})
public class log extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //建立数据库连接

        String userid = request.getParameter("username");
        String password = request.getParameter("password");
        System.out.println(userid);
        System.out.println(password);

        String access = request.getParameter("submit");
        RequestDispatcher view;
        if(access.equals("立即注册")){
            view = request.getRequestDispatcher("WEB-INF/CustPage/cusregister.jsp");
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
                view  = request.getRequestDispatcher("WEB-INF/CustPage/cuslogin.jsp");
            }
            else if(password.equals(""))
            {
                request.setAttribute("msg1", "请输入密码");
                view  = request.getRequestDispatcher("WEB-INF/CustPage/cuslogin.jsp");
            }
            else {
                //rs = stmt.executeQuery("SELECT * FROM user where usr_name = '"+userid+"'and password =  '"+password+"'");
                //rs.next();
                HttpSession session = request.getSession();
                session.setAttribute("userid",userid);
                CustomeruserDAO customeruserdao  = DAOFactory.getCustometuserDAO();
                Customeruser customeruser = customeruserdao.findById(userid);
                //ShopuserDAO shopuserdao = DAOFactory.getShopuserDAO();
                //Shopuser shopuser = shopuserdao.findById(userid);
                if (customeruser.getPswd()!=null&&customeruser.getPswd().equals(password)) {
                    //request.setAttribute("msg","登录失败");
                    //view=request.getRequestDispatcher("index.jsp");
                    /*CarDAO cardao = DAOFactory.getCarDAO();
                    List<Car> cars = cardao.findAll();
                    List<KeyValuePair> lists =new ArrayList<KeyValuePair>();
                    for(Car car:cars) {
                        lists.add(new KeyValuePair(car.getBrand(),car.getModel()));
                    }
                    session.setAttribute("list",lists);
                    request.setAttribute("userid",userid);//显示用户i
                    CarinfoDAO carinfoDAO = DAOFactory.getCarinfoDAO();
                    request.setAttribute("cars",carinfoDAO.findAllByShopId(userid));*/


                    view = request.getRequestDispatcher("WEB-INF/CustPage/firstpage.jsp");
                } else {
                    request.setAttribute("msg2", "登录失败");
                    view = request.getRequestDispatcher("WEB-INF/CustPage/cuslogin.jsp");

                }
            }
        }
        view.forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}