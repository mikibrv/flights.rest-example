package com.pentalog.flights.dao.impl;

import com.pentalog.flights.dao.AbstractDAO;
import com.pentalog.flights.dao.ICityDAO;
import com.pentalog.flights.model.City;
import org.hibernate.Query;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * User: mcsere Date: 8/5/14 Time: 6:26 PM
 */
@Component
public class CityDAO extends AbstractDAO<City> implements ICityDAO {
    @Override
    public List<City> findByName(String name) {
        String hql = "FROM City where name like :name  ";
        Query readQuery = getCurrentSession().createQuery(hql);
        readQuery.setParameter("name", "%" + name + "%");
        return readQuery.list();
    }
}
