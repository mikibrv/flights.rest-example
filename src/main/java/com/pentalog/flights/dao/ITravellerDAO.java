package com.pentalog.flights.dao;

import com.pentalog.flights.model.Traveller;

import java.util.List;

/**
 * User: mcsere
 * Date: 8/5/14
 * Time: 7:24 PM
 */
public interface ITravellerDAO extends IDAO<Traveller> {

    public List<Traveller> findByName(String name);

    public List<Traveller> findByEmail(String email);

    public List<Traveller> findByFlight(int flight);

}
