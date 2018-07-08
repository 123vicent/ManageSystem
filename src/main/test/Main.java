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
        int k ;
        String id;
        for(int i = 0;i<5;i++)
        {
             k = (int) Math.random()*10;
             String str = Integer.toString(k);
             id+=str;
        }
        System.out.println(id);
    }
}
