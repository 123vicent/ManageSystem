package server;

import DAO.CustomeruserDAO;
import DAO.DAOFactory;
import dbcon.DBConnect;
import model.Customeruser;
import model.Shopowncar;

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
        String submit = request.getParameter("submit");
        RequestDispatcher view;

        if(submit.equals("立即注册")){
            String cusid = "1";
            String cusname = "jack";
            String cusphone = "13335555";
            Customeruser cu =new Customeruser();
            cu.setCususer_id(cusid);
            cu.setCus_name(cusname);
            cu.setCus_phone(cusphone);
            CustomeruserDAO cuDAO = DAOFactory.getCustometuserDAO();
            cuDAO.insert(cu);
            view = request.getRequestDispatcher("WEB-INF/register.jsp");
        }
        else if(submit.equals("登陆")){
            view = request.getRequestDispatcher("WEB-INF/firstpage.jsp");
        }
        else{
            view = request.getRequestDispatcher("WEB-INF/forget.jsp");
        }
        view.forward(request,response);

    }

    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request,response);

    }
}