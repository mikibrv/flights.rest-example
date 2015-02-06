package com.pentalog.flights.dao.impl;

import com.pentalog.flights.dao.AbstractDAO;
import com.pentalog.flights.dao.ITravellerDAO;
import com.pentalog.flights.model.Flight;
import com.pentalog.flights.model.Traveller;
import org.hibernate.Query;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * User: mcsere Date: 8/5/14 Time: 6:32 PM
 */
@Component
public class TravellerDAO extends AbstractDAO<Traveller> implements ITravellerDAO {
    @Override
    public List<Traveller> findByName(String name) {
        String hql = "FROM Traveller where firstName like :name or lastName like :name ";
        Query readQuery = getCurrentSession().createQuery(hql);
        readQuery.setParameter("name", "%" + name + "%");
        return readQuery.list();
    }

    @Override
    public List<Traveller> findByEmail(String email) {
        String hql = " FROM Traveller where email like :email ";
        Query readQuery = getCurrentSession().createQuery(hql);
        readQuery.setParameter("email", "%" + email + "%");
        return readQuery.list();
    }

    @Override
    public List<Traveller> findByFlight(int flightId) {
        Flight flight = new Flight();
        flight.setId(flightId);
        String hql = " FROM Traveller where flight=:flight ";
        Query readQuery = getCurrentSession().createQuery(hql);
        readQuery.setParameter("flight", flight);
        return readQuery.list();
    }
}
