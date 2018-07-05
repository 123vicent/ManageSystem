package DAO;

import model.Appointment;

import java.util.List;

//Appointment表DAO接口
public interface AppointmentDAO {
    public void insert(Appointment a);
    public void update(Appointment a);
    public void delete(String ap_id);
    public Appointment findById(String ap_id);
    public List<Appointment> findAll();
}
