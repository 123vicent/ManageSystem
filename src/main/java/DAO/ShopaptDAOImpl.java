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

    public List<Shopapt> findAll(){
        List<Shopapt> shopaptList = new ArrayList<Shopapt>();
        String sql = "select * from shopapt";
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                Shopapt shopapt = new Shopapt();
                shopapt.setCus_name(rs.getString(1));
                shopapt.setCus_phone(rs.getString(2));
                shopapt.setAp_type(rs.getString(3));
                shopapt.setAp_time(rs.getTimestamp(4));
                shopapt.setAp_state(rs.getString(5));

                shopaptList.add(shopapt);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return shopaptList;
    }
}
