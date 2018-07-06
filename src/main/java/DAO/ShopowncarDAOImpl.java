package DAO;

import dbcon.DBConnect;
import model.Shopowncar;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

//shopowncar表DAO实现接口
//含标准insert,update,delete,select（查询返回单个对象或返回对象List两种方法)查询方法
public class ShopowncarDAOImpl implements ShopowncarDAO {
    DBConnect dbc = new DBConnect();
    Connection conn = dbc.getConnection();

    public void insert(Shopowncar soc) {
        String sql = "insert into shopowncar values (?,?,?,?,?)";
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1,soc.getShopuser_id());
            ps.setString(2,soc.getCar_id());
            ps.setInt(3,soc.getStock());
            ps.setDouble(4,soc.getPrice());
            ps.setString(5,soc.getPic_url());

            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void update(Shopowncar soc){
        String sql = "update shopowncar set shopuser_id=?,car_id=?,stock=?,price=?,pic_url=? where shopuser_id=? and car_id=?";
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1,soc.getShopuser_id());
            ps.setString(2,soc.getCar_id());
            ps.setInt(3,soc.getStock());
            ps.setDouble(4,soc.getPrice());
            ps.setString(5,soc.getPic_url());
            ps.setString(6,soc.getShopuser_id());
            ps.setString(7,soc.getCar_id());

            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(String shopuser_id,String car_id){
        String sql = "delete from shopowncar where shopuser_id=? and car_id=?";
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1,shopuser_id);
            ps.setString(2,car_id);

            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Shopowncar findById(String shopuser_id,String car_id){
        Shopowncar soc = new Shopowncar();
        String sql = "select * from shopowncar where shopuser_id=? and car_id=?";
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1,shopuser_id);
            ps.setString(2,car_id);
            rs = ps.executeQuery();
            if(rs.next()){
                soc.setShopuser_id(rs.getString(1));
                soc.setCar_id(rs.getString(2));
                soc.setStock(rs.getInt(3));
                soc.setPrice(rs.getDouble(4));
                soc.setPic_url(rs.getString(5));
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }
        return soc;
    }

    public List<Shopowncar> findAll(){
        List<Shopowncar> socList = new ArrayList<Shopowncar>();
        String sql = "select * from maintainrecord";
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                Shopowncar soc = new Shopowncar();
                soc.setShopuser_id(rs.getString(1));
                soc.setCar_id(rs.getString(2));
                soc.setStock(rs.getInt(3));
                soc.setPrice(rs.getDouble(4));
                soc.setPic_url(rs.getString(5));

                socList.add(soc);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return socList;
    }
}
