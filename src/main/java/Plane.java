import java.util.ArrayList;

public class Plane {

    private String name;
    private PlaneType type;
    private ArrayList<Passenger> passengers;
    private AirlineType airline;

    public Plane(String name, PlaneType type, AirlineType airline){
        this.name = name;
        this.type = type;
        this.airline = airline;
        this.passengers = new ArrayList<>();
    }

    public ArrayList<Passenger> getPassengers() {
        return passengers;
    }

    public AirlineType getAirline() {
        return airline;
    }

    public PlaneType getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public void addPassenger(Passenger passenger) {
        this.passengers.add(passenger);
    }
}
