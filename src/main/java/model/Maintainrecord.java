package model;

import java.sql.Timestamp;


public class Maintainrecord {
    private String maintainrecord_id;
    private String cususer_id;
    private String shopuser_id;
    private String car_id;
    private Timestamp maintain_time;
    private double payment;
    private String description;

    public String getMaintainrecord_id() {
        return maintainrecord_id;
    }

    public void setMaintainrecord_id(String maintainrecord_id) {
        this.maintainrecord_id = maintainrecord_id;
    }

    public String getCususer_id() {
        return cususer_id;
    }

    public void setCususer_id(String cususer_id) {
        this.cususer_id = cususer_id;
    }

    public String getShopuser_id() {
        return shopuser_id;
    }

    public void setShopuser_id(String shopuser_id) {
        this.shopuser_id = shopuser_id;
    }

    public String getCar_id() {
        return car_id;
    }

    public void setCar_id(String car_id) {
        this.car_id = car_id;
    }

    public Timestamp getMaintain_time() {
        return maintain_time;
    }

    public void setMaintain_time(Timestamp maintain_time) {
        this.maintain_time = maintain_time;
    }

    public double getPayment() {
        return payment;
    }

    public void setPayment(double payment) {
        this.payment = payment;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
