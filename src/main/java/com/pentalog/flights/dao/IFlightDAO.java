package com.pentalog.flights.dao;

import com.pentalog.flights.model.City;
import com.pentalog.flights.model.Flight;

import java.util.Date;
import java.util.List;

/**
 * User: mcsere Date: 8/5/14 Time: 7:23 PM
 */
public interface IFlightDAO extends IDAO<Flight> {

    public List<Flight> betweenDates(Date lowerLimit, Date superiorLimit);

   public List<Flight> betweenCosts(Double lowerLimit, Double superiorLimit);

    public List<Flight> betweenCities(City from, City to);
}
