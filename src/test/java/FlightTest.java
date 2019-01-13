import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FlightTest {

    private Plane plane;
    private Flight flight;
    private Passenger passenger;
    private Passenger passenger2;
    private Passenger passenger3;

    @Before
    public void before(){
    plane = new Plane("Mr Plane", PlaneType.CODINGPLANE3, AirlineType.OKAIRLINES);
    flight = new Flight(1, DestinationType.DUNDEE, 2);
    passenger = new Passenger("Steve");
    passenger2 = new Passenger("Dave");
    passenger3 = new Passenger("Roberto");
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

    @Test
    public void canHaveCapacity(){
        assertEquals(2, flight.getFlightCapacity());
    }

    @Test
    public void ticketsStartsAtZero(){
        assertEquals(0, flight.getTicketsSold());
    }

    @Test
    public void canSellaTicket(){
        flight.sellTicket(passenger);
        assertEquals(1, flight.getFlightPassengers().size());
        assertEquals(1, flight.getTicketsSold());
    }

    @Test
    public void canReturnRemainingTickets(){
        assertEquals(2, flight.remainingTickets());
        flight.sellTicket(passenger);
        assertEquals(1, flight.remainingTickets());
    }

    @Test
    public void canOnlySellTicketsToCapacity(){
        flight.sellTicket(passenger);
        flight.sellTicket(passenger2);
        flight.sellTicket(passenger3);
        assertEquals(0, flight.remainingTickets());
        assertEquals(2, flight.getTicketsSold());
        assertEquals(2, flight.getFlightPassengers().size());
    }

}
