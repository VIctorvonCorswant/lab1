import java.awt.*;

/** Reference https://sv.wikipedia.org/wiki/Fordon for our defenition of vehicle */

public abstract class Vehicle {
    public double currentSpeed;
    public Color color;
    public double enginePower;
    public Point coordinates = new Point(0, 0);
    public double direction = 0;

    /** Get current speed */
    public double getCurrentSpeed() {return currentSpeed;}

    /** Get color */
    public Color getColor() {return color;}

    /** Set a new color for the vehicle */
    public void setColor(Color clr){color = clr;}

    /** Calculate the speed factor of the vehicle */
    public double speedFactor(double enginePower) {return enginePower * 0.01;}

    /** Increase the speed of the vehicle */
    protected void incrementSpeed(double amount){currentSpeed = getCurrentSpeed() + (speedFactor(enginePower) * amount);}

    /** Decrease the speed of the vehicle */
    protected void decrementSpeed(double amount){currentSpeed = getCurrentSpeed() - (speedFactor(enginePower) * amount);}

    /** Get engine power */
    public double getEnginePower(){return this.enginePower;}

    /** Set the new x and y position based on the direction and current speed */
    public void move(){
        coordinates.x += (int) (Math.cos(direction) * getCurrentSpeed());
        coordinates.y += (int) (Math.sin(direction) * getCurrentSpeed());
    }

    /** Rotate the vehicle left via adding 30° */
    public void turnLeft(){
        // rotate the vehicle left via adding 30°
        direction = (direction + Math.toRadians(30)) % (2*Math.PI);
    }

    /** Rotate the vehicle right via subtracting 30° */
    public void turnRight(){
        direction = (direction - Math.toRadians(30)) % (2*Math.PI);
    }
}
