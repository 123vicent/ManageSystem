

import DAO.CarinfoDAO;
import DAO.CarviewDAO;
import DAO.DAOFactory;
import DAO.ShopaptDAO;
import basic.Carinfo;
import basic.Carview;
import basic.Shopapt;
import model.Shopuser;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.List;

public class Main {

    public static void main(String []args) {
        Timestamp view_time = new java.sql.Timestamp(new java.util.Date().getTime());
        String time= view_time.toString();
        System.out.println(time);
    }
}
