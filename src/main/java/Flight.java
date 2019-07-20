import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;

public class Flight {

    private ArrayList<Passenger> passengers;
    private Plane plane;
    private String flightNumber;
    private FlightDestination flightDestination;
    private FlightDeparture flightDeparture;
    private Date flightDepartureDate;
    private ArrayList<Integer> unassignedSeatNumbers;

    public Flight(Plane plane, String flightNumber, FlightDestination flightDestination, FlightDeparture flightDeparture, Date flightDepartureDate){
        this.passengers = new ArrayList<Passenger>();
        this.plane = plane;
        this.flightNumber = flightNumber;
        this.flightDestination = flightDestination;
        this.flightDeparture = flightDeparture;
        this.flightDepartureDate = flightDepartureDate;
        this.unassignedSeatNumbers = new ArrayList<Integer>();
        for (int i = 1; i <= (this.plane.getCapacity()); i++){
            this.unassignedSeatNumbers.add(i);
        }
        Collections.shuffle(this.unassignedSeatNumbers);
    }

    public int getPassengerAmount() {
        return this.passengers.size();
    }

    public Plane getPlane(){
        return this.plane;
    }

    public String getFlightNumber() {
        return this.flightNumber;
    }

    public FlightDestination getDestination() {
        return this.flightDestination;
    }

    public FlightDeparture getDeparture() {
        return this.flightDeparture;
    }

    public Date getDepartureTime() {
        return this.flightDepartureDate;
    }

    public int getNumberOfAvailableSeats() {
        int availableSeats = this.plane.getCapacity();
        availableSeats -= this.getPassengerAmount();
        return availableSeats;
    }

    public void bookPassenger(Passenger passenger) {
        if(this.getPassengerAmount() < this.plane.getCapacity()){
            passengers.add(passenger);
            passenger.addFlight(this);
            passenger.assignSeatNumber(this.unassignedSeatNumbers.get(0));
            this.unassignedSeatNumbers.remove(0);
        }
    }

    public int getNumberOfUnavailableSeats(){
        return this.unassignedSeatNumbers.size();
    }
}
