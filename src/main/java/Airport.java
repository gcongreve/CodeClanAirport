import java.util.ArrayList;

public class Airport {

    private AirportType airportType;
    private ArrayList<Plane> hanger;
    private ArrayList<Flight> flights;

    public Airport(AirportType airportType) {
        this.airportType = airportType;
        this.hanger = new ArrayList<>();
        this.flights = new ArrayList<>();
    }

    public AirportType getAirportType() {
        return airportType;
    }

    public ArrayList<Plane> getHanger() {
        return hanger;
    }

    public ArrayList<Flight> getFlights() {
        return flights;
    }


    public void addPlane(Plane plane) {
        this.hanger.add((plane));
    }

    public void addFlight(Flight flight) {
        this.flights.add(flight);
    }
}
