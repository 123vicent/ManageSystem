package server;

import DAO.DAOFactory;
import DAO.ShopuserDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import model.Shopuser;

/*
 * 根据id查询用户信息
 */
@WebServlet(name = "SearchUserServlet",urlPatterns = {"/SearchUserServlet"})//注释方法配置web.xml
public class SearchUserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();

        String userid = (String)session.getAttribute("userid");

        System.out.println(userid);
        List<Shopuser> shopusers = new ArrayList<Shopuser>();

        ShopuserDAO shopuserDAO = DAOFactory.getShopuserDAO();
        shopusers.add(shopuserDAO.findById(userid));
        request.setAttribute("userAll",shopusers);

        request.getRequestDispatcher("ShopPage/UserInfor.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
