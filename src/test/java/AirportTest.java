import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AirportTest {

    private Plane plane1;
    private Plane plane2;
    private Airport airport;
    private Passenger passenger1;
    private Passenger passenger2;
    private Flight flight1;

    @Before
    public void before(){
        plane1 = new Plane("Mr Plane", PlaneType.CODINGPLANE1, AirlineType.OKAIRLINES);
        plane2 = new Plane("Mrs Plane", PlaneType.CODINGPLANE3, AirlineType.GOODAIRLINES);
        passenger1 = new Passenger("Dave");
        passenger2 = new Passenger("Morag");
        airport = new Airport(AirportType.DUNDEE);
        flight1 = new Flight(1, DestinationType.BROUGHTY_FERRY);
    }

    @Test
    public void canHaveAirportCode(){
        assertEquals("DUN01", airport.getAirportType().getAirportCode());
    }

    @Test
    public void hangerStartsEmpty(){
        assertEquals(0, airport.getHanger().size());
    }

    @Test
    public void canAddPlaneToHanger(){
        airport.addPlane(plane1);
        assertEquals(1, airport.getHanger().size());
    }

    @Test
    public void flightsStartsEmpty(){
        assertEquals(0, airport.getFlights().size());
    }

    @Test
    public void canAddFlightToAirport(){
        airport.addFlight(flight1);
        assertEquals(1, airport.getFlights().size());
    }
}
