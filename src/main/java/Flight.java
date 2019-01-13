import java.util.ArrayList;

public class Flight {

    private int flightNumber;
    private DestinationType destination;
    private ArrayList<Passenger> flightPassengers;
    private ArrayList<Plane> plane;
    private int flightCapacity;
    private int ticketsSold;

    public Flight(int flightNumber, DestinationType destination, int flightCapacity){
        this.flightNumber = flightNumber;
        this.destination = destination;
        this.plane = new ArrayList<>();
        this.flightPassengers = new ArrayList<>();
        this.flightCapacity = flightCapacity;
        this.ticketsSold = 0;

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

    public int getFlightCapacity() {
        return flightCapacity;
    }

    public int getTicketsSold() {
        return ticketsSold;
    }

    public void addPlane(Plane plane) {
        this.plane.add(plane);
    }

    public int remainingTickets() {
        return flightCapacity - ticketsSold;
    }

    public void sellTicket(Passenger passenger) {
        if (remainingTickets() != 0) {
            addPassenger(passenger);
            this.ticketsSold += 1;
        }
    }




}
