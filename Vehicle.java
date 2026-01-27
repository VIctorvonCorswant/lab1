import java.awt.*;

public abstract class Vehicle {
    // hänvisar till Wikipedia för vad som räknas som fordon
    // https://sv.wikipedia.org/wiki/Fordon
    public double currentSpeed;
    public Color color;
    public double enginePower;
    public Point coordinates = new Point(0, 0);;
    public double direction = 0;

    public double getCurrentSpeed() {return currentSpeed;};
    public Color getColor() {return color;}

    public void setColor(Color clr){color = clr;}

    public double speedFactor(double enginePower) {return enginePower * 0.01;};

    public void incrementSpeed(double amount){currentSpeed = getCurrentSpeed() + (speedFactor(enginePower) * amount);}

    public void decrementSpeed(double amount){currentSpeed = getCurrentSpeed() - (speedFactor(enginePower) * amount);}
    public double getEnginePower(){return this.enginePower;}


    public void move(){
        // Set the new x and y position based on the direction and current speed
        coordinates.x += (int) (Math.cos(direction) * getCurrentSpeed());
        coordinates.y += (int) (Math.sin(direction) * getCurrentSpeed());
    }
    public void turnLeft(){
        // rotate the vehicle left via adding 30°
        direction = (direction + Math.toRadians(30)) % (2*Math.PI);
    }
    public void turnRight(){
        // rotate the vehicle right via subtracting 30°
        direction = (direction - Math.toRadians(30)) % (2*Math.PI);
    }
}
