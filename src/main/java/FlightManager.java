public class FlightManager {

    private Flight flight;

    public FlightManager(Flight flight){
        this.flight = flight;
    }

    public int getAllocatedBagWeightPerPassenger() {
        int bagWeight = ((this.flight.getPlane().getTotalWeight() / 2) / this.flight.getPlane().getCapacity());
        return bagWeight;
    }

    public int getBookedBaggageWeight() {
        return (this.flight.getPassengerAmount() * this.getAllocatedBagWeightPerPassenger());
    }

    public int getRemainingBaggageWeightAllowance() {
        return ((this.flight.getPlane().getTotalWeight() / 2) - this.getBookedBaggageWeight());
    }
}
