package server;

import DAO.CarinfoDAO;
import DAO.DAOFactory;
import DAO.ShopaptDAO;
import DAO.ShopowncarDAO;
import basic.Carinfo;
import basic.Shopapt;
import model.Shopowncar;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.parsers.FactoryConfigurationError;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "SwitchPage",urlPatterns = "/SwitchPage")
public class SwitchPage extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        String Shopuserid = (String)session.getAttribute("userid");
        session.setAttribute("userid",Shopuserid);
        String page = request.getParameter("page");
        RequestDispatcher view;
        if(page.equals("homepage")){
            view = request.getRequestDispatcher("ShopPage/firstpage.jsp");
        }else if(page.equals("funcpage")){
            view = request.getRequestDispatcher("ShopPage/funcOverview.html");
        }else if(page.equals("setpage")){
            view = request.getRequestDispatcher("ShopPage/set.html");
        }else if(page.equals("helppage")){
            view = request.getRequestDispatcher("ShopPage/help.html");
        }else if(page.equals("funcViewCar")){

            CarinfoDAO carinfoDAO = DAOFactory.getCarinfoDAO();
            List<Carinfo> carinfos = carinfoDAO.findAllByShopId(Shopuserid);
            request.setAttribute("searchcars",carinfos);
            view = request.getRequestDispatcher("ShopPage/funcViewCar.jsp");
        }else if(page.equals("funcUploadCar")){
            view = request.getRequestDispatcher("ShopPage/funcUploadCar.jsp");
        }else if(page.equals("funcViewAppointment")){
            ShopaptDAO shopaptDAO = DAOFactory.getShopaptDAO();
            List<Shopapt> shopapts  = shopaptDAO.findAllByShopId(Shopuserid);
            request.setAttribute("userapoint",shopapts);
            view = request.getRequestDispatcher("ShopPage/funcViewAppointment.jsp");
        }else if(page.equals("funcPushMsg")){
            view = request.getRequestDispatcher("ShopPage/funcPushMsg.html");
        }else if(page.equals("funcRegister")){

            view = request.getRequestDispatcher("ShopPage/funcRegister.jsp");
        }else{
            view = request.getRequestDispatcher("ShopPage/funcViewReg.jsp");
        }
        view.forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request,response);
    }
}
