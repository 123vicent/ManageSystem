package DAO;

import model.Shopowncar;

import java.util.List;

//Shopowncar表DAO接口
public interface ShopowncarDAO {
    public void insert(Shopowncar shopowncar);
    public void update(Shopowncar shopowncar);
    public void delete(String shopuser_id,String car_id);
    public Shopowncar findById(String shopuser_id,String car_id);
    public List<Shopowncar> findAll();
}
