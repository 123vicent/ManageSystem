package server;
import DAO.CarinfoDAO;
import DAO.DAOFactory;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@SuppressWarnings("serial")
public class SearchcarServlet extends HttpServlet {
    public void doPost(HttpServletRequest request,
                       HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();
        String shopuserid = (String)session.getAttribute("userid");

        String brand = request.getParameter("Bybrand");
        String model = request.getParameter("Bymodel");
        String type = request.getParameter("Bytype");
        System.out.println(brand);
        System.out.println(model);
        System.out.println(type);

        CarinfoDAO carinfoDAO = DAOFactory.getCarinfoDAO();
        System.out.println(carinfoDAO.findAllByTag(shopuserid,brand,model,type));

        request.setAttribute("searchcars",carinfoDAO.findAllByTag(shopuserid,brand,model,type));
        request.getRequestDispatcher("WEB-INF/shopsearchcar.jsp").forward(request,response);
    }

    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request,response);

    }
}
