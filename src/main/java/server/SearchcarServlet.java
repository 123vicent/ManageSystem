package server;
import DAO.CarDAO;
import DAO.DAOFactory;
import DAO.ShopowncarDAO;
import model.Car;
import model.Shopowncar;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@SuppressWarnings("serial")
public class SearchcarServlet extends HttpServlet {
    public void doPost(HttpServletRequest request,
                       HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        String shopuserid = (String)session.getAttribute("userid");
        String brand = request.getParameter("Bybrand");
        String model = request.getParameter("Bymodel");

        CarDAO carDAO = DAOFactory.getCarDAO();
        Car car = carDAO.findByBrandModel(brand,model);

        ShopowncarDAO shopowncarDAO = DAOFactory.getShopowncarDAO();
        List<Shopowncar> shopowncars = new ArrayList<Shopowncar>();
        shopowncars.add(shopowncarDAO.findById(shopuserid,car.getCar_id()));

        request.setAttribute("searchcars",shopowncars);
        request.getRequestDispatcher("WEB-INF/shopsearchcar.jsp").forward(request,response);
    }

    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request,response);

    }
}
