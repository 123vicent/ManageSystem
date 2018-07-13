package server;

import DAO.CarDAO;
import DAO.CarinfoDAO;
import DAO.DAOFactory;
import DAO.ShopowncarDAO;
import basic.Carinfo;
import model.Car;
import model.Shopowncar;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "UpdateCarServlet",urlPatterns = "/updatecar")
public class UpdateCarServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String access = request.getParameter("access");
        String stockstr = request.getParameter("stock");
        String pricestr = request.getParameter("price");
        String userid = request.getParameter("userid");
        String carid = request.getParameter("carid");
        ShopowncarDAO shopowncarDAO = DAOFactory.getShopowncarDAO();
        Shopowncar soc = shopowncarDAO.findById(userid,carid);
        RequestDispatcher view;

        if(access.equals("更新")){
            if(stockstr.equals("")||pricestr.equals("")){
                request.setAttribute("error","请输入完整信息");
                view = request.getRequestDispatcher("ShopPage/ChangeCarInfo.jsp");
            }else {
                int stock = Integer.parseInt(stockstr);
                double price = Double.parseDouble(pricestr);
                soc.setStock(stock);
                soc.setPrice(price);
                shopowncarDAO.update(soc);
                view = request.getRequestDispatcher("ShopPage/funcViewCar.jsp");
            }
        }else{
            view = request.getRequestDispatcher("ShopPage/funcViewCar.jsp");
        }
        CarinfoDAO carinfoDAO = DAOFactory.getCarinfoDAO();
        List<Carinfo> carinfos = carinfoDAO.findAllByShopId(soc.getShopuser_id());
        request.setAttribute("soc",soc);
        request.setAttribute("searchcars",carinfos);
        CarDAO carDAO = DAOFactory.getCarDAO();
        Car c = carDAO.findById(carid);
        request.setAttribute("brand",c.getBrand());
        request.setAttribute("model",c.getModel());
        view.forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
