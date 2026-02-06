import java.awt.*;
import java.util.List;
import java.util.ArrayList;

public class VolvoFH16 extends Truck implements Movable {

    /** Initiate variables */
    Truck truck;
    protected boolean trailerUp = true;
    private boolean turboOn;
    List<Car> trailer = new ArrayList<>();
    private int trailerSize = 3;
    public boolean engineOn = false;

    /** Initialize the constructor */
    public VolvoFH16(Color color, double EnginePower, int nrDoors, int trailerSize, String modelName) {
        super(color, EnginePower, nrDoors, modelName);
        this.trailerSize = trailerSize;
    }

    /** Raise the trailer */
    public boolean raiseTrailer(boolean raise){
        if(!trailerUp && getCurrentSpeed() == 0 && raise){
            trailerUp = true;
            return true;
        }
        return false;
    }

    /** Lower the trailer */
    public boolean lowerTrailer(boolean lower) {
        if (trailerUp && getCurrentSpeed() == 0 && lower) {
            trailerUp = false;
            return true;
        }
        return false;
    }

    /** Load car to trailer */
    public boolean loadCar(Car car){
        if(trailer.size() < trailerSize && getCurrentSpeed() == 0 && !trailerUp){
            trailer.add(car);
            return true;
        }
        return false;
    }

     /** Unload car from trailer */
    public Car unloadCar(){
        if(!trailer.isEmpty() && getCurrentSpeed() == 0 && !trailerUp){
            return trailer.remove(trailer.size() - 1);
            //return trailer.removeLast();
        }
        return null;
    }

    /** turbo from saab, because the VolvoFH16 has a turbo */
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
