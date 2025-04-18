/*
 * Vector.java
 */
package de.zirpel.jmathcollection.geometry;

/**
 * 
 * @author Maximilian Zirpel
 */
public interface Vector {
    
    /**
     * Returns dimension of vector.
     * 
     * @return dimension
     */
    int getDimension();
    
    /**
     * Returns coordinates of vector.
     * 
     * @return coordinates as array
     */
    double[] getCoordinates();
    
    /**
     * Sets coordinates of vector.
     * 
     * @param coordinates coordinates 
     */
    void setCoordinates(double[] coordinates);
}
