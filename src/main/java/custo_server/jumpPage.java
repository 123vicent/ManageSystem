package custo_server;

import DAO.*;
import basic.Carview;
import basic.Cususerapt;
import model.Appointment;
import model.Car;
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
            CarviewDAO carviewDAO = DAOFactory.getCarviewDAO();
            List<Carview> carviews  = carviewDAO.findAll();
            request.setAttribute("cars",carviews);
            view = request.getRequestDispatcher("WEB-INF/CustPage/testdrive.jsp");
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
        else if(pagename.equals("car_detail")) {
            String car_id = request.getParameter("carid");
            session.setAttribute("carid",car_id);

            String shopuser_id = request.getParameter("shopuserid");
            session.setAttribute("shopuserid",shopuser_id);

            System.out.println(car_id);
            System.out.println(shopuser_id);
           CarviewDAO carviewDAO = DAOFactory.getCarviewDAO();
           Carview carview = carviewDAO.findById(car_id,shopuser_id);
            request.setAttribute("car",carview);
            view = request.getRequestDispatcher("WEB-INF/CustPage/testsingle.jsp");
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
