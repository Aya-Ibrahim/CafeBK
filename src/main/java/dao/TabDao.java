/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import beans.Tab;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author Abdelrahman
 */
public class TabDao {

    static TabDao TABDAO = new TabDao();

    public TabDao() {
    }

    public static TabDao getInstance() {
        return TABDAO;
    }

    public List<Tab> getAllTables(Session session) {
        List<Tab> tab = new ArrayList<Tab>();
        Query createQuery = session.createQuery("from Tab");
        tab = createQuery.list();
        return tab;
    }

}
