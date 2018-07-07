package test;

import DAO.DAOFactory;
import DAO.ShopaptDAO;
import basic.Shopapt;
import model.Shopuser;

import java.util.List;

public class Main {

    public static void main(String []args){
        ShopaptDAO shopaptdao = DAOFactory.getShopaptDAO();
        List<Shopapt> shopaptList = shopaptdao.findAllByShopId("s1");
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
    }
}
