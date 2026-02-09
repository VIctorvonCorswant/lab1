import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

class VolvoFH16Test {

    private VolvoFH16 fh16;

    /** Sets up a VolvoFH16 */
    @BeforeEach
    public void setUp() {fh16 = new VolvoFH16(Color.GRAY, 300.0, 2, 3, "FH16");}



    @Test
    public void lowerTrailer() {
        fh16.lowerTrailer(true);
        assertFalse(fh16.trailerUp);
    }

    @Test
    public void raiseTrailer() {
        fh16.trailerUp = false;
        fh16.raiseTrailer(true);
        assertTrue(fh16.trailerUp);
    }

    @Test
    public void loadCar() {
        fh16.lowerTrailer(true);
        Volvo240 bil1 = new Volvo240(Color.green, 180.0);
        Volvo240 bil2 = new Volvo240(Color.green, 180.0);
        Volvo240 bil3 = new Volvo240(Color.green, 180.0);
        fh16.loadCar(bil1);

    }

    @Test
    public void unloadCar() {
    }
}