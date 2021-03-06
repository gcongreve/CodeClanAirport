import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PlaneTest {

    private Passenger passenger;
    private Passenger passenger2;
    private Plane plane1;

    @Before
    public void before(){
        passenger = new Passenger("Steve");
        passenger2 = new Passenger("Bob");
        plane1 = new Plane("Mr Plane", PlaneType.CODINGPLANE1, AirlineType.MEGAGOODAIRLINES);
    }

    @Test
    public void hasName(){
        assertEquals("Mr Plane", plane1.getName());
    }

    @Test
    public void hasType(){
        assertEquals(PlaneType.CODINGPLANE1, plane1.getType());
    }

    @Test
    public void hasAirline(){
        assertEquals(AirlineType.MEGAGOODAIRLINES, plane1.getAirline());
    }

    @Test
    public void planeStartsEmpty(){
        assertEquals(0, plane1.getPassengers().size());
    }

    @Test
    public void planeHasCapacity(){
        assertEquals(1, plane1.getType().getCapacity());
    }

    @Test
    public void planeCanTakeOnPassenger(){
        plane1.addPassenger(passenger);
        assertEquals(1, plane1.getPassengers().size());
    }

    @Test
    public void planeCanBeFull(){
        plane1.addPassenger(passenger);
        assertEquals(true, plane1.isFull());
    }

    @Test
    public void planeCanOnlyTakePassengersToCapacity(){
        plane1.addPassenger(passenger);
        plane1.addPassenger(passenger2);
        assertEquals(1, plane1.getPassengers().size());

    }

}
