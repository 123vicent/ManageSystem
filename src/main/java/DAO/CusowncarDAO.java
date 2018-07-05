package DAO;

import model.Cusowncar;

import java.util.List;

//Cusowncar表DAO接口
public interface CusowncarDAO {
    public void insert(Cusowncar coc);
    public void update(Cusowncar coc);
    public void delete(String shopuser_id,String cususer_id,String car_id);
    public Cusowncar findById(String shopuser_id,String cususer_id,String car_id);
    public List<Cusowncar> findAll();
}
