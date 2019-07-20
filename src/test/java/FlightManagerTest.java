import org.junit.Before;
import org.junit.Test;

import java.util.Date;

import static junit.framework.TestCase.assertEquals;

public class FlightManagerTest {

    private FlightManager flightManager;
    private Plane plane;
    private Flight flight;
    private Passenger passenger1;
    private Passenger passenger2;
    private Date date;

    @Before
    public void setup(){
        passenger1 = new Passenger("Marge", 2);
        passenger2 = new Passenger("Homer", 1);
        plane = new Plane(PlaneType.BOEING747);
        date = new Date(2019,6,15,14,22);
        flight = new Flight(plane, "FR756", FlightDestination.GLA, FlightDeparture.SPR, date);
        flightManager = new FlightManager(flight);
    }

    @Test
    public void canCalculateAllocatedBagWeight(){
        assertEquals(10, flightManager.getAllocatedBagWeightPerPassenger());
    }

    @Test
    public void canCalculateBookedBaggageWeight(){
        flight.bookPassenger(passenger1);
        flight.bookPassenger(passenger2);
        assertEquals(20, flightManager.getBookedBaggageWeight());
    }

    @Test
    public void canCalculateRemainingReservedBaggageWeight(){
        flight.bookPassenger(passenger1);
        flight.bookPassenger(passenger2);
        assertEquals(480, flightManager.getRemainingBaggageWeightAllowance());
    }

}
