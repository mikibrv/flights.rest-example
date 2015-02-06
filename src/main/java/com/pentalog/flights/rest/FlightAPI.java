package com.pentalog.flights.rest;

import com.pentalog.flights.dao.IDAO;
import com.pentalog.flights.dao.IFlightDAO;
import com.pentalog.flights.model.City;
import com.pentalog.flights.model.Flight;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Locale;

/**
 * User: mcsere Date: 8/5/14 Time: 5:52 PM
 */
@Controller
@RequestMapping(value = "/flights/")
public class FlightAPI extends AbstractAPI<Flight> {

    @Resource
    IFlightDAO flightDAO;

    @Override
    public IDAO<Flight> getDAO() {
        return flightDAO;
    }

    @RequestMapping(value = "/dates/{limitInferior}/{limitSuperior}/")
    public @ResponseBody
    List<Flight> listBetweenDates(@PathVariable String limitInferior, @PathVariable String limitSuperior) throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date startDate = formatter.parse(limitInferior);
        Date endDate = formatter.parse(limitSuperior);
        return flightDAO.betweenDates(startDate, endDate);
    }

    @RequestMapping(value = "/byCities/", method = RequestMethod.POST)
    public @ResponseBody
    List<Flight> listBetweenCities(@RequestBody List<City> cities, HttpServletRequest request) {
        if (cities.size() == 2) {
            return flightDAO.betweenCities(cities.get(0), cities.get(1));
        }
        return null;
    }

    @RequestMapping(value = "/costs/{limitInferior}/{limitSuperior}/")
    public @ResponseBody
    List<Flight> listBetweenCosts(@PathVariable double limitInferior, @PathVariable double limitSuperior) {
        return flightDAO.betweenCosts(limitInferior, limitSuperior);
    }
}
