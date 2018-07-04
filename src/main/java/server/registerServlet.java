package server;

import dbcon.DBConnect;

import java.io.IOException;
import java.sql.SQLException;
import java.sql.Statement;
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
        String email = request.getParameter("email");

        DBConnect db = new DBConnect();
        Statement stmt = db.connect();


        String access = request.getParameter("submit");

    }

    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request,response);

    }
}
