package server;
import DAO.DAOFactory;
import DAO.ShopaptDAO;
import basic.Shopapt;

import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@SuppressWarnings("serial")
public class HandleBookingServlet extends HttpServlet {
    public void doPost(HttpServletRequest request,
                       HttpServletResponse response)
            throws ServletException, IOException {

        /*ResultSet rs = null;
        DBConnect db   = new DBConnect();
        Connection con   = db.getConnection();
        PreparedStatement ps = null;
        List<Shopapt> apList = new ArrayList<Shopapt>();*/

        RequestDispatcher view;


        HttpSession session = request.getSession();
        String shopuserid = (String)session.getAttribute("userid");

        ShopaptDAO shopaptDAO = DAOFactory.getShopaptDAO();
        String apstate = request.getParameter("appointstate");
        String aptype = request.getParameter("appointtype");
        String cusname = request.getParameter("customername");
        String ap_id = request.getParameter("ap_id");

        List<Shopapt> apList = shopaptDAO.findAllByTag(shopuserid,apstate,aptype,cusname,ap_id);

       /* //获取用户所查询的内容
        String appointstate = request.getParameter("appointstate");
        String appointtype = request.getParameter("appointtype");
        String customername = request.getParameter("customername");
        //确定所要执行的查询操作
        String sql = "select * from shopapt where shopuser_id='"+shopuserid+"'";
        if(!(appointstate.equals("")||appointstate.equals("全部预约")))
        {
            sql+="and ap_state='"+appointstate+"'";
        }
        if(!appointtype.equals(""))
        {
            sql+="and ap_type='"+appointtype+"'";
        }
        if(!customername.equals(""))
        {
            sql+="and cus_name='"+customername+"'";
        }
        if((appointstate.equals("")||appointstate.equals("全部预约"))&&appointtype.equals("")&&customername.equals(""))
        {
            sql="select * from shopapt where shopuser_id='"+shopuserid+"'";
        }
        //
        System.out.println(sql);
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                Shopapt apt = new Shopapt();
                apt.setCus_name(rs.getString(2));
                apt.setCus_phone(rs.getString(3));
                apt.setAp_type(rs.getString(4));
                apt.setAp_time(rs.getDate(5));
                apt.setAp_state(rs.getString(6));
                apList.add(apt);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }*/
        request.setAttribute("userapoint",apList);
        view=request.getRequestDispatcher("ShopPage/funcViewAppointment.jsp");
        String access = request.getParameter("submit");
        view.forward(request,response);
    }

    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request,response);

    }
}
