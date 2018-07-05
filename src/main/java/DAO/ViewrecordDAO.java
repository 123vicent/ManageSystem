package DAO;

import model.Viewrecord;

import java.sql.Timestamp;
import java.util.List;

//Viewrecord表DAO接口
public interface ViewrecordDAO {
    public void insert(Viewrecord vr);
    public void update(Viewrecord vr);
    public void delete(String car_id, String cususer_id,Timestamp view_time);
    public Viewrecord findById(String car_id, String cususer_id,Timestamp view_time);
    public List<Viewrecord> findAll();
}
