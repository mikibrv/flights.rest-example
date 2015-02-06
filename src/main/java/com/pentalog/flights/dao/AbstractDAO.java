package com.pentalog.flights.dao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.annotation.Resource;

import com.pentalog.flights.dao.util.HibernateWrapper;
import org.hibernate.Criteria;
import org.hibernate.LockOptions;
import org.hibernate.Session;

import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;

public abstract class AbstractDAO<T> implements IDAO<T> {

    @Resource
    HibernateWrapper hibernateWrapper;

    protected Class<T> implementedClass;

    @SuppressWarnings("unchecked")
    public AbstractDAO() {
        implementedClass = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }

    protected Session getCurrentSession() {
        return hibernateWrapper.getSession();
    }

    @Override
    public boolean create(T newObject) {
        getCurrentSession().save(newObject);
        return true;

    }

    @SuppressWarnings("unchecked")
    @Override
    public T read(Object idObject) {
        T read = null;
        read = (T) getCurrentSession().get(implementedClass, (Serializable) idObject);
        return read;
    }

    @SuppressWarnings("unchecked")
    @Override
    public T read(Object idObject, LockOptions lockOptions) {
        T read = null;
        getCurrentSession().buildLockRequest(lockOptions);
        read = (T) getCurrentSession().get(implementedClass, (Serializable) idObject);
        getCurrentSession().clear();
        return read;
    }

    @Override
    public void update(T newObject) {
        Session sess = getCurrentSession();
        sess.update(newObject);
    }

    @Override
    public boolean delete(Object idObject) throws MySQLIntegrityConstraintViolationException {
        T read = (T) getCurrentSession().load(implementedClass, (Serializable) idObject);
        if (read != null) {
            getCurrentSession().delete(read);
            return true;
        }
        return false;
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<T> all(int lowerLimit, int superiorLimit) {
        Criteria criteria = getCurrentSession().createCriteria(implementedClass);
        criteria.setMaxResults(superiorLimit - lowerLimit);
        criteria.addOrder(Order.desc("id"));
        criteria.setFirstResult(lowerLimit);
        List<T> result = criteria.list();
        return result;
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<T> getFirstNElements(int size) {
        Criteria criteria = getCurrentSession().createCriteria(implementedClass).setMaxResults(size);
        return criteria.list();
    }

    @Override
    public Long count() {
        return (Long) getCurrentSession().createCriteria(implementedClass).setProjection(Projections.rowCount()).uniqueResult();
    }
}
