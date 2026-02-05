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

    /** Getter / Setter methods for Volvo */

    /** Get the number of doors a car has */
    public int getNrDoors(){return super.getNrDoors();}

    /** Get the model name of a car */
    public String getModelName(){return super.getModelName();}

    /** Check if the engine is on */
    protected boolean getEngineOn(){return engineOn;}

    /** Start the engine */
    protected void startEngine() {if (!this.engineOn) {this.engineOn = true;}}
    /** Stop the engine */
    protected void stopEngine() {if (this.engineOn) {this.engineOn = false;}}

    /** Accelerate by pressing the gas pedal the car */
    protected void gas(double amount) {
        if (amount >= 0 && amount <= 1) {
            if (truck.getCurrentSpeed() < truck.getEnginePower() && !trailerUp) {
                truck.incrementSpeed(amount);
                this.move();
            }
        } else {
            System.out.println("Can't push down pedal because it's already on the floor (Throttle is out of range.)");
        }
    }

    /** Decelerate by braking the car */
    public void brake(double amount){
        if (amount >= 0 && amount <= 1){
            if(truck.getCurrentSpeed() > 0){
                truck.decrementSpeed(amount);
                this.move();
            }
        }
        else {System.out.println("It's either through the floor or  (Brake is out of range.)");}
    }

    /** Lower the trailer */
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


    /** turbo get/set methods from saab, because the scania has a turbo */
    public boolean getTurboOn(){return turboOn;}

    public void setTurboOn(){turboOn = true;}

    public void setTurboOff(){turboOn = false;}

    @Override
    public void move(){}

    @Override
    public void turnLeft(){}

    @Override
    public void turnRight(){}
}
