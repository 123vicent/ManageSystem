package server;

import DAO.DAOFactory;
import DAO.ShopuserDAO;
import dbcon.DBConnect;
import model.Shopuser;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



@SuppressWarnings("serial")
public class registerServlet extends HttpServlet {
    public void doPost(HttpServletRequest request,
                       HttpServletResponse response)
            throws ServletException, IOException {
        String identity = request.getParameter("identity");
        String password = request.getParameter("password");
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");

        RequestDispatcher view;

        ShopuserDAO shopuserdao = DAOFactory.getShopuserDAO();
        Shopuser shopuser = shopuserdao.findById(identity);

        if(shopuser.getShopuser_id()!=null)
        {
            request.setAttribute("msg","该用户名已被注册!");
            view=request.getRequestDispatcher("WEB-INF/register.jsp");

        }else{
            shopuser = new Shopuser();
            shopuser.setDescription("1");
            shopuser.setPswd(password);
            shopuser.setShop_address("1");
            shopuser.setShop_manager("fdfd");
            shopuser.setShopuser_id(identity);
            shopuser.setShop_name("dfgdg");
            shopuser.setShop_phone(phone);

            shopuserdao.insert(shopuser);
            view = request.getRequestDispatcher("index.jsp");
        }
        /*try {
            rs = stmt.executeQuery("select * from user");
            while(rs.next())
            {
                if(rs.getString(2).equals(identity)) {
                    request.setAttribute("msg","该用户名已被注册!");
                    view=request.getRequestDispatcher("WEB-INF/register.jsp");
                    view.forward(request,response);
                }
            }
            int i=(int)(Math.random()*900)+100;
            String id =  Integer.toString(i);
            String sql  = "insert into user values ('"+id+"','"+identity+"','"+password+"','"+phone+"','"+email+"')";
            stmt.execute(sql);
        } catch (SQLException e) {
            e.printStackTrace();
            request.setAttribute("msg","注册失败");
            view=request.getRequestDispatcher("WEB-INF/register.jsp");
            view.forward(request,response);
        }*/
        view.forward(request,response);
    }

    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request,response);
    }
}
