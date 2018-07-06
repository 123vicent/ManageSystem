package DAO;

import basic.Shopapt;

import java.util.List;

public interface ShopaptDAO {
    public List<Shopapt> findAllByShopId(String shopuser_id);
}
