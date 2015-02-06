package com.pentalog.flights.pages;

import org.springframework.web.servlet.ModelAndView;

/**
 * User: mcsere Date: 8/5/14 Time: 3:12 PM
 */
public abstract class AbstractPage {

    protected ModelAndView getModel(String view) {
        ModelAndView modelAndView = new ModelAndView("layout/abstract");
        modelAndView.addObject("viewName", view);
        return modelAndView;
    }

}
