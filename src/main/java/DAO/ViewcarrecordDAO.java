package DAO;

import basic.Countinfo;
import basic.Viewcarrecord;

import java.sql.Timestamp;
import java.util.List;

public interface ViewcarrecordDAO {
    public List<Countinfo> findAllByShopId(String shopuser_id);
    public List<Countinfo> findCountByCon(String shopuser_id, String brand, String model, String start, String end);
    public List<Viewcarrecord> findAllByCusId(String cususer_id);
}
