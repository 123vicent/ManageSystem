package server;
import DAO.CarDAO;
import DAO.CarDAOImpl;
import DAO.DAOFactory;
import DAO.ShopowncarDAO;
import model.Car;
import model.Shopowncar;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@SuppressWarnings("serial")
public class AddcarServlet extends HttpServlet {
    public void doPost(HttpServletRequest request,
                       HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();
        String shopuserid = (String)session.getAttribute("userid");

        //String brand_model = request.getParameter("brand-model");
        //System.out.println(brand_model);

        //String[] s = brand_model.split("-");
        String brand = request.getParameter("brand");
        String model = request.getParameter("model");
        System.out.println(brand);
        System.out.println(model);

        CarDAO carDAO = DAOFactory.getCarDAO();
        Car car = carDAO.findByBrandModel(brand,model);
        System.out.println(car.getCar_id());
        String stock = request.getParameter("stock");
        String price = request.getParameter("price");
        System.out.println(stock);
        System.out.println(price);
        String pic_url = "111";
        //String access = request.getParameter("submit");
        if(stock.equals("")||price.equals("")) {
            request.setAttribute("error","请将属性填完整");
        }
        else{
            Shopowncar shopowncar = new Shopowncar();
            shopowncar.setCar_id(car.getCar_id());
            shopowncar.setShopuser_id(shopuserid);
            shopowncar.setStock(Integer.parseInt(stock));
            shopowncar.setPrice(Double.parseDouble(price));
            shopowncar.setPic_url(pic_url);

            ShopowncarDAO shopowncarDAO = DAOFactory.getShopowncarDAO();
            shopowncarDAO.insert(shopowncar);
            request.setAttribute("success","添加成功");
        }

            request.getRequestDispatcher("WEB-INF/shopaddcar.jsp").forward(request, response);

    }

    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request,response);

    }
}

