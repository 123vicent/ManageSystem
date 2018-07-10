package DAO;

import basic.Shopapt;
import dbcon.DBConnect;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ShopaptDAOImpl implements ShopaptDAO {
    DBConnect dbc = new DBConnect();
    Connection conn = dbc.getConnection();

    public List<Shopapt> findAllByShopId(String shopuser_id){
        List<Shopapt> shopaptList = new ArrayList<Shopapt>();
        String sql = "select * from shopapt where shopuser_id =?";
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1,shopuser_id);
            rs = ps.executeQuery();
            while(rs.next()){
                Shopapt shopapt = new Shopapt();
                shopapt.setShopuser_id(rs.getString(1));
                shopapt.setCus_name(rs.getString(2));
                shopapt.setCus_phone(rs.getString(3));
                shopapt.setAp_type(rs.getString(4));
                shopapt.setAp_time(rs.getTimestamp(5));
                shopapt.setAp_state(rs.getString(6));

                shopaptList.add(shopapt);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return shopaptList;
    }

    public List<Shopapt> findAllByTag(String shopuser_id,String apstate,String aptype,String cusname){
        List<Shopapt> shopaptList = new ArrayList<Shopapt>();
        String sql = "select * from shopapt where shopuser_id=?";
        PreparedStatement ps = null;
        ResultSet rs = null;
        if(!apstate.equals("全部预约"))
        {
            sql+="and ap_state='"+apstate+"'";
        }
        if(!aptype.equals("全部预约"))
        {
            sql+="and ap_type='"+aptype+"'";
        }
        if(!cusname.equals(""))
        {
            sql+="and cus_name='"+cusname+"'";
        }
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1,shopuser_id);
            rs = ps.executeQuery();
            while(rs.next()){
                Shopapt shopapt = new Shopapt();
                shopapt.setShopuser_id(rs.getString(1));
                shopapt.setCus_name(rs.getString(2));
                shopapt.setCus_phone(rs.getString(3));
                shopapt.setAp_type(rs.getString(4));
                shopapt.setAp_time(rs.getTimestamp(5));
                shopapt.setAp_state(rs.getString(6));

                shopaptList.add(shopapt);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return shopaptList;
    }

    public Boolean update(Shopapt shopapt) {
        String sql = "update shopapt set ap_state=? where shopuser_id=?,cus_name=?,ap_time=?";
        PreparedStatement ps = null;

        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1,shopapt.getAp_state());
            ps.setString(2,shopapt.getShopuser_id());
            ps.setString(3,shopapt.getCus_name());
            ps.setTimestamp(4,shopapt.getAp_time());

            ps.execute();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}