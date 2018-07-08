package DAO;

import basic.Carinfo;
import dbcon.DBConnect;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CarinfoDAOImpl implements CarinfoDAO{
    DBConnect dbc = new DBConnect();
    Connection conn = dbc.getConnection();

    public List<Carinfo> findAllByShopId(String shopuser_id){
        List<Carinfo> carinfoList = new ArrayList<Carinfo>();
        String sql = "select * from carinfo where shopuser_id=?";
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1,shopuser_id);
            rs = ps.executeQuery();
            while(rs.next()){
                Carinfo carinfo = new Carinfo();
                carinfo.setShopuser_id(rs.getString(1));
                carinfo.setBrand(rs.getString(2));
                carinfo.setModel(rs.getString(3));
                carinfo.setStock(rs.getInt(4));
                carinfo.setPrice(rs.getDouble(5));
                carinfo.setPic_url(rs.getString(6));

                carinfoList.add(carinfo);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return  carinfoList;
    }

    public List<Carinfo> findAllByTag(String shopuser_id,String brand,String model){
        List<Carinfo> carinfos = new ArrayList<Carinfo>();
        String sql = "select * from carinfo where shopuser_id=?";
        PreparedStatement ps = null;
        ResultSet rs = null;
        if(!(brand.equals("")||brand.equals("全部车辆")))
        {
            sql+="and brand='"+brand+"'";
        }
        if(!model.equals(""))
        {
            sql+="and model='"+model+"'";
        }
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1,shopuser_id);
            rs = ps.executeQuery();
            while(rs.next()){
                Carinfo carinfo = new Carinfo();
                carinfo.setShopuser_id(rs.getString(1));
                carinfo.setBrand(rs.getString(2));
                carinfo.setModel(rs.getString(3));
                carinfo.setStock(rs.getInt(4));
                carinfo.setPrice(rs.getDouble(5));
                carinfo.setPic_url(rs.getString(6));

                carinfos.add(carinfo);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return carinfos;
    }
}
