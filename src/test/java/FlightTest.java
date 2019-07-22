import org.junit.Before;
import org.junit.Test;

import java.util.Date;

import static junit.framework.TestCase.assertEquals;

public class FlightTest {

    private Flight flight;
    private Plane plane;
    private Passenger passenger1;
    private Passenger passenger2;
    private Date date;

    @Before
    public void setup(){
        passenger1 = new Passenger("Marge", 2);
        passenger2 = new Passenger("Homer", 1);
        plane = new Plane(PlaneType.BOEING747);
        date = new Date(2019,6,15,14,22);
        flight = new Flight(plane, "FR756", Airport.GLA, Airport.SPR, date);
    }

    @Test
    public void flightHasEmptyPassengerList(){
        assertEquals(0, flight.getPassengerAmount());
    }

    @Test
    public void flightHasPlane(){
        assertEquals(plane, flight.getPlane());
    }

    @Test
    public void flightHasNumber(){
        assertEquals("FR756", flight.getFlightNumber());
    }

    @Test
    public void flightHasDestination(){
        assertEquals(Airport.GLA, flight.getDestination());
    }

    @Test
    public void flightHasDepartureAirport(){
        assertEquals(Airport.SPR, flight.getDeparture());
    }

    @Test
    public void flightHasDepartureTime(){
        assertEquals(new Date(2019,6,15,14,22), flight.getDepartureTime());
    }

    @Test
    public void canBookPassengers(){
        flight.bookPassenger(passenger1);
        assertEquals(1, flight.getPassengerAmount());
    }

    @Test
    public void canGetNumberOfAvailableSeats(){
        flight.bookPassenger(passenger1);
        flight.bookPassenger(passenger2);
        assertEquals(48, flight.getNumberOfAvailableSeats());
    }

    @Test
    public void cantBookFullPlane(){
        for(int i=0; i<51; i++){
            flight.bookPassenger(passenger1);
        }
        assertEquals(50, flight.getPassengerAmount());
    }

    @Test
    public void passengerCanGetFLight(){
        assertEquals(null, this.passenger1.getFlight());
        flight.bookPassenger(passenger1);
        assertEquals(this.flight, this.passenger1.getFlight());
    }

    @Test
    public void flightStartsWithAllSeatsUnassigned(){
        assertEquals(50, this.flight.getNumberOfUnavailableSeats());
    }

    @Test
    public void passengerCanBeAssignedSeatNumber(){
        flight.bookPassenger(passenger1);
        assertEquals(true, this.passenger1.hasSeatNumber());
    }

    @Test
    public void flightNumbersLostWhenAssigned(){
        flight.bookPassenger(passenger1);
        assertEquals(49, this.flight.getNumberOfUnavailableSeats());
    }

}
