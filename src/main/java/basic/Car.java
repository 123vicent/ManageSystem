package basic;

public class Car {
    private String car_id;
    private String brand;
    private String model;
    private String color;
    private String seats;
    private String type;
    private String power;

    public void setCar_id(String car_id) {
        this.car_id = car_id;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setSeats(String seats) {
        this.seats = seats;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setPower(String power) {
        this.power = power;
    }

    public String getCar_id() {
        return car_id;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public String getColor() {
        return color;
    }

    public String getPower() {
        return power;
    }

    public String getSeats() {
        return seats;
    }

    public String getType() {
        return type;
    }
}
