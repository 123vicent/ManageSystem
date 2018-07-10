package DAO;

import model.Cusowncar;

import java.util.List;

//Cusowncar表DAO接口
public interface CusowncarDAO {
    public Boolean insert(Cusowncar coc);
    public Boolean update(Cusowncar coc);
    public Boolean delete(String shopuser_id,String cususer_id,String car_id);
    public Cusowncar findById(String shopuser_id,String cususer_id,String car_id);
    public List<Cusowncar> findAll();
}
