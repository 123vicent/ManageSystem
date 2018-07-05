package DAO;

import model.Shopuser;

import java.util.List;

//Shopuser表DAO接口
public interface ShopuserDAO {
    public void insert(Shopuser shopuser);
    public void update(Shopuser shopuser);
    public void delete(String shopuser_id);
    public Shopuser findById(String shopuser_id);
    public List<Shopuser> findAll();
}
