package DAO;

import model.Car;

import java.util.List;

//Car表DAO接口
public interface CarDAO {
    public void insert(Car car);
    public void update(Car car);
    public void delete(String car_id);
    public Car findById(String car_id);
    public List<String> findModelByBrand(String brand);
    public Car findByBrandModel(String brand,String model);
    public List<Car> findAll();
}
