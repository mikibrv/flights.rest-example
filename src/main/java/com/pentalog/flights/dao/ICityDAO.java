package com.pentalog.flights.dao;

import com.pentalog.flights.model.City;

import java.util.List;

/**
 * User: mcsere Date: 8/5/14 Time: 7:18 PM
 */
public interface ICityDAO extends IDAO<City> {

    public List<City> findByName(String name);

}
