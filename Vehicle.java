import java.awt.*;

public abstract class Vehicle {
    // hänvisar till Wikipedia för vad som räknas som fordon
    // https://sv.wikipedia.org/wiki/Fordon
    public double currentSpeed;
    public Color color;
    public double enginePower;

    public double getCurrentSpeed() {return currentSpeed;};
    public Color getColor() {return color;}

    public void setColor(Color clr){color = clr;}

    public double speedFactor(double enginePower) {return enginePower * 0.01;};

    public void incrementSpeed(double amount){currentSpeed = getCurrentSpeed() + (speedFactor(enginePower) * amount);}

    public void decrementSpeed(double amount){currentSpeed = getCurrentSpeed() - (speedFactor(enginePower) * amount);}
    public double getEnginePower(){return this.enginePower;}
}
