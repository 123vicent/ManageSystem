package DAO;

import model.Maintainrecord;

import java.util.List;

//Maintainrecord表DAO接口
public interface MaintainrecordDAO {
    public void insert(Maintainrecord mr);
    public void update(Maintainrecord mr);
    public void delete(String maintainrecord_id);
    public Maintainrecord findById(String maintainrecord_id);
    public List<Maintainrecord> findAll();
}
