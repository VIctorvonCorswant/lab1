import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

class VolvoFH16Test {

    private VolvoFH16 fh16;

    /** Sets up a VolvoFH16 */
    @BeforeEach
    public void setUp() {fh16 = new VolvoFH16(Color.GRAY, 300.0, 2, 3, "FH16");}

    /** Tests if trailer lowers */
    @Test
    public void lowerTrailer() {
        fh16.trailerSafe = true;
        fh16.lowerTrailer();
        assertFalse(fh16.trailerSafe);
    }

    /** Tests if trailer raises */
    @Test
    public void raiseTrailer() {
        fh16.trailerSafe = false;
        fh16.raiseTrailer();
        assertTrue(fh16.trailerSafe);
    }

    /** Tests if trailer loads more than max capacity */
    @Test
    public void loadMaxCapacityCar() {
        fh16.lowerTrailer();
        Volvo240 bil1 = new Volvo240(Color.green, 180.0);
        Volvo240 bil2 = new Volvo240(Color.yellow, 180.0);
        Volvo240 bil3 = new Volvo240(Color.blue, 180.0);
        Volvo240 bil4 = new Volvo240(Color.pink, 180.0);
        fh16.loadCar(bil1);
        fh16.loadCar(bil2);
        fh16.loadCar(bil3);
        fh16.loadCar(bil4);

        assertEquals(fh16.trailerSize, fh16.trailer.size());
    }

    /** Tests both if cars can only be loaded when trailer is down
     *  and if trucks can not be loaded */
    @Test
    public void loadCarOnlyWhenTrailerDown(){

        Volvo240 bil1 = new Volvo240(Color.green, 180.0);
        Volvo240 bil2 = new Volvo240(Color.yellow, 180.0);
        VolvoFH16 lastbil = new VolvoFH16(Color.blue, 300.0, 2, 1, "lastbil");
        fh16.loadCar(bil1);
        fh16.lowerTrailer();
        fh16.loadCar(bil2);
        fh16.loadCar(lastbil);

        assertEquals(1, fh16.trailer.size());
    }

    /** Tests if it is the loaded car that gets unloaded */
    @Test
    public void unloadLastCar() {
        Volvo240 bil1 = new Volvo240(Color.green, 180.0);
        Volvo240 bil2 = new Volvo240(Color.yellow, 180.0);
        fh16.lowerTrailer();
        fh16.loadCar(bil1);
        fh16.loadCar(bil2);
        fh16.raiseTrailer();
        fh16.unloadCar();
        fh16.lowerTrailer();
        fh16.unloadCar();

        assertEquals(1, fh16.trailer.size()); //fel, ska kolla om specifikt bil1 är kvar
    }

    /** Tests if you can gas when trailer is not safe (e.g trailer is lowered) */
    @Test
    public void gasNotWhenTrailerUnsafe(){
        fh16.trailerSafe = false;
        fh16.lowerTrailer();
        fh16.gas(1);

        assertEquals(0, fh16.getCurrentSpeed());
    }
}