package com.pentalog.flights.dao;

import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;
import org.hibernate.LockOptions;

import java.sql.Date;
import java.util.List;

/**
 * User: mcsere Date: 8/5/14 Time: 6:25 PM
 */
public interface IDAO<T> {

    public boolean create(T newObject);

    public T read(Object idObject);

    public T read(Object idObject, LockOptions lockOptions);

    public void update(T newObject);

    public boolean delete(Object idObject) throws MySQLIntegrityConstraintViolationException;

    public List<T> all(int lowerLimit, int superiorLimit);

    public List<T> getFirstNElements(int size);

    public Long count();
}
