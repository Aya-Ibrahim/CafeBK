/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managment;

import beans.Tab;
import dao.DaoFactory;
import static dao.DaoFactory.TABDAO;
import dao.TabDao;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author Abdelrahman
 */
public class TabMangment {

    static TabMangment TABMANEGMENT = new TabMangment();
    TabDao TabDao;
    

    public TabMangment() {
        DaoFactory daoFactory = DaoFactory.getInstance();
        TabDao = (TabDao) daoFactory.getDAO(TABDAO);
    }

    public static TabMangment getInstance() {
        return TABMANEGMENT;
    }

    public List<Tab> getAllTabs(Session session) {
        return TabDao.getAllTables(session);
    }

}
