package DAO;

import dbcon.DBConnect;
import model.Maintainrecord;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

//Maintainrecord表DAO实现接口
//含标准insert,update,delete,select（查询返回单个对象或返回对象List两种方法)查询方法
public class MaintainrecordDAOImpl implements MaintainrecordDAO {
    DBConnect dbc = new DBConnect();
    Connection conn = dbc.getConnection();

    public void insert(Maintainrecord m) {
        String sql = "insert into maintainrecord values (?,?,?,?,?,?,?)";
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1,m.getMaintainrecord_id());
            ps.setString(2,m.getShopuser_id());
            ps.setString(3,m.getCususer_id());
            ps.setString(4,m.getCar_id());
            ps.setTimestamp(5,m.getMaintain_time());
            ps.setDouble(6,m.getPayment());
            ps.setString(7,m.getDescription());

            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void update(Maintainrecord m){
        String sql = "update maintainrecord set maintainrecord_id=?,shopuser_id=?,cususer_id=?,car_id=?," +
                "maintain_time=?,payment=?,description=? where maintainrecord_id=?";
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1,m.getMaintainrecord_id());
            ps.setString(2,m.getShopuser_id());
            ps.setString(3,m.getCususer_id());
            ps.setString(4,m.getCar_id());
            ps.setTimestamp(5,m.getMaintain_time());
            ps.setDouble(6,m.getPayment());
            ps.setString(7,m.getDescription());

            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(String matintainrecord_id){
        String sql = "delete from maintainrecord where maintainrecord_id=?";
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1,matintainrecord_id);

            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Maintainrecord findById(String matintainrecord_id){
        Maintainrecord m = new Maintainrecord();
        String sql = "select * from matintainrecord where matintainrecord_id=?";
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1,matintainrecord_id);
            rs = ps.executeQuery();
            if(rs.next()){
                m.setMaintainrecord_id(rs.getString(1));
                m.setShopuser_id(rs.getString(2));
                m.setCususer_id(rs.getString(3));
                m.setCar_id(rs.getString(4));
                m.setMaintain_time(rs.getTimestamp(5));
                m.setPayment(rs.getDouble(6));
                m.setDescription(rs.getString(7));
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }
        return m;
    }

    public List<Maintainrecord> findAll(){
        List<Maintainrecord> maintainList = new ArrayList<Maintainrecord>();
        String sql = "select * from maintainrecord";
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                Maintainrecord m = new Maintainrecord();
                m.setMaintainrecord_id(rs.getString(1));
                m.setShopuser_id(rs.getString(2));
                m.setCususer_id(rs.getString(3));
                m.setCar_id(rs.getString(4));
                m.setMaintain_time(rs.getTimestamp(5));
                m.setPayment(rs.getDouble(6));
                m.setDescription(rs.getString(7));

                maintainList.add(m);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return maintainList;
    }
}
