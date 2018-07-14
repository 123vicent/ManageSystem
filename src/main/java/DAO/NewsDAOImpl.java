package DAO;

import dbcon.DBConnect;
import model.News;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
public class NewsDAOImpl implements NewsDAO{
    DBConnect dbc = new DBConnect();
    Connection conn = dbc.getConnection();

    public boolean insert(News news) {
        String sql = "insert into news values (?,?,?,?)";
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1,news.getShopuser_id());
            ps.setDate(2,news.getTime());
            ps.setString(3,news.getTitle());
            ps.setString(4,news.getContent());
            ps.execute();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<News> findAllToday() {
        List<News> newsList = new ArrayList<News>();
        String sql = "select * from news where time=?";
        PreparedStatement ps = null;
        ResultSet rs = null;
        Date time = new Date(new java.util.Date().getTime());
        try {
            ps = conn.prepareStatement(sql);
            ps.setDate(1,time);
            rs = ps.executeQuery();
            while(rs.next()){
                News news = new News();
                news.setShopuser_id(rs.getString(1));
                news.setTime(rs.getDate(2));
                news.setTitle(rs.getString(3));
                news.setContent(rs.getString(4));
                newsList.add(news);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return newsList;
    }

    public News findById(String shopuser_id, Date time, String title) {
        News news = new News();
        String sql = "select * from news where shopuser_id=? and time=? and title=?";
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1,shopuser_id);
            ps.setDate(2,time);
            ps.setString(3,title);
            rs = ps.executeQuery();
            while(rs.next()){
                news.setShopuser_id(rs.getString(1));
                news.setTime(rs.getDate(2));
                news.setTitle(rs.getString(3));
                news.setContent(rs.getString(4));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return news;
    }

}
