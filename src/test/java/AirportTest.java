import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AirportTest {

    private Plane plane1;
    private Plane plane2;
    private Plane plane3;
    private Plane plane4;
    private Airport airport;
    private Passenger passenger1;
    private Passenger passenger2;
    private Flight flight1;
    private Flight flight2;
    private Hanger hanger1;
    private Hanger hanger2;

    @Before
    public void before(){
        plane1 = new Plane("Plane One", PlaneType.CODINGPLANE1, AirlineType.OKAIRLINES);
        plane2 = new Plane("Plane Two", PlaneType.CODINGPLANE2, AirlineType.GOODAIRLINES);
        plane3 = new Plane("Plane Three", PlaneType.CODINGPLANE3, AirlineType.MEGAGOODAIRLINES);
        plane4 = new Plane("Plane Four", PlaneType.CODINGPLANE4, AirlineType.GOODAIRLINES);
        passenger1 = new Passenger("Dave");
        passenger2 = new Passenger("Morag");
        airport = new Airport(AirportType.DUNDEE);
        flight1 = new Flight(1, DestinationType.BROUGHTY_FERRY, 2);
        flight2 = new Flight(2, DestinationType.CARNOUSTIE, 1);
        hanger1 = new Hanger("Hanger 1", 1);
        hanger2 = new Hanger("Hanger 2",4);
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

    @Test
    public void canSellTicketForFlight(){
        airport.addFlight(flight1);
        airport.sellTicket(flight1, passenger1);
        assertEquals(1, flight1.getTicketsSold());
        assertEquals(1, flight1.getFlightPassengers().size());
    }

    @Test
    public void canTellHowManyTicketsSoldAndRemainingFlight(){
        airport.addFlight(flight1);
        airport.sellTicket(flight1, passenger1);
        assertEquals(1, airport.ticketsSold(flight1));
        assertEquals(1, airport.ticketsRemaining(flight1));
    }

    @Test
    public void canOnlySellFlightsInAirport(){
        airport.addFlight(flight1);
        airport.sellTicket(flight2, passenger1);
        assertEquals(0, flight2.getTicketsSold());
    }


    @Test
    public void cantOverSellAFlight(){
        airport.addFlight(flight2);
        airport.sellTicket(flight2, passenger1);
        airport.sellTicket(flight2, passenger2);
        assertEquals(1, flight2.getFlightPassengers().size());
    }

    @Test
    public void assignMostSuitablePlane(){
        airport.addHanger(hanger2);
        airport.addPlaneToHanger(plane1);
        airport.addPlaneToHanger(plane2);
        airport.addPlaneToHanger(plane3);
        airport.addPlaneToHanger(plane4);
        airport.addFlight(flight1);
        airport.sellTicket(flight1, passenger1);
        airport.sellTicket(flight1, passenger2);
        airport.assignPlaneToFlight(flight1);
        assertEquals(true, flight1.getPlane().contains(plane2));
    }

    @Test
    public void flightPassengersBoardFlight(){
        airport.addHanger(hanger1);
        airport.addPlaneToHanger(plane1);
        airport.addFlight(flight1);
        airport.sellTicket(flight1, passenger1);
        airport.boardPlane(flight1);
        assertEquals(true, flight1.getFlightPassengers().contains(passenger1));
    }

    @Test
    public void departureLoungeStartsEmpty(){
        assertEquals(0, airport.getDepartureLounge().size());
    }

    @Test
    public void addPassengerToLounge(){
        airport.addToLounge(passenger1);
        assertEquals(1, airport.getDepartureLounge().size());
    }





}
