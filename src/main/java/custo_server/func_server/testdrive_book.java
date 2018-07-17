package custo_server.func_server;

import DAO.AppointmentDAO;
import DAO.CarDAO;
import DAO.DAOFactory;
import DAO.ShopuserDAO;
import model.Appointment;
import model.Car;
import model.Shopuser;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet(name = "testdrive_book",urlPatterns = {"/testdrive_book"})
public class testdrive_book extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int ap_num = (int)(Math.random()*100000000);
        String ap_id = Integer.toString(ap_num);
        System.out.println("预约id："+ ap_id);

        HttpSession session = request.getSession();
        String cuid = (String) session.getAttribute("userid");
        System.out.println("会话得到的用户id：" + cuid);

        String shopuserid = (String) session.getAttribute("shopuserid");
        System.out.println("经销商id：" + shopuserid);

        String carid = (String) session.getAttribute("carid");
        System.out.println("得到会话的车id："+ carid);

        //String brand_model = request.getParameter("brand-model");
        //System.out.println("车模型：" + brand_model);

        //String[] brand_models = brand_model.split("-");
        //String brand = brand_models[0];
        //System.out.println(brand);
        //String model = brand_models[1];
        //System.out.println(model);

        //String cusname = new String(request.getParameter("cusname").getBytes("ISO8859-1"),"UTF-8");
        //System.out.println("用户姓名："+cusname);

        //String Shopuser = request.getParameter("shopuser");
        //System.out.println("经销商名字：" + Shopuser);
        //String[] shopname = Shopuser.split("-");
        //String adress = shopname[0];
        //System.out.println(adress);

        //String ShopName = shopname[1];
        //System.out.println(ShopName);
        //根据address，name查找经销商id
        //ShopuserDAO shopuserDAO = DAOFactory.getShopuserDAO();
        //Shopuser shopuser = shopuserDAO.findByNameAdd(ShopName, adress);

        String ap_time = request.getParameter("ap_time");
        System.out.println("预约时间：" + ap_time);
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        Date date = null;
        try {
            date = df.parse(ap_time);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        //SimpleDateFormat ft = new SimpleDateFormat ("yyyy-MM-dd HH:mm:ss");
        //System.out.println(ft.format(date));
        Timestamp timestamp = new Timestamp(date.getTime());
        System.out.println("插入数据库的时间：" + timestamp);

        String ap_type = "试驾预约";

        String ap_state = "待接受";

        String Message = new String(request.getParameter("Message").getBytes("ISO8859-1"),"UTF-8");
        System.out.println("描述："+Message);
        //String phone = request.getParameter("phone");
        //System.out.println(phone);

        Appointment appointment = new Appointment();
        appointment.setAppointment_id(String.valueOf(ap_id));
        appointment.setCususer_id(cuid);
        appointment.setShopuser_id(shopuserid);
        appointment.setCar_id(carid);
        appointment.setAp_time(timestamp);
        appointment.setAp_type(ap_type);
        appointment.setAp_state(ap_state);
        //appointment.setComplete_time(0);
        appointment.setPayment(0);
        appointment.setCusinfo(Message);

        AppointmentDAO appointmentDAO = DAOFactory.getAppointmentDAO();
        if (appointmentDAO.insert(appointment))
            request.setAttribute("meaasge", "预约提交成功");
        else
            request.setAttribute("error", "预约提交失败");

        request.getRequestDispatcher("WEB-INF/CustPage/transaction.html").forward(request, response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
