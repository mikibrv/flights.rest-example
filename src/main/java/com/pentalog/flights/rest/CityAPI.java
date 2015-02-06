package com.pentalog.flights.rest;

import com.pentalog.flights.dao.ICityDAO;
import com.pentalog.flights.dao.IDAO;
import com.pentalog.flights.model.City;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * User: mcsere Date: 8/5/14 Time: 6:27 PM
 */
@Controller
@RequestMapping(value = "/cities/")
public class CityAPI extends AbstractAPI<City> {

    @Resource
    ICityDAO cityDAO;

    @Override
    public IDAO<City> getDAO() {
        return cityDAO;
    }

    @RequestMapping("name/{name}")
    public @ResponseBody
    List<City> findByName(@PathVariable("name") String name) {
        return cityDAO.findByName(name);
    }

}
