/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import beans.CafeTable;
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
        List<CafeTable> tables = new ArrayList<CafeTable>();
        Query createQuery = session.createQuery("from CafeTable");
        tables = createQuery.list();
        return tables;
    }

}
