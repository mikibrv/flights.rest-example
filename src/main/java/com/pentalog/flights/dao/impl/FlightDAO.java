package com.pentalog.flights.dao.impl;

import com.pentalog.flights.dao.AbstractDAO;
import com.pentalog.flights.dao.IFlightDAO;
import com.pentalog.flights.model.City;
import com.pentalog.flights.model.Flight;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * User: mcsere Date: 8/5/14 Time: 6:32 PM
 */
@Component
public class FlightDAO extends AbstractDAO<Flight> implements IFlightDAO {

    FlightDAO() {
        super();
    }

    @Override
    public List<Flight> betweenDates(Date lowerLimit, Date superiorLimit) {
        try {
            Criteria criteria = getCurrentSession().createCriteria(implementedClass);

            java.sql.Date minDate = new java.sql.Date(lowerLimit.getTime());
            java.sql.Date maxDate = new java.sql.Date(superiorLimit.getTime());
            criteria.add(Restrictions.between("startDate", minDate, maxDate));

            return criteria.setMaxResults(1000).list();
        } catch (Exception e) {
            return new ArrayList<Flight>();
        }

    }

    @Override
    public List<Flight> betweenCosts(Double lowerLimit, Double superiorLimit) {
        Criteria criteria = getCurrentSession().createCriteria(implementedClass);
        criteria.add(Restrictions.between("cost", lowerLimit, superiorLimit));
        return criteria.list();
    }

    @Override
    public List<Flight> betweenCities(City from, City to) {
        Criteria criteria = getCurrentSession().createCriteria(implementedClass);
        criteria.add(Restrictions.eq("from", from));
        criteria.add(Restrictions.eq("to", to));
        return criteria.list();
    }
}
