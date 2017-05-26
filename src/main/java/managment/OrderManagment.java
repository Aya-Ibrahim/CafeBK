/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managment;

import beans.Item;
import beans.Order;
import beans.Service;
import dao.DaoFactory;
import static dao.DaoFactory.ITEMDAO;
import static dao.DaoFactory.ORDERDAO;
import dao.ItemDao;
import dao.OrderDao;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author < abdelrhman el_hadidy >
 */
public class OrderManagment {

    static OrderManagment orderManagment = new OrderManagment();
    OrderDao orderDao;

    private OrderManagment() {
        DaoFactory daoFactory = DaoFactory.getInstance();
        orderDao = (OrderDao) daoFactory.getDAO(ORDERDAO);
    }

    public static OrderManagment getInstance() {
        return orderManagment;
    }

    public List<Order> getAllFinishedOrder(Session session) {
        return orderDao.getAllFinishedOrder(session);
    }

}
