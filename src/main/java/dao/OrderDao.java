/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import beans.Item;
import beans.Order;
import beans.Service;
import java.util.ArrayList;
import java.util.List;
import lookUp.Order_OrderLineStatus;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author < abdelrhman el_hadidy >
 */
public class OrderDao extends BaseDAO{

    static OrderDao orderDao = new OrderDao();

    private OrderDao() {
    }

    public static OrderDao getInstance() {
        return orderDao;
    }

    public List<Order> getAllFinishedOrder(Session session) {
        List<Order> items = new ArrayList<Order>();
        Query Query = session.createQuery("from Order where status =:MyStatus");
        Query.setParameter("MyStatus", Order_OrderLineStatus.FINISHED.toString());
        items = Query.list();
        return items;
    }

    public Order getOrderById(Integer orderId, Session session) {
        Order order = null;
        Query Query = session.createQuery("from Order order where order.orderId =:MyId");
        Query.setParameter("MyId", orderId);
        order = (Order) Query.uniqueResult();
        return order;
    }

}
