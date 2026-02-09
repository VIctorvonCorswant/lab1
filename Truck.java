import java.awt.*;

public abstract class Truck extends Car {

    public void incrementSpeed(double amount) {this.incrementSpeed(amount, this.engineOn);}

    public void decrementSpeed(double amount){this.decrementSpeed(amount, this.engineOn);}

    protected Truck(Color color, Double enginePower, int nrDoors, String modelName) {
        this.currentSpeed = 0;
        this.color = color;
        this.enginePower = enginePower;
        this.coordinates = new Point(0, 0);
        this.direction = 0;
        this.nrDoors = nrDoors;
        this.modelName = modelName;
        this.engineOn = false;
    }
}
