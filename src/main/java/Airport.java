import java.util.ArrayList;

public class Airport {

    private AirportType airportType;
    private ArrayList<Hanger> hangers;
    private ArrayList<Flight> flights;

    public Airport(AirportType airportType) {
        this.airportType = airportType;
        this.hangers = new ArrayList<>();
        this.flights = new ArrayList<>();
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
        for (Hanger hanger : this.getHangers()){
            if (!hanger.isFull()){
                return hanger;
            }
        }
        return null;
    }


    public void addPlaneToHanger(Plane plane){
        emptyHanger().addPlane(plane);
    }



}
