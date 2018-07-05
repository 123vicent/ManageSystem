package model;

import java.sql.Date;



public class Cusowncar {
    private String cususer_id;
    private String shopuser_id;
    private String car_id;
    private Date buy_time;
    private double pay_price;

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

    public Date getBuy_time() {
        return buy_time;
    }

    public void setBuy_time(Date buy_time) {
        this.buy_time = buy_time;
    }

    public double getPay_price() {
        return pay_price;
    }

    public void setPay_price(double pay_price) {
        this.pay_price = pay_price;
    }
}
