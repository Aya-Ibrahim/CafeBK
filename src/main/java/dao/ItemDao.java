/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import beans.Item;
import beans.Service;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author < abdelrhman el_hadidy >
 */
public class ItemDao {

    static ItemDao itemDao = new ItemDao();

    private ItemDao() {
    }

    public static ItemDao getInstance() {
        return itemDao;
    }

    public List<Item> getAllItemsByServiceId(Service service, Session session) {
        List<Item> items = new ArrayList<Item>();
        Query Query = session.createQuery("from Item where service=:MyService and isActive is true ");
        Query.setParameter("MyService", service);
        items = Query.list();
        return items;

    }

}
