import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.*;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;

class WorkshopTest {

    private Workshop workshop;

    @BeforeEach
    void setUp() {
        workshop = new Workshop<Volvo240>(2);

    }

    @Test
    void addCarToWorkshop() {
        Volvo240 car1 = new Volvo240(Color.BLACK, 128.0);
        Volvo240 car2 = new Volvo240(Color.BLUE, 150.0);
        workshop.addCarToWorkshop(car1);
        workshop.addCarToWorkshop(car2);
        assertTrue(workshop.getFacility().contains(car1));
        assertTrue(workshop.getFacility().contains(car2));
    }
}