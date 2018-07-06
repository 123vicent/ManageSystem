package DAO;

import basic.Shopapt;
import model.Shopuser;

import java.util.List;

public class Main {
    public static void main(String []args){
        ShopaptDAO shopaptdao = DAOFactory.getShopaptDAO();
        List<Shopapt> shopaptList = shopaptdao.findAll();
        for(int i = 0; i<shopaptList.size();i++){
            System.out.println(shopaptList.get(i).getCus_name());
            System.out.println(shopaptList.get(i).getCus_phone());
            System.out.println(shopaptList.get(i).getAp_type());
            System.out.println(shopaptList.get(i).getAp_time());
            System.out.println(shopaptList.get(i).getAp_state());
            System.out.println(shopaptList.size());

        }
    }
}
