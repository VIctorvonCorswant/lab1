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
            if (car instanceof Truck) return false; // Prevent loading trucks onto the trailer
            if (this.getGeoDistance(car, this) > 5) return false; // Prevent loading cars that are too far away
            trailer.add(car);
            return true;
        }
        return false;
    }

     /** Unload car from trailer */
    public Car unloadCar(){
        if(!trailer.isEmpty() && getCurrentSpeed() == 0 && !trailerUp){
            Car car = trailer.remove(trailer.size() - 1);
            // Unload the car behind the truck, based on the current direction of the truck
            car.direction = (this.direction + Math.toRadians(180)) %  (2*Math.PI);
            car.forceMove(5);
            //car.coordinates = new Point(this.coordinates.x, this.coordinates.y);
            return car;
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

    @Override
    public void move(){
        if(trailerUp) {
            super.move();
            // Move all cars on the trailer with the truck
            for (Car car : trailer) {
                car.coordinates = new Point(this.coordinates.x, this.coordinates.y);
            }
        }
    }

    public void turnLeft(){
        if(trailerUp) {
            super.turnLeft();
            // Turn all cars on the trailer with the truck
            for (Car car : trailer) {
                car.direction = this.direction;
            }
        }
    }

    public void turnRight(){
        if(trailerUp) {
            super.turnRight();
            // Turn all cars on the trailer with the truck
            for (Car car : trailer) {
                car.direction = this.direction;
            }
        }
    }
}
