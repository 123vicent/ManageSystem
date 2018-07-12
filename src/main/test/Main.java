

import DAO.CarinfoDAO;
import DAO.CarviewDAO;
import DAO.DAOFactory;
import DAO.ShopaptDAO;
import basic.Carinfo;
import basic.Carview;
import basic.Shopapt;
import model.Shopuser;

import java.util.List;

public class Main {

    public static void main(String []args) {
        CarviewDAO carviewDAO = DAOFactory.getCarviewDAO();
        List<Carview> carviews = carviewDAO.findAllByCon("","","");
        for(int i=0;i<carviews.size();i++){
            System.out.println(carviews.get(i).getBrand());
            System.out.println(carviews.get(i).getModel());
       }
    }
}
