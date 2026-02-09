import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

class ScaniaTest {

    private Scania scania;

    /** Sets up a normal Scania */
    @BeforeEach
    public void setUp() {scania = new Scania(Color.GRAY, 280.0, 2, "Scania");}


    /** Tests if we can gas whilst the bed is raised */
    @Test
    public void stopGasWithRaisedBed() {
        System.out.println(scania.getColor());
        scania.raiseBed(40);
        scania.gas(100);
        assertEquals(0, scania.getCurrentSpeed());

    }

    /** Tests if the bed cannot be raised above its maximum angle */
    @Test
    public void bedCannotExceedMaxAngle() {
        scania.raiseBed(100);
        assertEquals(70, scania.getBedAngle());
    }

    /** Tests if the bed cannot be lowered below zero */
    @Test
    public void bedCannotGoBelowZero() {
        scania.lowerBed(50);
        assertEquals(0, scania.getBedAngle());
    }
}
