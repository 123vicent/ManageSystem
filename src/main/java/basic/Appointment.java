package basic;

public class Appointment {
    private String appoint_id;
    private String customer_name;
    private String appoint_type;
    private String appoint_time;
    private String appoint_state;
    private String customer_call;

    public String getAppoint_id() {
        return appoint_id;
    }

    public String getAppoint_state() {
        return appoint_state;
    }

    public String getAppoint_time() {
        return appoint_time;
    }

    public String getAppoint_type() {
        return appoint_type;
    }

    public String getCustomer_call() {
        return customer_call;
    }

    public String getCustomer_name() {
        return customer_name;
    }

    public void setAppoint_id(String appoint_id) {
        this.appoint_id = appoint_id;
    }

    public void setAppoint_state(String appoint_state) {
        this.appoint_state = appoint_state;
    }

    public void setAppoint_time(String appoint_time) {
        this.appoint_time = appoint_time;
    }

    public void setAppoint_type(String appoint_type) {
        this.appoint_type = appoint_type;
    }

    public void setCustomer_call(String customer_call) {
        this.customer_call = customer_call;
    }

    public void setCustomer_name(String customer_name) {
        this.customer_name = customer_name;
    }
}
