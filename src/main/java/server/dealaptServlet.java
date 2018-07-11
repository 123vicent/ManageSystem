package server;

import DAO.DAOFactory;
import DAO.ShopaptDAO;
import basic.Shopapt;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "dealaptServlet",urlPatterns = "/dealapt")
public class dealaptServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String ap_id = request.getParameter("deal");
        ShopaptDAO shopaptDAO = DAOFactory.getShopaptDAO();
        Shopapt shopapt = shopaptDAO.findByApid(ap_id);

        RequestDispatcher view;
        request.setAttribute("shopapt",shopapt);
        view = request.getRequestDispatcher("WEB-INF/dealersPage/handlebook.jsp");
        view.forward(request,response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);

    }
}
