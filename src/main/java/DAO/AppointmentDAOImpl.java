package DAO;


import dbcon.DBConnect;
import model.Appointment;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

//Appointment表DAO实现接口
//含标准insert,update,delete,select（查询返回单个对象或返回对象List两种方法)查询方法
public class AppointmentDAOImpl implements AppointmentDAO {
    DBConnect dbc = new DBConnect();
    Connection conn = dbc.getConnection();

    public Boolean insert(Appointment a) {
        String sql = "insert into appointment values (?,?,?,?,?,?,?,?,?,?)";
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1,a.getAppointment_id());
            ps.setString(2,a.getCususer_id());
            ps.setString(3,a.getShopuser_id());
            ps.setString(4,a.getCar_id());
            ps.setTimestamp(5,a.getAp_time());
            ps.setString(6,a.getAp_type());
            ps.setString(7,a.getAp_state());
            ps.setTimestamp(8,a.getComplete_time());
            ps.setDouble(9,a.getPayment());
            ps.setString(10,a.getDescription());

            ps.executeUpdate();
            ps.close();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public Boolean update(Appointment a){
        String sql = "update appointment set appointment_id=?,cususer_id=?,shopuser_id=?,car_id=?,ap_time=?," +
                "ap_type=?,ap_state=?,complete_time=?,payment=?,description=? where appointment_id=?";
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1,a.getAppointment_id());
            ps.setString(2,a.getCususer_id());
            ps.setString(3,a.getShopuser_id());
            ps.setString(4,a.getCar_id());
            ps.setTimestamp(5,a.getAp_time());
            ps.setString(6,a.getAp_type());
            ps.setString(7,a.getAp_state());
            ps.setTimestamp(8,a.getComplete_time());
            ps.setDouble(9,a.getPayment());
            ps.setString(10,a.getDescription());
            ps.setString(11,a.getAppointment_id());

            ps.executeUpdate();
            ps.close();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public Boolean delete(String ap_id){
        String sql = "delete from appointment where appointment_id=?";
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1,ap_id);

            ps.executeUpdate();
            ps.close();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public Appointment findById(String ap_id){
        Appointment apt = new Appointment();
        String sql = "select * from appointment where appointment_id=?";
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1,ap_id);
            rs = ps.executeQuery();
            if(rs.next()){
                apt.setAppointment_id(rs.getString(1));
                apt.setCususer_id(rs.getString(2));
                apt.setShopuser_id(rs.getString(3));
                apt.setCar_id(rs.getString(4));
                apt.setAp_time(rs.getTimestamp(5));
                apt.setAp_type(rs.getString(6));
                apt.setAp_state(rs.getString(7));
                apt.setComplete_time(rs.getTimestamp(8));
                apt.setPayment(rs.getDouble(9));
                apt.setDescription(rs.getString(10));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return apt;
    }

    public List<Appointment> findAll(){
        List<Appointment> apList = new ArrayList<Appointment>();
        String sql = "select * from appointment";
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                Appointment apt = new Appointment();
                apt.setAppointment_id(rs.getString(1));
                apt.setCususer_id(rs.getString(2));
                apt.setShopuser_id(rs.getString(3));
                apt.setCar_id(rs.getString(4));
                apt.setAp_time(rs.getTimestamp(5));
                apt.setAp_type(rs.getString(6));
                apt.setAp_state(rs.getString(7));
                apt.setComplete_time(rs.getTimestamp(8));
                apt.setPayment(rs.getDouble(9));
                apt.setDescription(rs.getString(10));
                apList.add(apt);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return apList;
    }
}
