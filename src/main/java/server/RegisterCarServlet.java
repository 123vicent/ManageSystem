package server;

import DAO.CarDAO;
import DAO.CusowncarDAO;
import DAO.CustomeruserDAO;
import DAO.DAOFactory;
import model.Car;
import model.Cusowncar;
import model.Customeruser;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Date;

@WebServlet(name = "RegisterCarServlet",urlPatterns = "/RegisterCarServlet")
public class RegisterCarServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String plate_number = request.getParameter("plate_number");
        System.out.println(plate_number);
        CusowncarDAO cusowncarDAO = DAOFactory.getCusowncarDAO();
        Cusowncar cusowncar = cusowncarDAO.findById(plate_number);
        if (cusowncar.getPlate_number() != null) {
            request.setAttribute("plate_number_error", "车牌号已存在");
        }

        HttpSession session = request.getSession();
        String shopuserid = (String) session.getAttribute("userid");
        System.out.println("经销商id：" + shopuserid);

        String cusid = request.getParameter("userid");
        System.out.println("输入的客户id：" + cusid);

        CustomeruserDAO customeruserDAO = DAOFactory.getCustometuserDAO();
        Customeruser customeruser = customeruserDAO.findById(cusid);
        System.out.println("查找的客户id：" + customeruser.getCususer_id());
        if (customeruser.getCususer_id() == null) {
            //System.out.println(1111);
            request.setAttribute("cusid_error", "客户id不存在");
        }

        String brand = request.getParameter("brand");
        System.out.println("车牌：" + brand);

        String model = request.getParameter("model");
        System.out.println("车型：" + model);

        CarDAO carDAO = DAOFactory.getCarDAO();
        Car car = carDAO.findByBrandModel(brand, model);
        if (car.getCar_id() == null) {
            request.setAttribute("carid_error", "车id不存在");
        }

        String register_time = request.getParameter("register_time");
        System.out.println("登记时间：" + register_time);
        Date time = Date.valueOf(register_time);

        String pay_price = request.getParameter("pay_price");
        System.out.println("支付价格：" + pay_price);

        Cusowncar cusowncar1 = new Cusowncar();
        cusowncar1.setPlate_number(plate_number);
        cusowncar1.setShopuser_id(shopuserid);
        cusowncar1.setCususer_id(cusid);
        cusowncar1.setCar_id(car.getCar_id());
        cusowncar1.setRegister_time(time);
        cusowncar1.setPayment(Double.parseDouble(pay_price));

        CusowncarDAO cusowncarDAO1 = DAOFactory.getCusowncarDAO();
        cusowncarDAO1.insert(cusowncar1);


        request.getRequestDispatcher("ShopPage/funcRegister.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
