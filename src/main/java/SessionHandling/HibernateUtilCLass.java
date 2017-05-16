/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SessionHandling;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author fe
 */
public class HibernateUtilCLass {
     private static final SessionFactory sessionFactory;

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
     static {
        try {
            sessionFactory =new Configuration().configure().buildSessionFactory();
            System.err.println("build seesion factory  >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
        } catch (Throwable ex) {
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }
     public static Session getSession() throws HibernateException {
        return sessionFactory.openSession();
    }

    public static Session getCurrentSession() throws HibernateException {
        return sessionFactory.getCurrentSession();
    }
}
