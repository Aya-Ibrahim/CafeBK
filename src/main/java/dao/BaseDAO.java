/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import org.hibernate.Session;
import org.hibernate.SessionException;

/**
 *
 * @author < abdelrhman el_hadidy >
 */
public class BaseDAO {

    public BaseDAO() {
    }
    public Object merge(Object user, Session session) {
        Object merged = session.merge(user);
        return merged;
    }

    public Boolean update(Object o, Session session) {
        boolean updated = false;
        try {
            session.update(o);
            updated = true;
        } catch (SessionException e) {
            System.out.println(e.getMessage());
        }
        return updated;
    }

    public Object save(Object user, Session session) {
        Object merged = session.save(user);
        return merged;
    }

    public boolean saveOrUpdate(Object o, Session session) {
        boolean saved = false;
        try {
            session.saveOrUpdate(o);
            saved = true;
        } catch (SessionException e) {
            System.out.println(e.getMessage());
        }
        return saved;
    }

    public boolean Update(Object o, Session session) {
        boolean saved = false;
        try {
            session.update(o);
            saved = true;
        } catch (SessionException e) {
            System.out.println(e.getMessage());
        }
        return saved;
    }

    public void persist(Object o, Session session) {
        try {
            session.persist(o);
        } catch (SessionException e) {
            System.out.println(e.getMessage());
        }
    }
     public void delete(Object o, Session session) {
        try {
            session.delete(o);
        } catch (SessionException e) {
            System.out.println(e.getMessage());
        }
    }
    
}
