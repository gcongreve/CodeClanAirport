import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PassengerTest {

    private Passenger passenger;

    @Before
    public void before(){
        passenger = new Passenger("Steve");
    }

    @Test
    public void hasName(){
        assertEquals("Steve", passenger.getName());
    }
}
