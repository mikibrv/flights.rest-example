package com.pentalog.flights.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.sql.Date;

/**
 * User: mcsere Date: 8/5/14 Time: 5:38 PM
 */
@Entity
@Table(name = "flights")
public class Flight {

    @Id
    @GeneratedValue
    @Column(name = "id", unique = true, nullable = false)
    private int id;
    @Column(name = "name", unique = false, nullable = false)
    private String name;
    @OneToOne()
    @JoinColumn(name = "city_from")
    private City from;
    @OneToOne
    @JoinColumn(name = "city_to")
    private City to;
    @Column(name = "start_date", unique = false, nullable = false)
    private Date startDate;
    @Column(name = "start_time", unique = false, nullable = false)
    private String startTime;
    @Column(name = "cost", unique = false, nullable = false)
    private Double cost;

    public Flight() {

    }

    public Flight(int id, String name, City from, City to, Date startDate, String startTime, Double cost) {
        this.id = id;
        this.name = name;
        this.from = from;
        this.to = to;
        this.startDate = startDate;
        this.startTime = startTime;
        this.cost = cost;
    }

    public Flight(int id, String name, Date startDate, String startTime, Double cost) {
        this.id = id;
        this.name = name;
        this.startDate = startDate;
        this.startTime = startTime;
        this.cost = cost;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public City getFrom() {
        return from;
    }

    public void setFrom(City from) {
        this.from = from;
    }

    public City getTo() {
        return to;
    }

    public void setTo(City to) {
        this.to = to;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }
}
