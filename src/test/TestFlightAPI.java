import com.pentalog.flights.dao.ICityDAO;
import com.pentalog.flights.dao.IFlightDAO;
import com.pentalog.flights.model.City;
import com.pentalog.flights.model.Flight;
import junit.framework.Assert;
import junit.framework.TestCase;
import org.junit.Test;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@ContextConfiguration(locations = {"classpath:testBeans.xml"})
public class TestFlightAPI {

    @Resource
    public
    IFlightDAO flightDAO;
    @Resource
    public
    ICityDAO cityDAO;

    @Test
    @Transactional("transactionManager")
    public void testGetFlightsByCities() {

//
//        City city1=cityDAO.read(1);
//        City city2=cityDAO.read(1);
//        List<Flight> flights = flightDAO.betweenCities(city1, city2);
//Assert.assertTrue(flights.size()>0);
    }
}