/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SessionHandling;


import org.apache.log4j.Logger;
import org.hibernate.Session;

/**
 *
 * @author Abdelrhman Elsayed
 */
public class SessionHandler {

    
//    static Logger log = Logger.getLogger(SessionHandler.class.getName());

    /**
     *
     * @return
     */
    public Session openAndGetSession() {
//        log.info("------------------------------------------------------------");
//        log.info("start using  openAndGetSession method  ");
        Session session = HibernateUtilCLass.getSession();
        session.beginTransaction();
        return session;
    }

    /**
     *
     * @param session
     */
    public void closeSessionAndCommite(Session session) {
//        log.info("------------------------------------------------------------");
//        log.info("start using  closeSessionAndCommite method  ");
        session.getTransaction().commit();
        session.close();
    }

    /**
     *
     * @param session
     */
    public void roleBackAndCloseSession(Session session) {
//        log.info("------------------------------------------------------------");
//        log.info("start using  roleBackAndCloseSession method  ");
        session.getTransaction().rollback();
        session.close();
//        log.warn("could not save or update object or more and role back the whole transction ");
    }
}
