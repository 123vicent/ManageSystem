package DAO;

import model.Car;

import java.util.List;

//Car表DAO接口
public interface CarDAO {
    public Boolean insert(Car car);
    public Boolean update(Car car);
    public Boolean delete(String car_id);
    public Car findById(String car_id);
    public List<String> findModelByBrand(String brand);
    public Car findByBrandModel(String brand,String model);
    public List<Car> findAll();
}
