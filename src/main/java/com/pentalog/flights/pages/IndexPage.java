package com.pentalog.flights.pages;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.method.RequestMappingInfo;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * User: mcsere Date: 8/5/14 Time: 3:09 PM
 */
@Controller
@RequestMapping(value = "/")
public class IndexPage extends AbstractPage {

    private final RequestMappingHandlerMapping handlerMapping;

    @Autowired
    public IndexPage(RequestMappingHandlerMapping handlerMapping) {
        this.handlerMapping = handlerMapping;
    }

    @RequestMapping
    public ModelAndView handleRequest() {

        Map<RequestMappingInfo, HandlerMethod> requestMappingInfoMap = handlerMapping.getHandlerMethods();
        return getModel("pages/index").addObject("controllers", requestMappingInfoMap.keySet());
    }

}
