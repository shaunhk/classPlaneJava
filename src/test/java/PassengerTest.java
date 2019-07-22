import org.junit.Before;
import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.assertEquals;

public class PassengerTest{

    private Passenger passenger1;
    private Flight flight;
    private Plane plane;
    private Date date;

    @Before
    public void setup() {
        passenger1 = new Passenger("Sid", 2);
        plane = new Plane(PlaneType.BOEING747);
        date = new Date(2019, 6, 15, 14, 22);
        flight = new Flight(plane, "FR756", Airport.GLA, Airport.SPR, date);
    }

    @Test
    public void hasName(){
        assertEquals("Sid", passenger1.getName());
    }

    @Test
    public void hasBags(){
        assertEquals(2, passenger1.getBags());
    }

    @Test
    public void passengerStartsWIthNoFly(){
        assertEquals(null, passenger1.getFlight());
    }

    @Test
    public void canAddFlight(){
        passenger1.addFlight(flight);
        assertEquals(flight, passenger1.getFlight());
    }

    @Test
    public void passengerStartsWithoutSeatNumber(){
        assertEquals(false, this.passenger1.hasSeatNumber());
    }

}
