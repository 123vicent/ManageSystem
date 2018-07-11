package custo_server;

import DAO.CustomeruserDAO;
import DAO.DAOFactory;
import model.Customeruser;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "jumpPage",urlPatterns = "/jump")
public class jumpPage extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String pagename=request.getParameter("action");
        RequestDispatcher view;
        if(pagename.equals("主页"))
        {
            view = request.getRequestDispatcher("WEB-INF/CustPage/main.html");
        }else if(pagename.equals("个人信息")){
            HttpSession session = request.getSession();
            String user_id = (String)session.getAttribute("userid");
            System.out.println(user_id);
            CustomeruserDAO customeruserDAO = DAOFactory.getCustometuserDAO();
            Customeruser customeruser = customeruserDAO.findById(user_id);
            request.setAttribute("user_info",customeruser);
            view = request.getRequestDispatcher("WEB-INF/CustPage/information.jsp");
        }
        else if(pagename.equals("寻车试驾")){
            view = request.getRequestDispatcher("WEB-INF/CustPage/testdrive.html");
        }
        else if(pagename.equals("豪车鉴赏")){
            view = request.getRequestDispatcher("WEB-INF/CustPage/gallery.html");
        }
        else if(pagename.equals("预约历史")){
            view = request.getRequestDispatcher("WEB-INF/CustPage/appointmentView.html");
        }
        else{
            view = request.getRequestDispatcher("WEB-INF/CustPage/reserve.html");
        }
        view.forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
                doPost(request,response);
    }
}
