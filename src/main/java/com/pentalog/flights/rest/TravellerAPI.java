package com.pentalog.flights.rest;

import com.pentalog.flights.dao.IDAO;
import com.pentalog.flights.dao.ITravellerDAO;
import com.pentalog.flights.model.Traveller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * User: mcsere Date: 8/5/14 Time: 6:48 PM
 */
@Controller
@RequestMapping(value = "/travellers/")
public class TravellerAPI extends AbstractAPI<Traveller> {

    @Resource
    ITravellerDAO travellerDAO;

    @Override
    public IDAO<Traveller> getDAO() {
        return travellerDAO;
    }

    @RequestMapping("name/{name}")
    public @ResponseBody
    List<Traveller> findByName(@PathVariable("name") String name) {
        return travellerDAO.findByName(name);
    }

    @RequestMapping("email/{email}")
    public @ResponseBody
    List<Traveller> findByEmail(@PathVariable("email") String email) {
        return travellerDAO.findByEmail(email);
    }

    @RequestMapping("flight/{flight}")
    public @ResponseBody
    List<Traveller> findByFlight(@PathVariable("flight") int flight) {
        return travellerDAO.findByFlight(flight);
    }

}
