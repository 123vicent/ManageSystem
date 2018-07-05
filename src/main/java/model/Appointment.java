package model;

import java.sql.Date;

public class Appointment {
    private String appointment_id;
    private String cususer_id;
    private String shopuser_id;
    private Date ap_time;
    private String ap_type;

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

    public Date getAp_time() {
        return ap_time;
    }

    public void setAp_time(Date ap_time) {
        this.ap_time = ap_time;
    }

    public String getAp_type() {
        return ap_type;
    }

    public void setAp_type(String ap_type) {
        this.ap_type = ap_type;
    }
}
