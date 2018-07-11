package server;

import DAO.AppointmentDAO;
import DAO.DAOFactory;
import model.Appointment;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Timestamp;

@WebServlet(name = "dealingaptServlet",urlPatterns = "/dealingapt")
public class dealingaptServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String access = request.getParameter("submit");
        String ap_id = request.getParameter("ap_id");
        AppointmentDAO apDAO = DAOFactory.getAppointmentDAO();
        Appointment ap = apDAO.findById(ap_id);
        RequestDispatcher view;
        if(access.equals("接受预约")){
            ap.setAp_state("已接受");
            view = request.getRequestDispatcher("WEB-INF/usershopapoint.jsp");
        }else if(access.equals("拒绝预约")){
            String refusemsg = request.getParameter("refusemsg");
            if(refusemsg.equals("")){
                request.setAttribute("error","请输入完整信息");
                view = request.getRequestDispatcher("WEB-INF/dealersPage/handlebook.jsp");
            }else{
                ap.setDescription(refusemsg);
                ap.setAp_state("已拒绝");
                ap.setPayment(0);
                view = request.getRequestDispatcher("WEB-INF/usershopapoint.jsp");
            }
        }else{
            String completetime = request.getParameter("complete_time");
            String pay_ment = request.getParameter("payment");
            Timestamp complete_time = Timestamp.valueOf(completetime);
            double payment = Double.parseDouble(pay_ment);
            String description = request.getParameter("description");
            if(completetime.equals("")||pay_ment.equals("")||description.equals("")){
                request.setAttribute("error","请输入完整信息");
                view = request.getRequestDispatcher("WEB-INF/dealersPage/handlebook.jsp");
            }else{
                ap.setAp_state("已完成");
                ap.setComplete_time(complete_time);
                ap.setPayment(payment);
                ap.setDescription(description);
                view = request.getRequestDispatcher("WEB-INF/usershopapoint.jsp");
            }
        }
        apDAO.update(ap);
        view.forward(request,response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);

    }
}
