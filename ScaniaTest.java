import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

class ScaniaTest {

    private Scania scania;

    /** Sets up a normal Scania */
    @BeforeEach
    public void setUp() {scania = new Scania();}


    /** Tests if we can gas whilst the bed is raised */
    @Test
    public void stopGasWithRaisedBed() {
        scania.raiseBed(40);
        scania.gas(100);
        assertEquals(0, scania.getCurrentSpeed());

    }
}