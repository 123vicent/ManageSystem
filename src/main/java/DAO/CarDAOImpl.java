package DAO;

import dbcon.DBConnect;
import model.Car;

import javax.servlet.RequestDispatcher;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

//Car表DAO实现接口
//含标准insert,update,delete,select（查询返回单个对象或返回对象List两种方法)查询方法
public class CarDAOImpl implements CarDAO {
    DBConnect dbc = new DBConnect();
    Connection conn = dbc.getConnection();

    public Boolean insert(Car c) {
        String sql = "insert into car values (?,?,?,?,?,?,?)";
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1,c.getCar_id());
            ps.setString(2,c.getBrand());
            ps.setString(3,c.getModel());
            ps.setString(4,c.getColor());
            ps.setString(5,c.getSeats());
            ps.setString(6,c.getType());
            ps.setString(7,c.getPower());

            ps.executeUpdate();
            ps.close();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public Boolean update(Car c){
        String sql = "update car set car_id=?,brand=?,model=?,color=?,seats=?,type=?,power=? where car_id=?";
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1,c.getCar_id());
            ps.setString(2,c.getBrand());
            ps.setString(3,c.getModel());
            ps.setString(4,c.getColor());
            ps.setString(5,c.getSeats());
            ps.setString(6,c.getType());
            ps.setString(7,c.getPower());
            ps.setString(8,c.getCar_id());

            ps.executeUpdate();
            ps.close();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public Boolean delete(String car_id){
        String sql = "delete from car where car_id=?";
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1,car_id);

            ps.executeUpdate();
            ps.close();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public Car findById(String car_id){
        Car c = new Car();
        String sql = "select * from car where car_id=?";
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1,car_id);
            rs = ps.executeQuery();
            if(rs.next()){
                c.setCar_id(rs.getString(1));
                c.setBrand(rs.getString(2));
                c.setModel(rs.getString(3));
                c.setColor(rs.getString(4));
                c.setSeats(rs.getString(5));
                c.setType(rs.getString(6));
                c.setPower(rs.getString(7));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return c;
    }

    public List<String> findModelByBrand(String brand){
        List<String> modelList = new ArrayList<String>();
        String sql = "select model from car where brand=?";
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1,brand);
            rs = ps.executeQuery();
            while(rs.next()){
                modelList.add(rs.getString(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return modelList;
    }

    public Car findByBrandModel(String brand,String model){
        Car c = new Car();
        String sql = "select * from car.car where brand=? and model=?";
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1,brand);
            ps.setString(2,model);
            rs = ps.executeQuery();
            if(rs.next()){
                c.setCar_id(rs.getString(1));
                c.setBrand(rs.getString(2));
                c.setModel(rs.getString(3));
                c.setColor(rs.getString(4));
                c.setSeats(rs.getString(5));
                c.setType(rs.getString(6));
                c.setPower(rs.getString(7));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return c;
    }

    public List<Car> findAll(){
        List<Car> carList = new ArrayList<Car>();
        String sql = "select * from car";
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                Car c = new Car();
                c.setCar_id(rs.getString(1));
                c.setBrand(rs.getString(2));
                c.setModel(rs.getString(3));
                c.setColor(rs.getString(4));
                c.setSeats(rs.getString(5));
                c.setType(rs.getString(6));
                c.setPower(rs.getString(7));

                carList.add(c);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return carList;
    }

    public List<String> findAllBrand() {
        List<String> brands = new ArrayList<String>();
        String sql = "select distinct brand from car";
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                brands.add(rs.getString(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return brands;
    }

    public List<String> findAllType() {
        List<String> types = new ArrayList<String>();
        String sql = "select distinct type from car";
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                types.add(rs.getString(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return types;
    }
}
