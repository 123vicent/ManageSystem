package server;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.RequestDispatcher;
import java.io.IOException;

@SuppressWarnings("serial")
public class FirstPageServlet extends HttpServlet {
    public void doPost(HttpServletRequest request,
                       HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("function");
        System.out.println(action);
        RequestDispatcher view;

        //判断经销商执行的操作,并做出对应的响应
        if(action.equals("使用功能")){
            view = request.getRequestDispatcher("WEB-INF/dealersPage/handlebook.jsp");
        }else if(action.equals("用户设置"))
        {
            view = request.getRequestDispatcher("WEB-INF/dealersPage/managecar.jsp");
        }
        else if(action.equals("帮助界面"))
        {
            view = request.getRequestDispatcher("WEB-INF/dealersPage/infosearch.jsp");
        }
        else{
            view = request.getRequestDispatcher("WEB-INF/firstpage.jsp");
        }

        view.forward(request,response);
    }

    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request,response);

    }
}
