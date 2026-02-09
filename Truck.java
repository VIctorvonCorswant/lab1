import java.awt.*;

public abstract class Truck extends Car {

    private final Car car;

    public double getCurrentSpeed(){return car.getCurrentSpeed();}

    public double getEnginePower(){return car.getEnginePower();}

    public void incrementSpeed(double amount) {car.incrementSpeed(amount);}

    public void decrementSpeed(double amount){car.decrementSpeed(amount);}

    protected Truck(Color color, Double enginePower, int nrDoors, String modelName) {
        super();
        car = new Car() {
            @Override
            protected double speedFactor() {
                return enginePower*0.01;
            }
        };
        car.currentSpeed = 0;
        car.color = color;
        car.enginePower = enginePower;
        car.coordinates = new Point(0,0);
        car.direction = 0;
        car.nrDoors = nrDoors;
        car.modelName = modelName;
        car.engineOn = false;
    }

    public String getModelName(){return super.getModelName();}
}
