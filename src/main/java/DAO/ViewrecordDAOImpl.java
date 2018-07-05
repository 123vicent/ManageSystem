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

    public void insert(Viewrecord vr) {
        String sql = "insert into viewrecord values (?,?,?)";
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1,vr.getCar_id());
            ps.setString(2,vr.getCususer_id());
            ps.setTimestamp(3,vr.getView_date());

            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void update(Viewrecord vr){
        String sql = "update viewrecord set car_id=?,cususer_id=?,view_date=?";
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1,vr.getCar_id());
            ps.setString(2,vr.getCususer_id());
            ps.setTimestamp(3,vr.getView_date());

            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(String car_id, String cususer_id,Timestamp view_time){
        String sql = "delete from viewrecord where car_id=?,cususer_id=?,view_time=?";
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1,car_id);
            ps.setString(2,cususer_id);
            ps.setTimestamp(3,view_time);

            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Viewrecord findById(String car_id, String cususer_id,Timestamp view_time){
        Viewrecord vr = new Viewrecord();
        String sql = "select * from viewrecord where car_id=?,cususer_id=?,view_time=?";
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1,car_id);
            ps.setString(2,cususer_id);
            ps.setTimestamp(3,view_time);
            rs = ps.executeQuery();
            vr.setCar_id(rs.getString(1));
            vr.setCususer_id(rs.getString(2));
            vr.setView_date(rs.getTimestamp(3));


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
            if(rs.next()){
                Viewrecord vr = new Viewrecord();
                vr.setCar_id(rs.getString(1));
                vr.setCususer_id(rs.getString(2));
                vr.setView_date(rs.getTimestamp(3));

                vrList.add(vr);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return vrList;
    }
}
