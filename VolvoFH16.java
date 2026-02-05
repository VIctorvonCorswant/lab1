import java.awt.*;

public class VolvoFH16{

    /** Initiate variables */
    Truck truck;
    private boolean turboOn;


    /** Initialize the constructor */
    public VolvoFH16(){
        truck = new Truck(Color.BLACK, 300.0, 4, "Volvo FH16");
        truck.nrDoors = 2;
    }

    public get_color(){
        truck.getNrDoors();
    }
}
