package model;

import java.sql.Timestamp;

public class Viewrecord {
    private String car_id;
    private String cususer_id;
    private Timestamp view_date;

    public String getCar_id() {
        return car_id;
    }

    public void setCar_id(String car_id) {
        this.car_id = car_id;
    }

    public String getCususer_id() {
        return cususer_id;
    }

    public void setCususer_id(String cususer_id) {
        this.cususer_id = cususer_id;
    }

    public Timestamp getView_date() {
        return view_date;
    }

    public void setView_date(Timestamp view_date) {
        this.view_date = view_date;
    }
}
