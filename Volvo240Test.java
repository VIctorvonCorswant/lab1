import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestTemplate;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

class Volvo240Test {

    private Volvo240 volvo;

    @BeforeEach
    public void setUp() {
        volvo = new Volvo240(Color.green,(double)120);
    }

    @Test
    public void getNrDoors() {assertEquals(4, volvo.getNrDoors());}

    @Test
    public void getColor() {assertEquals(Color.green, volvo.getColor());}

    @Test
    public void setColor() {
        volvo.setColor(Color.BLUE);
        assertEquals(Color.BLUE, volvo.getColor());
    }

    @Test
    public void getEnginePower() {
        assertEquals(120, volvo.getEnginePower());
    }

    @Test
    public void getModelName() {
        assertEquals("Volvo240", volvo.getModelName());
    }

    @Test
    public void getEningeOn() {
        //test if engine can power on
        assertFalse(volvo.getEngineOn());
        volvo.engineOn = true;
        assertTrue(volvo.getEngineOn());

        volvo.engineOn = false;
        assertFalse(volvo.getEngineOn());
    }

    @Test
    public void moveVehicle() {
        volvo.engineOn = true;
        volvo.gas(1);
        assertEquals(1, volvo.coordinates.getX());
        assertEquals(0, volvo.coordinates.getY());

        volvo.turnLeft();
        volvo.turnLeft();
        volvo.turnLeft();
        volvo.gas(1);

        assertEquals(1, volvo.coordinates.getX());
        assertEquals(2, volvo.coordinates.getY());

    }
}