/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managment;

import beans.CafeTable;
import dao.DaoFactory;
import static dao.DaoFactory.TABLESDAO;
import dao.TablesDao;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author Abdelrahman
 */
public class TablesMangment {

    static TablesMangment TABLEMANEGMENT = new TablesMangment();
    TablesDao tableDao;

    public TablesMangment() {
        DaoFactory daoFactory = DaoFactory.getInstance();
        tableDao = (TablesDao) daoFactory.getDAO(TABLESDAO);
    }

    public static TablesMangment getInstance() {
        return TABLEMANEGMENT;
    }

    public List<CafeTable> getAllTables(Session session) {
        return tableDao.getAllTables(session);
    }
}
