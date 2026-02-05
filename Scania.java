import java.awt.*;

public class Scania extends Truck implements Movable{
    /** Initiate variables */
    Truck truck;
    protected double bedAngle;
    private boolean turboOn;

    /** Scania constructor */
    protected Scania() {super (Color.blue, 280.0, 2, "Scania");}

    public double getCurrentBedAngle() {return bedAngle;}

    /** Lower the bed */
    public void raiseBed(double amount){
        if((this.getCurrentBedAngle() + amount) <= 70 && truck.getCurrentSpeed() == 0 && amount > 0){
            bedAngle = getCurrentBedAngle() + amount;
        }
    }

    /** Lower the bed */
    public void lowerBed(double amount){
        if((this.getCurrentBedAngle() - amount) >= 0 && amount > 0){
            //We skip the moving-check, since it shouldn't occur,
            //and if we're moving want to lower the bed
            bedAngle = getCurrentBedAngle() - amount;
        }
    }

    /** turbo get/set methods from saab, because the scania has a turbo */
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
