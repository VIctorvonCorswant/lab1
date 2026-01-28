import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

class Volvo240Test {

    private Volvo240 volvo;

    @BeforeEach
    public void setUp() {volvo = new Volvo240(Color.green,(double)100);}

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
        assertEquals(100, volvo.getEnginePower());
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
    public void throttleOutOfBounds() {
        volvo.engineOn = true;
        volvo.gas(1.5);
        assertEquals(0, volvo.getCurrentSpeed());

        volvo.gas(-0.5);
        assertEquals(0, volvo.getCurrentSpeed());
    }

    @Test
    public void brakeOutOfBounds() {
        volvo.engineOn = true;
        volvo.currentSpeed = 40;

        volvo.brake(1.5);
        assertEquals(40, volvo.getCurrentSpeed());
        volvo.brake(-0.5);
        assertEquals(40, volvo.getCurrentSpeed());
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

        volvo.turnRight();
        volvo.turnRight();
        volvo.turnRight();

        volvo.brake(1);
        assertEquals(2, volvo.coordinates.getX());
        assertEquals(2, volvo.coordinates.getY());
    }
}