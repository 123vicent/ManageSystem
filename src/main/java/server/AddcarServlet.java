package server;
import DAO.CarDAO;
import DAO.CarDAOImpl;
import DAO.DAOFactory;
import model.Car;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



@SuppressWarnings("serial")
public class AddcarServlet extends HttpServlet {
    public void doPost(HttpServletRequest request,
                       HttpServletResponse response)
            throws ServletException, IOException {

        String car_id = "1";
        String brand = request.getParameter("brand");
        String model = request.getParameter("model");
        String color = "white";
        String seats = "111";
        String type = "111";
        String power = "111";
        //String access = request.getParameter("submit");
        Car car = new Car();
        car.setCar_id(car_id);
        car.setBrand(brand);
        car.setModel(model);
        car.setColor(color);
        car.setSeats(seats);
        car.setType(type);
        car.setPower(power);

        CarDAO carDAO = DAOFactory.getCarDAO();
        carDAO.insert(car);


    }

    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request,response);

    }
}

