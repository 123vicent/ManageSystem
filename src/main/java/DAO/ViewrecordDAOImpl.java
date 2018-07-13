package DAO;

import dbcon.DBConnect;
import model.Viewrecord;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

//Viewrecord表DAO实现接口
//含标准insert,update,delete,select（查询返回单个对象或返回对象List两种方法)查询方法
public class ViewrecordDAOImpl implements ViewrecordDAO {
    DBConnect dbc = new DBConnect();
    Connection conn = dbc.getConnection();

    public Boolean insert(Viewrecord vr) {
        String sql = "insert into viewrecord values (?,?,?,?)";
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1,vr.getShopuser_id());
            ps.setString(2,vr.getCar_id());
            ps.setString(3,vr.getCususer_id());
            ps.setTimestamp(4,vr.getView_time());

            ps.executeUpdate();
            ps.close();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public Boolean update(Viewrecord vr){
        String sql = "update viewrecord set shopuser_id=?,car_id=?,cususer_id=?,view_date=?";
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1,vr.getShopuser_id());
            ps.setString(2,vr.getCar_id());
            ps.setString(3,vr.getCususer_id());
            ps.setTimestamp(4,vr.getView_time());

            ps.executeUpdate();
            ps.close();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public Boolean delete(String shopuser_id, String car_id, String cususer_id,Timestamp view_time){
        String sql = "delete from viewrecord where shopuser_id=? and car_id=? and cususer_id=? and view_time=?";
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1,shopuser_id);
            ps.setString(2,car_id);
            ps.setString(3,cususer_id);
            ps.setTimestamp(4,view_time);

            ps.executeUpdate();
            ps.close();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public Viewrecord findById(String shopuser_id, String car_id, String cususer_id,Timestamp view_time){
        Viewrecord vr = new Viewrecord();
        String sql = "select * from viewrecord where shopuser_id=? and car_id=? and cususer_id=? and view_time=?";
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1,shopuser_id);
            ps.setString(2,car_id);
            ps.setString(3,cususer_id);
            ps.setTimestamp(4,view_time);
            rs = ps.executeQuery();
            if(rs.next()){
                vr.setCar_id(rs.getString(1));
                vr.setCususer_id(rs.getString(2));
                vr.setView_time(rs.getTimestamp(3));
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }
        return vr;
    }

    public List<Viewrecord> findAll(){
        List<Viewrecord> vrList = new ArrayList<Viewrecord>();
        String sql = "select * from viewrecord";
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                Viewrecord vr = new Viewrecord();
                vr.setShopuser_id(rs.getString(1));
                vr.setCar_id(rs.getString(2));
                vr.setCususer_id(rs.getString(3));
                vr.setView_time(rs.getTimestamp(4));

                vrList.add(vr);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return vrList;
    }
}
