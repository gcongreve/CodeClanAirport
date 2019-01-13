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
    private Hanger hanger1;
    private Hanger hanger2;

    @Before
    public void before(){
        plane1 = new Plane("Mr Plane", PlaneType.CODINGPLANE1, AirlineType.OKAIRLINES);
        plane2 = new Plane("Mrs Plane", PlaneType.CODINGPLANE3, AirlineType.GOODAIRLINES);
        passenger1 = new Passenger("Dave");
        passenger2 = new Passenger("Morag");
        airport = new Airport(AirportType.DUNDEE);
        flight1 = new Flight(1, DestinationType.BROUGHTY_FERRY, 2);
        hanger1 = new Hanger("Hanger 1", 1);
        hanger2 = new Hanger("Hanger 2",2);
    }

    @Test
    public void canHaveAirportCode(){
        assertEquals("DUN01", airport.getAirportType().getAirportCode());
    }

    @Test
    public void hangersStartsEmpty(){
        assertEquals(0, airport.getHangers().size());
    }

    @Test
    public void canAddHangerToAirport(){
        airport.addHanger(hanger1);
        assertEquals(1, airport.getHangers().size());
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

    @Test
    public void canReturnEmptyHanger(){
        airport.addHanger(hanger1);
        assertEquals(hanger1, airport.emptyHanger());
    }

    @Test
    public void canAddPlaneToHanger(){
        airport.addHanger(hanger1);
        airport.addPlaneToHanger(plane1);
        assertEquals(true, hanger1.isFull());

    }

    @Test
    public void canReturnFirstEmptyHanger(){
        airport.addHanger(hanger1);
        airport.addHanger(hanger2);
        airport.addPlaneToHanger(plane1);
        assertEquals(hanger2, airport.emptyHanger());
    }

    @Test
    public void canAddPlanesToMultipleHangers(){
        airport.addHanger(hanger1);
        airport.addHanger(hanger2);
        airport.addPlaneToHanger(plane1);
        airport.addPlaneToHanger(plane2);
        assertEquals(1, hanger1.numberOfPlanes());
        assertEquals(1, hanger2.numberOfPlanes());
    }

}
