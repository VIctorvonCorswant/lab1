import java.awt.*;

public class VolvoFH16 extends Truck implements Movable {

    /** Initiate variables */
    Truck truck;
    protected boolean trailerUp = true;
    private boolean turboOn;
    public boolean engineOn = false;

    /** Initialize the constructor */
    public VolvoFH16(){
        super(Color.BLACK, 300.0, 2, "Volvo FH16");
    }

    /** Raise the trailer */
    private boolean raiseTrailer(boolean raise){
        if(!trailerUp && truck.getCurrentSpeed() == 0 && raise){
            trailerUp = true;
            return true;
        }
        return false;
    }

    /** Lower the trailer */
    private boolean lowerTrailer(boolean lower) {
        if (trailerUp && truck.getCurrentSpeed() == 0 && lower) {
            trailerUp = false;
            return true;
        }
        return false;
    }

    /** turbo get/set methods from saab, because the VolvoFH16 has a turbo */
    public boolean getTurboOn(){return turboOn;}

    public void setTurboOn(){turboOn = true;}

    public void setTurboOff(){turboOn = false;}

    @Override
    protected double speedFactor(){
        double turbo = 1;
        if(turboOn) turbo = 1.3;
        return enginePower * 0.01 * turbo;
    }
}
