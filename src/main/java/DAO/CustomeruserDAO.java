package DAO;

import model.Customeruser;

import java.util.List;

//Customeruser表DAO接口
public interface CustomeruserDAO {
    public void insert(Customeruser cu);
    public void update(Customeruser cu);
    public void delete(String cususer_id);
    public Customeruser findById(String cususer_id);
    public List<Customeruser> findAll();
}
