package DAO;

import model.Maintainrecord;

import java.util.List;

//Maintainrecord表DAO接口
public interface MaintainrecordDAO {
    public Boolean insert(Maintainrecord mr);
    public Boolean update(Maintainrecord mr);
    public Boolean delete(String maintainrecord_id);
    public Maintainrecord findById(String maintainrecord_id);
    public List<Maintainrecord> findAll();
}
