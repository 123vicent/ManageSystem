package server;

import DAO.DAOFactory;
import DAO.ShopRegcusDAO;
import basic.ShopRegcus;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Date;
import java.util.List;

@WebServlet(name = "ViewRegServlet",urlPatterns = "/ViewRegServlet")
public class ViewRegServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String shopuserid = (String)session.getAttribute("userid");
        System.out.println("经销商id："+shopuserid);

        String cususer_id = request.getParameter("cususer_id");
        System.out.println("用户id："+cususer_id);

        String cus_name = request.getParameter("cus_name");
        System.out.println("用户名字："+cus_name);

        String brand = request.getParameter("brand");
        System.out.println("车品牌："+brand);

        String model = request.getParameter("model");
        System.out.println("车模型："+model);

        ShopRegcusDAO shopRegcusDAO = DAOFactory.getShopRegcusDAO();
        List<ShopRegcus> shopRegcuses = shopRegcusDAO.findByCon(shopuserid,cususer_id,cus_name,brand,model);
        System.out.println(shopRegcuses);
        request.setAttribute("shopowncar",shopRegcuses);
        request.getRequestDispatcher("ShopPage/funcViewReg.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
