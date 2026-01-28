import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

class Volvo240Test {

    private Volvo240 volvo;

    /**
     * Sets up a normal Volvo 240
     */
    @BeforeEach
    public void setUp() {volvo = new Volvo240(Color.green,(double)100);}

    /**
     * Checks if the car has correct number of doors
     */
    @Test
    public void getNrDoors() {assertEquals(4, volvo.getNrDoors());}

    /**
     * Checks if color is correct
     */
    @Test
    public void getColor() {assertEquals(Color.green, volvo.getColor());}

    /**
     * Checks if you can change color is correct
     */
    @Test
    public void setColor() {
        volvo.setColor(Color.BLUE);
        assertEquals(Color.BLUE, volvo.getColor());
    }
    /**
     * Checks if engine power is correct
     */
    @Test
    public void getEnginePower() {
        assertEquals(100, volvo.getEnginePower());
    }

    /**
     * Checks if model name is correct
     */
    @Test
    public void getModelName() {
        assertEquals("Volvo240", volvo.getModelName());
    }

    /**
     * Checks if car actually starts
     */
    @Test
    public void getEningeOn() {
        //test if engine can power on
        assertFalse(volvo.getEngineOn());
        volvo.engineOn = true;
        assertTrue(volvo.getEngineOn());

        volvo.engineOn = false;
        assertFalse(volvo.getEngineOn());
    }

    /**
     * Checks if the gas pedal goes out of bounds
     */
    @Test
    public void throttleOutOfBounds() {
        volvo.engineOn = true;
        volvo.gas(1.5);
        assertEquals(0, volvo.getCurrentSpeed());

        volvo.gas(-0.5);
        assertEquals(0, volvo.getCurrentSpeed());
    }

    /**
     * Checks if the brake pedal goes out of bounds
     */
    @Test
    public void brakeOutOfBounds() {
        volvo.engineOn = true;
        volvo.currentSpeed = 40;

        volvo.brake(1.5);
        assertEquals(40, volvo.getCurrentSpeed());
        volvo.brake(-0.5);
        assertEquals(40, volvo.getCurrentSpeed());
    }

    /**
     * Checks if vehicle moves
     */
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

        /**
         * Accelerates and decelerates to check if
         * speed gets out of intended range
         */
    @Test
    public void carSpeedOutOfRange() {
        volvo.engineOn = true;

        for(int i=0; i<300; i++) {volvo.gas(1);}
        assertEquals(volvo.getEnginePower(), volvo.getCurrentSpeed());

        for(int i=0; i<300; i++) {volvo.brake(1);}
        assertEquals(0, volvo.getCurrentSpeed());
    }
}