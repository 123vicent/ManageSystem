package DAO;


//DAO工厂类    直接调用以创建接口实例
public class DAOFactory {
    public static AppointmentDAO getAppointmentDAO(){
        return new AppointmentDAOImpl();
    }

    public static CarDAO getCarDAO(){
        return new CarDAOImpl();
    }

    public static CusowncarDAO getCusowncarDAO(){
        return new CusowncarDAOImpl();
    }

    public static CustomeruserDAO getCustometuserDAO(){
        return new CustomeruserDAOImpl();
    }

    public static MaintainrecordDAO getMaintainrecordDAO(){
        return new MaintainrecordDAOImpl();
    }

    public static ShopowncarDAO getShopowncarDAO(){
        return new ShopowncarDAOImpl();
    }

    public static ViewrecordDAO getViewrecordDAO(){
        return new ViewrecordDAOImpl();
    }
}
