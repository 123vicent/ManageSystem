package custo_server.func_server;

import DAO.*;
import model.Appointment;
import model.Car;
import model.Customeruser;
import model.Shopuser;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet(name = "MR_BookServlet",urlPatterns = {"/MR_BookServlet"})
public class MR_BookServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Double ap_id = Math.random();
        System.out.println("预约id："+ ap_id);

        String name = new String(request.getParameter("name").getBytes("ISO8859-1"),"UTF-8");
        System.out.println("用户姓名："+ name);

        String phone = new String(request.getParameter("phone").getBytes("ISO8859-1"),"UTF-8");
        System.out.println("用户电话：" + phone);

        HttpSession session = request.getSession();
        String cuid = (String)session.getAttribute("userid");
        System.out.println("会话得到的用户id："+ cuid);
        //根据名字电话查找用户id
        CustomeruserDAO customeruserDAO = DAOFactory.getCustometuserDAO();
        Customeruser customeruser = customeruserDAO.findById(cuid);
        System.out.println("查找得到的用户id：" + customeruser.getCususer_id());

        String brand = new String(request.getParameter("brand").getBytes("ISO8859-1"),"UTF-8");
        System.out.println("牌： " + brand);

        String model = new String(request.getParameter("model").getBytes("ISO8859-1"),"UTF-8");
        System.out.println("模型：" + model);
        //根据brand，model查找车id
        CarDAO carDAO = DAOFactory.getCarDAO();
        Car car = carDAO.findByBrandModel(brand,model);
        System.out.println("车id：" + car.getCar_id());

        String province = new String(request.getParameter("province").getBytes("ISO8859-1"),"UTF-8");
        //System.out.println(province);

        String city = new String(request.getParameter("city").getBytes("ISO8859-1"),"UTF-8");
        //System.out.println(city);
        System.out.println("地址：" + province+city);

        String shop = new String(request.getParameter("shop").getBytes("ISO8859-1"),"UTF-8");
        System.out.println("经销商名字："+ shop);
        //根据address，name查找经销商id
        ShopuserDAO shopuserDAO = DAOFactory.getShopuserDAO();
        Shopuser shopuser = shopuserDAO.findByNameAdd(shop,province+city);
        System.out.println("经销商id：" + shopuser.getShopuser_id());

        String book = new String(request.getParameter("book").getBytes("ISO8859-1"),"UTF-8");
        System.out.println("预约类型："+book);

        String time = new String(request.getParameter("time").getBytes("ISO8859-1"),"UTF-8");
        System.out.println("时间：" + time);

        Date date = new Date();
        //SimpleDateFormat ft = new SimpleDateFormat ("yyyy-MM-dd HH:mm:ss");
        //System.out.println(ft.format(date));
        Timestamp timestamp = new Timestamp(date.getTime());
        System.out.println("插入数据库的时间："+timestamp);

        String ap_state = "待接受";

        String Message = new String(request.getParameter("Message").getBytes("ISO8859-1"),"UTF-8");
        System.out.println("描述："+Message);

        Appointment appointment = new Appointment();
        appointment.setAppointment_id(String.valueOf(ap_id));
        appointment.setCususer_id(cuid);
        appointment.setShopuser_id(shopuser.getShopuser_id());
        appointment.setCar_id(car.getCar_id());
        appointment.setAp_time(timestamp);
        appointment.setAp_type(book);
        appointment.setAp_state(ap_state);
        //appointment.setComplete_time();
        //appointment.setPayment();
        appointment.setDescription(Message);

        AppointmentDAO appointmentDAO = DAOFactory.getAppointmentDAO();
        if(appointmentDAO.insert(appointment))
            request.setAttribute("success","上传成功");
        else
            request.setAttribute("error","上传失败");

        request.getRequestDispatcher("WEB-INF/CustPage/reserve.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
