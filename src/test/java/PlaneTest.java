import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PlaneTest {

    private Plane plane1;

    @Before
    public void setup(){
        plane1 = new Plane(PlaneType.BOEING747);
    }

    @Test
    public void planeHasType() {
        assertEquals(PlaneType.BOEING747, plane1.getPlaneType());
    }

    @Test
    public void planeHasCapacity(){
        assertEquals(50, plane1.getCapacity());
    }

    @Test
    public void planeHasTotalWeight(){
        assertEquals(1000, plane1.getTotalWeight());
    }
}
