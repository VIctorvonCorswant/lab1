import java.awt.*;

public class Scania implements Movable{
    /** Initiate variables */
    Truck truck;
    protected double bedAngle;
    private boolean turboOn;

    public int nrDoors;
    public String modelName;
    public boolean engineOn = false;

    /** Scania constructor */
    private Scania() {
        truck = new Truck(Color.blue, 280.0, 2, "Scania");

    }

    /** Get the number of doors a car has */
    public int getNrDoors(){
        return nrDoors;
    }

    /** Get the model name of a car */
    public String getModelName(){
        return modelName;
    }

    /** Check if the engine is on */
    protected boolean getEngineOn(){return engineOn;}

    private double getCurrentBedAngle() {return bedAngle;}

    /** Start the engine */
    protected void startEngine() {if (!this.engineOn) {this.engineOn = true;}}

    /** Stop the engine */
    protected void stopEngine() {if (this.engineOn) {this.engineOn = false;}}

    /** Accelerate by pressing the gas pedal the car */
    protected void gas(double amount){
        if (amount >= 0 && amount <= 1){
            if(truck.getCurrentSpeed() < truck.getEnginePower() && getCurrentBedAngle() == 0){
                truck.incrementSpeed(amount);
                this.move();
            }
        }
        else {System.out.println("Can't push down pedal because it's already on the floor (Throttle is out of range.)");}
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

    private double raiseBed(double amount){
        if((this.getCurrentBedAngle() + amount) <= 70 && truck.getCurrentSpeed() == 0 && amount > 0){
            bedAngle = getCurrentBedAngle() + amount;
        }
        return bedAngle;
    }

    /** RAHHHHHHHHHHHH */
    private double lowerBed(double amount){
        if((this.getCurrentBedAngle() - amount) >= 0 && amount > 0){
            //we skip the check if we're moving, since it shouldn't happen anyways.
            //and if we're moving we would like to lower the bed
            bedAngle = getCurrentBedAngle() - amount;
        }
        return bedAngle;
    }


    /** turbo get/set methods for saab */
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
