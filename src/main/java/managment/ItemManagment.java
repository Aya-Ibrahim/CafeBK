/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managment;

import beans.Item;
import beans.Service;
import dao.DaoFactory;
import static dao.DaoFactory.ITEMDAO;
import dao.ItemDao;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author < abdelrhman el_hadidy >
 */
public class ItemManagment {

    static ItemManagment itemManagment = new ItemManagment();
    ItemDao itemDao;

    private ItemManagment() {
        DaoFactory daoFactory = DaoFactory.getInstance();
        itemDao = (ItemDao) daoFactory.getDAO(ITEMDAO);
    }

    public static ItemManagment getInstance() {
        return itemManagment;
    }

    public List<Item> getAllItemsByServiceId(Service service,Session session) {
        return itemDao.getAllItemsByServiceId(service,session);
    }

}
