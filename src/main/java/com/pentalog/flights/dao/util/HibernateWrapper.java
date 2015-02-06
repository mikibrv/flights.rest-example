package com.pentalog.flights.dao.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * User: mcsere Date: 8/6/14 Time: 3:08 PM
 */
@Component
public class HibernateWrapper {

    @Resource
    SessionFactory sessionFactory;

    public Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    public void startTransaction() {
        if (sessionFactory.getCurrentSession().isOpen()) {
            sessionFactory.getCurrentSession().close();
        }
        getSession().beginTransaction();
    }

    public void endTransaction() {
        if (getSession().getTransaction().isActive()) {
            getSession().getTransaction().commit();
        }

    }

}
