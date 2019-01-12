import java.util.ArrayList;

public class Flight {

    private int flightNumber;
    private DestinationType destination;
    private ArrayList<Passenger> flightPassengers;
    private ArrayList<Plane> plane;

    public Flight(int flightNumber, DestinationType destination){
        this.flightNumber = flightNumber;
        this.destination = destination;
        this.plane = new ArrayList<>();
        this.flightPassengers = new ArrayList<>();

    }

    public int getFlightNumber() {
        return flightNumber;
    }

    public DestinationType getDestination() {
        return destination;
    }

    public ArrayList<Passenger> getFlightPassengers() {
        return flightPassengers;
    }

    public ArrayList<Plane> getPlane() {
        return plane;
    }


    public void addPassenger(Passenger passenger) {
        this.flightPassengers.add(passenger);
    }
}
