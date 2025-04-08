/*
 * Vector2D.java
 */
package de.zirpel.jmathcollection.geometry.twoD;

import de.zirpel.jmathcollection.geometry.Vector;

/**
 *
 * @author Maximilian Zirpel
 */
public class Vector2D implements Vector {
    
    private static final int DIMENSION = 2;
    
    private double x;
    private double y;

    public Vector2D() {
        this.x = 0.0;
        this.y = 0.0;
    }

    public Vector2D(double x, double y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public int getDimension() {
        return DIMENSION;
    }

    @Override
    public double[] getCoordinates() {
        return new double[]{x, y};
    }

    @Override
    public void setCoordinates(double[] coordinates) {
        if (coordinates.length >= DIMENSION) {
            this.x = coordinates[0];
            this.y = coordinates[1];
        }
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 83 * hash + (int) (Double.doubleToLongBits(this.x) ^ (Double.doubleToLongBits(this.x) >>> 32));
        hash = 83 * hash + (int) (Double.doubleToLongBits(this.y) ^ (Double.doubleToLongBits(this.y) >>> 32));
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Vector2D other = (Vector2D) obj;
        if (Double.doubleToLongBits(this.x) != Double.doubleToLongBits(other.x)) {
            return false;
        }
        return Double.doubleToLongBits(this.y) == Double.doubleToLongBits(other.y);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Vector2D{");
        sb.append("x=").append(x);
        sb.append(", y=").append(y);
        sb.append('}');
        return sb.toString();
    }
}
