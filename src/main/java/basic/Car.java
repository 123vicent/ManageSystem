package basic;

public class Car {
    private String Car_id;
    private String Brand;
    private String Model;
    private String Seats;
    private String Type;
    private String Color;
    private String Power;

    public String getType() {
        return Type;
    }

    public String getSeats() {
        return Seats;
    }

    public String getPower() {
        return Power;
    }

    public String getColor() {
        return Color;
    }

    public String getModel() {
        return Model;
    }

    public String getBrand() {
        return Brand;
    }

    public String getCar_id() {
        return Car_id;
    }

    public void setPower(String power) {
        Power = power;
    }

    public void setType(String type) {
        Type = type;
    }

    public void setSeats(String seats) {
        Seats = seats;
    }

    public void setColor(String color) {
        Color = color;
    }

    public void setModel(String model) {
        Model = model;
    }

    public void setBrand(String brand) {
        Brand = brand;
    }

    public void setCar_id(String car_id) {
        Car_id = car_id;
    }
}
