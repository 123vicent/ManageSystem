package DAO;

import dbcon.DBConnect;
import model.Cusowncar;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

//Cusowncar表DAO实现接口
//含标准insert,update,delete,select（查询返回单个对象或返回对象List两种方法)查询方法
public class CusowncarDAOImpl implements CusowncarDAO {
    DBConnect dbc = new DBConnect();
    Connection conn = dbc.getConnection();

    public void insert(Cusowncar coc) {
        String sql = "insert into cusowncar values (?,?,?,?,?)";
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1,coc.getShopuser_id());
            ps.setString(2,coc.getCususer_id());
            ps.setString(3,coc.getCar_id());
            ps.setDate(4,coc.getBuy_time());
            ps.setDouble(5,coc.getPay_price());

            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void update(Cusowncar coc){
        String sql = "update cusowncar set shopuser_id=?,cususer_id=?,car_id=?,buy_time=?,pay_price=? " +
                "where shopuser_id=? and cususer_id=? and car_id=?";
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1,coc.getShopuser_id());
            ps.setString(2,coc.getCususer_id());
            ps.setString(3,coc.getCar_id());
            ps.setDate(4,coc.getBuy_time());
            ps.setDouble(5,coc.getPay_price());
            ps.setString(6,coc.getShopuser_id());
            ps.setString(7,coc.getCususer_id());
            ps.setString(8,coc.getCar_id());

            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(String shopuser_id,String cususer_id,String car_id){
        String sql = "delete from cusowncar where shopuser_id=? and cususer_id=? and car_id=?";
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1,shopuser_id);
            ps.setString(2,cususer_id);
            ps.setString(3,car_id);

            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Cusowncar findById(String shopuser_id,String cususer_id,String car_id){
        Cusowncar coc = new Cusowncar();
        String sql = "select * from cusowncar where shopuser_id=? and cususer_id=? and car_id=?";
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1,shopuser_id);
            ps.setString(2,cususer_id);
            ps.setString(3,car_id);
            rs = ps.executeQuery();
            if(rs.next()){
                coc.setShopuser_id(rs.getString(1));
                coc.setCususer_id(rs.getString(2));
                coc.setCar_id(rs.getString(3));
                coc.setBuy_time(rs.getDate(4));
                coc.setPay_price(rs.getDouble(5));
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }
        return coc;
    }

    public List<Cusowncar> findAll(){
        List<Cusowncar> cocList = new ArrayList<Cusowncar>();
        String sql = "select * from cusowncar";
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                Cusowncar coc = new Cusowncar();
                coc.setShopuser_id(rs.getString(1));
                coc.setCususer_id(rs.getString(2));
                coc.setCar_id(rs.getString(3));
                coc.setBuy_time(rs.getDate(4));
                coc.setPay_price(rs.getDouble(5));

                cocList.add(coc);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cocList;
    }
}
