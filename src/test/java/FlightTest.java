import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FlightTest {

    private Plane plane;
    private Flight flight;
    private Passenger passenger;

    @Before
    public void before(){
    plane = new Plane("Mr Plane", PlaneType.CODINGPLANE3, AirlineType.OKAIRLINES);
    flight = new Flight(1, DestinationType.DUNDEE);
    passenger = new Passenger("Steve");

    }

    @Test
    public void hasFlightNumber(){
        assertEquals(1, flight.getFlightNumber());
    }

    @Test
    public void hasDestination(){
        assertEquals(DestinationType.DUNDEE, flight.getDestination());
    }

    @Test
    public void canTakeFlightPassenger(){
        flight.addPassenger(passenger);
        assertEquals(1, flight.getFlightPassengers().size());
    }

    @Test
    public void canAddPlane(){
        flight.addPlane(plane);
        assertEquals(1, flight.getPlane().size());
    }



}
