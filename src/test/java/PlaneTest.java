import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PlaneTest {

    private Passenger passenger;
    private Plane plane1;

    @Before
    public void before(){
        passenger = new Passenger("Steve");
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

}
