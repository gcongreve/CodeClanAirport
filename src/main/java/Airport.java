import java.util.ArrayList;

public class Airport {

    private AirportType airportType;
    private ArrayList<Hanger> hangers;
    private ArrayList<Flight> flights;
    private ArrayList<Passenger> departureLounge;

    public Airport(AirportType airportType) {
        this.airportType = airportType;
        this.hangers = new ArrayList<>();
        this.flights = new ArrayList<>();
        this.departureLounge = new ArrayList<>();
    }

    public AirportType getAirportType() {
        return airportType;
    }

    public ArrayList<Hanger> getHangers() {
        return hangers;
    }

    public ArrayList<Flight> getFlights() {
        return flights;
    }


    public void addFlight(Flight flight) {
        this.flights.add(flight);
    }

    public void addHanger(Hanger hanger) {
        this.hangers.add(hanger);
    }


    public Hanger emptyHanger() {
        for (Hanger hanger : this.getHangers()) {
            if (!hanger.isFull()) {
                return hanger;
            }
        }
        return null;
    }


    public void addPlaneToHanger(Plane plane) {
        emptyHanger().addPlane(plane);
    }


    public void sellTicket(Flight flight, Passenger passenger) {
        if (this.flights.contains(flight)) {
            flight.sellTicket(passenger);
        }
    }

    public int ticketsSold(Flight flight) {
        return flight.getTicketsSold();
    }


    public int ticketsRemaining(Flight flight) {
        return flight.remainingTickets();
    }

    public Plane returnSuitablePlane(int passengerNumber) {
        Plane suitablePlane = null;
        int numberDifference = 1000;
        for (Hanger hanger : this.hangers) {
            for (Plane plane : hanger.getHanger()) {
                if (plane.getCapacity() >= passengerNumber) {
                    if ((plane.getCapacity() - passengerNumber) < numberDifference) {
                        suitablePlane = plane;
                        numberDifference = (plane.getCapacity() - passengerNumber);
                    }
                }
            }
        }
        return suitablePlane;
    }

    public void assignPlaneToFlight(Flight flight) {
        int passengerNumber = flight.getTicketsSold();
        Plane suitablePlane = returnSuitablePlane(passengerNumber);
        flight.addPlane(suitablePlane);
    }

    public void addFlightPassengersToPlane(Flight flight, Plane plane){
        for (Passenger passenger : flight.getFlightPassengers()){
            plane.addPassenger(passenger);
        }
    }

    public void removePlaneFromHanger(Plane plane){
        for (Hanger hanger : this.hangers){
            if (hanger.getHanger().contains(plane)){
                hanger.removePlane(plane);
            }
        }
    }

    public void boardPlane(Flight flight) {
        assignPlaneToFlight(flight);
        Plane plane = flight.getPlane().get(0);
        addFlightPassengersToPlane(flight, plane);
        removePlaneFromHanger(plane);
    }

    public ArrayList<Passenger> getDepartureLounge() {
        return departureLounge;
    }

    public void addToLounge(Passenger passenger) {
        this.departureLounge.add(passenger);
    }

    public Passenger getPassengerFromLoungeAlgorithm(){
        // TODO: make an algorithm
    }
}
