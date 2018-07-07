package model;

import java.sql.Date;
import java.sql.Timestamp;

public class Appointment {
    private String appointment_id;
    private String cususer_id;
    private String shopuser_id;
    private Timestamp ap_time;
    private String ap_type;
    private String ap_state;

    public String getAppointment_id() {
        return appointment_id;
    }

    public void setAppointment_id(String appointment_id) {
        this.appointment_id = appointment_id;
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

    public Timestamp getAp_time() {
        return ap_time;
    }

    public void setAp_time(Timestamp ap_time) {
        this.ap_time = ap_time;
    }

    public String getAp_type() {
        return ap_type;
    }

    public void setAp_type(String ap_type) {
        this.ap_type = ap_type;
    }

    public String getAp_state() {
        return ap_state;
    }

    public void setAp_state(String ap_state) {
        this.ap_state = ap_state;
    }
}
