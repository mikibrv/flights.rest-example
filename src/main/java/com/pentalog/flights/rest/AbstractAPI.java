package com.pentalog.flights.rest;

import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;
import com.pentalog.flights.dao.IDAO;
import com.pentalog.flights.model.City;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.util.List;

/**
 * User: mcsere Date: 8/5/14 Time: 5:54 PM
 */
public abstract class AbstractAPI<T> {

    public abstract IDAO<T> getDAO();

    @RequestMapping(value = "/{limitInferior}/{limitSuperior}/")
    public @ResponseBody
    List<T> listBetweenRange(@PathVariable int limitInferior, @PathVariable int limitSuperior) {
        return getDAO().all(limitInferior, limitSuperior);
    }

    /**
     * 
     * @return first 10k
     */
    @RequestMapping
    public @ResponseBody
    List<T> handleRequest() {
        return getDAO().all(1, 10000);
    }

    @RequestMapping("{id}")
    public @ResponseBody
    T get(@PathVariable("id") int id) {
        return getDAO().read(id);
    }

    @RequestMapping("/delete/{id}")
    public @ResponseBody
    Boolean delete(@PathVariable("id") int id) {
        try {
            return getDAO().delete(id);
        } catch (Exception e) {
            return false;
        }
    }

    @RequestMapping(value = "create", method = RequestMethod.POST, headers = "Accept=application/json")
    public @ResponseBody
    Boolean create(@RequestBody T object) {
        return getDAO().create(object);
    }

    @RequestMapping(value = "update", method = RequestMethod.POST, headers = "Accept=application/json")
    public @ResponseBody
    Boolean update(@RequestBody T object) {
        getDAO().update(object);
        return Boolean.TRUE;
    }

    @RequestMapping(value = "count", method = RequestMethod.GET)
    public @ResponseBody
    Long count() {
        return getDAO().count();
    }

}
