/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managment;

import beans.Item;
import beans.Order;
import beans.Orderline;
import beans.Service;
import dao.DaoFactory;
import static dao.DaoFactory.ITEMDAO;
import static dao.DaoFactory.ORDERDAO;
import dao.ItemDao;
import dao.OrderDao;
import java.util.List;
import java.util.Set;
import lookUp.Order_OrderLineStatus;
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

    public Boolean serveOrder(Order order, Session session) {
        Boolean updated = false;
        if (order != null) {
            Order orderById = orderDao.getOrderById(order.getOrderId(), session);
            orderById.setStatus(Order_OrderLineStatus.SERVED.toString());
            Set<Orderline> orderlines = orderById.getOrderlines();
            for (Orderline orderline : orderlines) {
                if (orderline.getStatus().equals(Order_OrderLineStatus.FINISHED.toString())) {
                    orderline.setStatus(Order_OrderLineStatus.SERVED.toString());
                    orderDao.update(orderline, session);
                } else {
                    orderById.setStatus(Order_OrderLineStatus.NEW.toString());
                }
            }
             updated = orderDao.update(orderById, session);
        }
        return updated;

    }

    public Order getTableLastOrder(Order order, Session session) {
        return orderDao.getOrderById(order.getOrderId(), session);
        
    }

}
