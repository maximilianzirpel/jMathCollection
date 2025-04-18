/*
 * Vector2D.java
 */
package de.zirpel.jmathcollection.geometry.twoD;

import de.zirpel.jmathcollection.geometry.Vector;

/**
 * Representing a vector in twodimension real vectorspace.
 * 
 * @author Maximilian Zirpel
 */
public class Vector2D implements Vector {
    
    /** Constant of vector dimension. */
    private static final int DIMENSION = 2;
    
    /** X-coordinate of vector. */
    private double x;
    /** Y-coordinate of vector. */
    private double y;

    /**
     * Create new instance of Vector2D.
     */
    public Vector2D() {
        this.x = 0.0;
        this.y = 0.0;
    }

    /**
     * Create new instance of Vector2D.
     * 
     * @param x x-coordinate
     * @param y y-coordinate
     */
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

    /**
     * Returns x coordinate.
     * 
     * @return x coordinate 
     */
    public double getX() {
        return x;
    }

    /**
     * Sets x coordinate.
     * 
     * @param x x coordinate 
     */
    public void setX(double x) {
        this.x = x;
    }

    /**
     * Returns y coordinate.
     * 
     * @return y coordinate 
     */
    public double getY() {
        return y;
    }

    /**
     * Sets y coordinate.
     * 
     * @param y y coordinate
     */
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
