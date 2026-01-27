import java.awt.*;

public abstract class Car extends Vehicle {
    public int nrDoors;
    public String modelName;
    public boolean engineOn = false;

    public int getNrDoors(){
        return nrDoors;
    }

    public void startEngine() {if (!this.engineOn) {this.engineOn = true;}}

    public void stopEngine() {if (this.engineOn) {this.engineOn = false;}}

    public void gas(double amount){
        if (amount > 0 && amount < 1){incrementSpeed(amount);}
        else {System.out.println("Can't push down pedal because it's already on the floor (Throttle is out of range.)");}
    }

    public void brake(double amount){
        if (amount > 0 && amount < 1){decrementSpeed(amount);}
        else {System.out.println("It's either through the floor or  (Brake is out of range.)");}
    }

    protected abstract double speedFactor();
}