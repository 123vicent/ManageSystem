package DAO;

import basic.Countinfo;
import basic.Cusviewcar;
import basic.Viewcarrecord;
import dbcon.DBConnect;

import javax.servlet.RequestDispatcher;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ViewcarrecordDAOImpl implements ViewcarrecordDAO{
    DBConnect dbc = new DBConnect();
    Connection conn = dbc.getConnection();

    public List<Countinfo> findAllByShopId(String shopuser_id) {
        List<Countinfo> countinfos = new ArrayList<Countinfo>();
        String sql = "select brand,model,count(distinct cususer_id),count(*) from viewcarrecord where shopuser_id=? group by brand,model";
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1,shopuser_id);
            rs = ps.executeQuery();
            while(rs.next()){
                Countinfo countinfo = new Countinfo();
                countinfo.setBrand(rs.getString(1));
                countinfo.setModel(rs.getString(2));
                countinfo.setDistinct(rs.getInt(3));
                countinfo.setTotalcount(rs.getInt(4));
                countinfos.add(countinfo);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return countinfos;
    }

    public List<Countinfo> findCountByCon(String shopuser_id, String brand, String model, String start, String end){
        List<Countinfo> counts = new ArrayList<Countinfo>();
        String sql = "select brand,model,count(distinct cususer_id),count(*) from viewcarrecord where shopuser_id=?";

        if(!brand.equals("")){
            sql += " and brand='"+brand+"'";
        }
        if(!model.equals("")){
            sql += " and model='"+model+"'";
        }
        if(!start.equals("")){
            Timestamp start_time = Timestamp.valueOf(start);
            sql += " and view_time>'"+start_time+"'";
        }
        if(!end.equals("")){
            Timestamp end_time = Timestamp.valueOf(end);
            sql += " and view_time<'"+end_time+"'";
        }
        sql +=" group by brand,model";
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1,shopuser_id);
            rs = ps.executeQuery();
            while(rs.next()){
                Countinfo countinfo = new Countinfo();
                countinfo.setBrand(rs.getString(1));
                countinfo.setModel(rs.getString(2));
                countinfo.setDistinct(rs.getInt(3));
                countinfo.setTotalcount(rs.getInt(4));
                counts.add(countinfo);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return counts;
    }

    public List<Viewcarrecord> findAllByCusId(String cususer_id) {
        List<Viewcarrecord> viewcarrecords = new ArrayList<Viewcarrecord>();
        String sql = "select * from viewcarrecord where cususer_id=? order by view_time desc";
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1,cususer_id);
            rs = ps.executeQuery();
            while(rs.next()){
                Viewcarrecord vcr = new Viewcarrecord();
                vcr.setShopuser_id(rs.getString(1));
                vcr.setBrand(rs.getString(2));
                vcr.setModel(rs.getString(3));
                vcr.setCususer_id(rs.getString(4));
                vcr.setView_time(rs.getTimestamp(5));
                viewcarrecords.add(vcr);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return viewcarrecords;
    }

    public List<Cusviewcar> findAllCus(String shopuser_id, String brand, String model) {
        List<Cusviewcar> cvcList = new ArrayList<Cusviewcar>();
        String sql = "select cususer_id,count(cususer_id) from viewcarrecord where shopuser_id=? and brand=? and model=? group by cususer_id";
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1,shopuser_id);
            ps.setString(2,brand);
            ps.setString(3,model);
            rs = ps.executeQuery();
            CustomeruserDAO customeruserDAO = DAOFactory.getCustometuserDAO();
            while(rs.next()){
                Cusviewcar cvc = new Cusviewcar();
                cvc.setCususer_id(rs.getString(1));
                cvc.setCus_name(customeruserDAO.findById(rs.getString(1)).getCus_name());
                cvc.setCus_phone(customeruserDAO.findById(rs.getString(1)).getCus_phone());
                cvc.setCount(rs.getInt(2));
                cvcList.add(cvc);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cvcList;
    }

}
