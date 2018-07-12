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

    public Boolean insert(Cusowncar coc) {
        String sql = "insert into cusowncar values (?,?,?,?,?,?)";
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1,coc.getPlate_number());
            ps.setString(2,coc.getShopuser_id());
            ps.setString(3,coc.getCususer_id());
            ps.setString(4,coc.getCar_id());
            ps.setDate(5,coc.getRegister_time());
            ps.setDouble(6,coc.getPayment());

            ps.executeUpdate();
            ps.close();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public Boolean update(Cusowncar coc){
        String sql = "update cusowncar set plate_number=?,shopuser_id=?,cususer_id=?,car_id=?,register_time=?,payment=? " +
                "where plate_number=?";
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1,coc.getPlate_number());
            ps.setString(2,coc.getShopuser_id());
            ps.setString(3,coc.getCususer_id());
            ps.setString(4,coc.getCar_id());
            ps.setDate(5,coc.getRegister_time());
            ps.setDouble(6,coc.getPayment());
            ps.setString(7,coc.getPlate_number());

            ps.executeUpdate();
            ps.close();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public Boolean delete(String plate_number){
        String sql = "delete from cusowncar where plate_number=?";
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1,plate_number);

            ps.executeUpdate();
            ps.close();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public Cusowncar findById(String plate_number){
        Cusowncar coc = new Cusowncar();
        String sql = "select * from cusowncar where plate_number=?";
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1,plate_number);

            rs = ps.executeQuery();
            while(rs.next()){
                coc.setPlate_number(rs.getString(1));
                coc.setShopuser_id(rs.getString(2));
                coc.setCususer_id(rs.getString(3));
                coc.setCar_id(rs.getString(4));
                coc.setRegister_time(rs.getDate(5));
                coc.setPayment(rs.getDouble(6));
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
                coc.setPlate_number(rs.getString(1));
                coc.setShopuser_id(rs.getString(2));
                coc.setCususer_id(rs.getString(3));
                coc.setCar_id(rs.getString(4));
                coc.setRegister_time(rs.getDate(5));
                coc.setPayment(rs.getDouble(6));

                cocList.add(coc);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cocList;
    }
}
