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
}