/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import beans.CafeTable;
import beans.Order;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author Abdelrahman
 */
public class TablesDao {

    static TablesDao userdao = new TablesDao();

    public TablesDao() {
    }

    public static TablesDao getInstance() {
        return userdao;
    }

    public List<CafeTable> getAllTables(Session session) {
        List<CafeTable> tables = new ArrayList<>();
        Query createQuery = session.createQuery("from CafeTable");
        tables = createQuery.list();
        return tables;
    }

    public List<CafeTable> getTablesWithCriteria(Session session, boolean empty) {
        List<CafeTable> tables = new ArrayList<>();
//         hadidy changes to named parameter to avoid sql injection
//        Query createQuery = session.createQuery("from CafeTable c where c.empty = " + empty);
        Query createQuery = session.createQuery("from CafeTable c where c.empty =:TableStatus ");
        createQuery.setParameter("TableStatus", empty);
        tables = createQuery.list();
        return tables;
    }

    public Order getLatestOrder(Session session, int tableId) {
        List<Order> orders = new ArrayList<>();
        Query createQuery = session.createQuery(
                "from Order o where o.cafeTable.tableId=" + tableId + " order by o.orderDate desc ");
        orders = createQuery.list();

        return (orders != null) ? orders.get(0) : null;
    }

}
