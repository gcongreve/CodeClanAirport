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

    public int getCapacity(){
        return this.type.getCapacity();
    }

    public boolean isFull(){
        return this.type.getCapacity() == this.passengers.size();
    }

    public void addPassenger(Passenger passenger) {
        if (!isFull()) {
            this.passengers.add(passenger);
        }
    }


}
