import java.awt.*;

public class Scania extends Truck implements Movable{
    /** Initiate variables */
    private double bedAngle = 0.0;
    private boolean turboOn;

    /** Scania constructor */
    protected Scania(Color color, double EnginePower, int nrDoors, String modelName) {
         super(color, EnginePower, nrDoors, modelName);
    }

    public double getBedAngle() {return bedAngle;}

    /** Lower the bed */
    public void raiseBed(double amount){
        if(this.getBedAngle() + amount >= 70){
            bedAngle = 70;
        }
        else if((this.getBedAngle() + amount) > 0 && super.getCurrentSpeed() == 0 && amount > 0){
            bedAngle = getBedAngle() + amount;
        }
    }

    /** Lower the bed */
    public void lowerBed(double amount){
        if(this.getBedAngle() - amount <= 0){
            //We skip the moving-check, since it shouldn't occur,
            //and if we're moving want to lower the bed
            bedAngle = 0;
        }
        else if((this.getBedAngle() - amount) >= 0 && amount > 0){
            bedAngle = getBedAngle() - amount;
        }
    }

    public void gas(double amount) {
        if (amount >= 0 && amount <= 1){
            if(this.getCurrentSpeed() < this.getEnginePower() && this.getBedAngle() == 0) {
                incrementSpeed(amount);
                this.move();
            }
        }
        else {System.out.println("Throttle out of range or bed is raised");}
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
