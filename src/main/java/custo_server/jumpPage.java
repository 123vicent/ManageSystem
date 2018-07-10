package custo_server;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "jumpPage",urlPatterns = "/jump")
public class jumpPage extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String pagename=request.getParameter("action");
        System.out.println(pagename);
        RequestDispatcher view;
        if(pagename.equals("主页"))
        {
            view = request.getRequestDispatcher("WEB-INF/CustPage/main.html");
        }else if(pagename.equals("个人信息")){
            view = request.getRequestDispatcher("WEB-INF/CustPage/imformation.html");
        }
        else if(pagename.equals("寻车试驾")){
            view = request.getRequestDispatcher("WEB-INF/CustPage/testdrive.html");
        }
        else if(pagename.equals("豪车鉴赏")){
            view = request.getRequestDispatcher("WEB-INF/CustPage/gallery.html");
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
