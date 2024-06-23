package org.Uber.Taxi;

public class Taxi implements Cloneable {

    private int id;
    private Character pickupPoint;
    private Character dropPoint;
    private float earnings;
    private int pickupTime;
    private int dropTime;
    private Character currentPosition = 'A';

    public Taxi(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public Character getPickupPoint() {
        return pickupPoint;
    }

    public void setPickupPoint(Character pickupPoint) {
        this.pickupPoint = pickupPoint;
    }

    public Character getDropPoint() {
        return dropPoint;
    }

    public void setDropPoint(Character dropPoint) {
        this.dropPoint = dropPoint;
    }

    public float getEarnings() {
        return earnings;
    }

    public void setEarnings(float earnings) {
        this.earnings = earnings;
    }

    public int getPickupTime() {
        return pickupTime;
    }

    public void setPickupTime(int pickupTime) {
        this.pickupTime = pickupTime;
    }

    public int getDropTime() {
        return dropTime;
    }

    public void setDropTime(int dropTime) {
        this.dropTime = dropTime;
    }

    public Character getCurrentPosition() {
        return currentPosition;
    }

    public void setCurrentPosition(Character currentPosition) {
        this.currentPosition = currentPosition;
    }

    @Override
    public Taxi clone() {
        try {
            Taxi clone = (Taxi) super.clone();
            // TODO: copy mutable state here, so the clone can't change the internals of the original
            return clone;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }

    @Override
    public String toString() {

        return this.id + " " + this.pickupPoint + " " + this.dropPoint + " " + this.pickupTime + " " + this.dropTime + " " + "$" + this.earnings;
    }
}
