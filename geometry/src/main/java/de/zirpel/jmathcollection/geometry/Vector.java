/*
 * Vector.java
 */
package de.zirpel.jmathcollection.geometry;

/**
 * 
 * @author Maximilian Zirpel
 */
public interface Vector {
    
    int getDimension();
    
    double[] getCoordinates();
    
    void setCoordinates(double[] coordinates);
}
