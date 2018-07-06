package DAO;

import dbcon.DBConnect;
import model.Customeruser;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

//Customeruser表DAO实现接口
//含标准insert,update,delete,select（查询返回单个对象或返回对象List两种方法)查询方法
public class CustomeruserDAOImpl implements CustomeruserDAO {
    DBConnect dbc = new DBConnect();
    Connection conn = dbc.getConnection();

    public void insert(Customeruser cu) {
        String sql = "insert into customeruser values (?,?,?)";
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1,cu.getCususer_id());
            ps.setString(2,cu.getCus_name());
            ps.setString(3,cu.getCus_phone());

            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void update(Customeruser cu){
        String sql = "update customeruser set cususer_id=?,cus_name=?,cus_phone=? where cususer_id=?";
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1,cu.getCususer_id());
            ps.setString(2,cu.getCus_name());
            ps.setString(3,cu.getCus_phone());
            ps.setString(4,cu.getCususer_id());

            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(String cususer_id){
        String sql = "delete from customeruser where cususer_id=?";
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1,cususer_id);

            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Customeruser findById(String cususer_id){
        Customeruser cu = new Customeruser();
        String sql = "select * from customeruser where cususer_id=?";
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1,cususer_id);
            rs = ps.executeQuery();
            if(rs.next()){
                cu.setCususer_id(rs.getString(1));
                cu.setCus_name(rs.getString(2));
                cu.setCus_phone(rs.getString(3));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cu;
    }

    public List<Customeruser> findAll(){
        List<Customeruser> cusList = new ArrayList<Customeruser>();
        String sql = "select * from customeruser";
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                Customeruser cu = new Customeruser();
                cu.setCususer_id(rs.getString(1));
                cu.setCus_name(rs.getString(2));
                cu.setCus_phone(rs.getString(3));

                cusList.add(cu);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cusList;
    }
}
