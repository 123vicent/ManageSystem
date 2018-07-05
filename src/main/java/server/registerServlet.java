package server;

import DAO.AppointmentDAO;
import DAO.DAOFactory;
import model.Appointment;

import java.io.IOException;
import java.sql.Date;
import javax.servlet.RequestDispatcher;
        import javax.servlet.ServletException;
        import javax.servlet.http.HttpServlet;
        import javax.servlet.http.HttpServletRequest;
        import javax.servlet.http.HttpServletResponse;



@SuppressWarnings("serial")
public class registerServlet extends HttpServlet {
    public void doPost(HttpServletRequest request,
                       HttpServletResponse response)
            throws ServletException, IOException {
        String identity = request.getParameter("identity");
        String password = request.getParameter("password");
        String phone = request.getParameter("phone");
        Date email = Date.valueOf(request.getParameter("email"));

        /*Appointment apt = new Appointment();
        apt.setAppointment_id(identity);
        apt.setCususer_id(password);
        apt.setShopuser_id(phone);
        apt.setAp_time(email);

        AppointmentDAO aptdao = DAOFactory.getAppointmentDAO();
        aptdao.insert(apt);
        */
        //test


        String access = request.getParameter("submit");

    }

    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request,response);

    }
}
