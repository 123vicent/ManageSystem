package test;

import DAO.CarinfoDAO;
import DAO.DAOFactory;
import DAO.ShopaptDAO;
import basic.Carinfo;
import basic.Shopapt;
import model.Shopuser;

import java.util.List;

public class Main {

    public static void main(String []args){
        //test shopaptDAO
        ShopaptDAO shopaptdao = DAOFactory.getShopaptDAO();
        List<Shopapt> shopaptList = shopaptdao.findAllByTag("s1","","","","");
        System.out.print("车店id ");
        System.out.print("客户姓名 ");
        System.out.print("联系方式 ");
        System.out.print("预约类型 ");
        System.out.print("预约时间 ");
        System.out.print("预约状态 ");
        System.out.println();


        for(int i = 0; i<shopaptList.size();i++){
            System.out.print(shopaptList.get(i).getShopuser_id()+" ");
            System.out.print(shopaptList.get(i).getCus_name()+" ");
            System.out.print(shopaptList.get(i).getCus_phone()+" ");
            System.out.print(shopaptList.get(i).getAp_type()+" ");
            System.out.print(shopaptList.get(i).getAp_time()+" ");
            System.out.print(shopaptList.get(i).getAp_state()+" ");
            System.out.print(shopaptList.size());
            System.out.println();
        }

        //test carinfoDAO
        CarinfoDAO carinfoDAO = DAOFactory.getCarinfoDAO();
        List<Carinfo> carinfoList = carinfoDAO.findAllByTag("s1","","","");
        System.out.print("车店id ");
        System.out.print("品牌 ");
        System.out.print("型号 ");
        System.out.print("库存 ");
        System.out.print("价格 ");
        System.out.print("图片 ");
        System.out.println();

        for(int i = 0; i<carinfoList.size();i++){
            System.out.print(carinfoList.get(i).getShopuser_id()+" ");
            System.out.print(carinfoList.get(i).getBrand()+" ");
            System.out.print(carinfoList.get(i).getModel()+" ");
            System.out.print(carinfoList.get(i).getStock()+" ");
            System.out.print(carinfoList.get(i).getPrice()+" ");
            System.out.print(carinfoList.get(i).getPic_url()+" ");
            System.out.print(shopaptList.size());
            System.out.println();
        }

    }
}
