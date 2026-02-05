import java.awt.*;

public class Truck {

    private Car car;

    public double getCurrentSpeed(){return car.getCurrentSpeed();}

    public double getEnginePower(){return car.getEnginePower();}

    public void incrementSpeed(double amount) {car.incrementSpeed(amount);}

    public void decrementSpeed(double amount){car.decrementSpeed(amount);}

    protected Truck(Color color, Double enginePower, int nrDoors, String modelName) {
        car = new Car();
        car.currentSpeed = 0;
        car.color = color;
        car.enginePower = enginePower;
        car.coordinates = new Point(0,0);
        car.direction = 0;
        car.nrDoors = nrDoors;
        car.modelName = modelName;
        car.engineOn = false;
    }

    protected int getNrDoors(){return car.getNrDoors();}

    protected Color getColor(){return car.getColor();}

    public String getModelName(){return car.getModelName();}
    }
}
