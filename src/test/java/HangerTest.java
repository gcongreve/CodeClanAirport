import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class HangerTest {

    private Plane plane1;
    private Plane plane2;
    private Plane plane3;
    private Plane plane4;
    private Hanger bigHanger;
    private Hanger smallHanger;

    @Before
    public void before(){
        plane1 = new Plane("Plano", PlaneType.CODINGPLANE1, AirlineType.OKAIRLINES);
        plane2 = new Plane("Planing", PlaneType.CODINGPLANE2, AirlineType.MEGAGOODAIRLINES);
        plane3 = new Plane("Planer", PlaneType.CODINGPLANE3, AirlineType.GOODAIRLINES);
        bigHanger = new Hanger("Big Hanger", 4);
        smallHanger = new Hanger("Small Hanger", 1);
    }

    @Test
    public void hangerStartsEmpty(){
        assertEquals(0, bigHanger.getHanger().size());
    }

    @Test
    public void hangerHasName(){
        assertEquals("Big Hanger", bigHanger.getName());
    }

    @Test
    public void canAddPlane(){
        smallHanger.addPlane(plane1);
        assertEquals(1, smallHanger.getHanger().size());
    }

    @Test
    public void hasCapacity(){
        assertEquals(4, bigHanger.getCapacity());
    }

    @Test
    public void canBeFull(){
        smallHanger.addPlane(plane2);
        assertEquals(true, smallHanger.isFull());
    }

    @Test
    public void canAddPlanesOnlyToCapacity(){
        smallHanger.addPlane(plane1);
        smallHanger.addPlane(plane2);
        assertEquals(1, smallHanger.getHanger().size());
    }

    @Test
    public void canRemovePlane1(){
        bigHanger.addPlane(plane1);
        bigHanger.addPlane(plane2);
        bigHanger.removePlane(plane1);
        assertEquals(1, bigHanger.getHanger().size());
        assertEquals(true, bigHanger.getHanger().contains(plane2));
    }

    @Test
    public void canRemovePlane2(){
        bigHanger.addPlane(plane1);
        bigHanger.addPlane(plane2);
        bigHanger.removePlane(plane2);
        assertEquals(1, bigHanger.getHanger().size());
        assertEquals(true, bigHanger.getHanger().contains(plane1));
    }

}
