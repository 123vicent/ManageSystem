package custo_server;

import DAO.AppointmentDAO;
import DAO.CustomeruserDAO;
import DAO.CususeraptDAO;
import DAO.DAOFactory;
import basic.Cususerapt;
import model.Appointment;
import model.Customeruser;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "jumpPage",urlPatterns = "/jump")
public class jumpPage extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String pagename=request.getParameter("action");
        RequestDispatcher view;
        HttpSession session = request.getSession();
        String user_id = (String)session.getAttribute("userid");
        System.out.println(pagename);
        if(pagename.equals("homepage"))
        {
            view = request.getRequestDispatcher("WEB-INF/CustPage/main.html");
        }else if(pagename.equals("personal_info")){
            CustomeruserDAO customeruserDAO = DAOFactory.getCustometuserDAO();
            Customeruser customeruser = customeruserDAO.findById(user_id);
            request.setAttribute("user_info",customeruser);
            view = request.getRequestDispatcher("WEB-INF/CustPage/information.jsp");
        }
        else if(pagename.equals("testdrive")){
            view = request.getRequestDispatcher("WEB-INF/CustPage/testdrive.html");
        }
        else if(pagename.equals("viewcar")){
            view = request.getRequestDispatcher("WEB-INF/CustPage/gallery.html");
        }
        else if(pagename.equals("apt_record")){
            CususeraptDAO cususeraptDAO  = DAOFactory.getCususeraptDAO();
            List<Cususerapt> cususerapts = cususeraptDAO.findAllByCusid(user_id);
            request.setAttribute("cususerapts",cususerapts);
            view = request.getRequestDispatcher("WEB-INF/CustPage/appointmentView.jsp");
        }
        else if(pagename.equals("appoint_detail")) {
            String apt_id = request.getParameter("value");
            System.out.println(apt_id);
            CususeraptDAO cususeraptDAO = DAOFactory.getCususeraptDAO();
            Cususerapt cususerapt = cususeraptDAO.findByApid(apt_id);
            request.setAttribute("cususerapt",cususerapt);
            view = request.getRequestDispatcher("WEB-INF/CustPage/recordDetail.jsp");
        }
        else{
            view = request.getRequestDispatcher("WEB-INF/CustPage/reserve.jsp");
        }
        view.forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
                doPost(request,response);
    }
}
