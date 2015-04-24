package com.pentalog.flights.pages;

import com.pentalog.flights.dao.ICityDAO;
import com.pentalog.flights.dao.IFlightDAO;
import com.pentalog.flights.dao.ITravellerDAO;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.method.RequestMappingInfo;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.persistence.PostRemove;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * User: mcsere Date: 8/5/14 Time: 3:09 PM
 */
@Controller
@RequestMapping(value = "/")
@Scope("singleton")
public class IndexPage extends AbstractPage {

    private static final Logger LOG = Logger.getLogger(IndexPage.class);

    private final RequestMappingHandlerMapping handlerMapping;

    @Resource
    ICityDAO cityDAO;

    @Resource
    IFlightDAO flightDAO;

    @Resource
    ITravellerDAO travellerDAO;

    @Autowired
    public IndexPage(RequestMappingHandlerMapping handlerMapping) {
        this.handlerMapping = handlerMapping;
    }

    @RequestMapping
    public ModelAndView handleRequest() {

        Map<RequestMappingInfo, HandlerMethod> requestMappingInfoMap = handlerMapping.getHandlerMethods();
        return getModel("pages/index").addObject("controllers", requestMappingInfoMap.keySet());
    }

    private ModelAndView apiResult() {
        Map<RequestMappingInfo, HandlerMethod> requestMappingInfoMap = handlerMapping.getHandlerMethods();
        flightDAO.all(0,10);
        travellerDAO.all(0,10);
        cityDAO.all(0, 10);
        return getModel("pages/index").addObject("controllers", requestMappingInfoMap.keySet());
    }

    @RequestMapping(value = "/cev34a", method = RequestMethod.POST)
    public ModelAndView test() {
        return apiResult();
    }

    @RequestMapping("/ceva412")
    public ModelAndView te12st() {
        return apiResult();
    }

    @RequestMapping("/cev11a44")
    public ModelAndView t11est() {
        return apiResult();
    }

    @RequestMapping("/cev1441a")
    public ModelAndView tes11t() {
        return apiResult();
    }

    @RequestMapping("/cev9444a")
    public ModelAndView te9st() {
        return apiResult();
    }

    @RequestMapping("/cev18a")
    public ModelAndView t8est() {
        return apiResult();
    }

    @RequestMapping("/ce17va")
    public ModelAndView te7st() {
        return apiResult();
    }

    @RequestMapping("/ce611va")
    public ModelAndView t6est() {
        return apiResult();
    }

    @RequestMapping("/c511eva")
    public ModelAndView t5est() {
        return apiResult();
    }

    @RequestMapping("/c4e32va")
    public ModelAndView t4est() {
        return apiResult();
    }

    @RequestMapping("/cev2133a")
    public ModelAndView te2st() {
        return apiResult();
    }

    @RequestMapping("/ceva3452")
    public ModelAndView te32st() {
        return apiResult();
    }

    @PostConstruct
    public void postConstruct() {
        LOG.warn("Controller was build");
    }

    @PostRemove
    public void postRemove() {
        LOG.warn("Controller was removed");
    }

}