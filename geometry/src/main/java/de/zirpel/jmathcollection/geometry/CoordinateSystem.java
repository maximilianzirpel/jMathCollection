/*
 * CoordinateSystem.java
 */
package de.zirpel.jmathcollection.geometry;

/**
 * Provide calculations with vectors in real vectorspace.
 * 
 * @author Maximilian Zirpel
 * 
 * @param <V> 
 */
public interface CoordinateSystem<V extends Vector> {
    
    /**
     * Calculate absolute value of vector.
     * 
     * @param vector vector to calculate value for
     * 
     * @return value of vector 
     */
    double value(V vector);
    
    /**
     * Calculate direction vector from A to B.
     * 
     * @param vectorA vector A
     * @param vectorB vector B
     * 
     * @return direction vector from A to B 
     */
    V directionVector(V vectorA, V vectorB);
    
    /**
     * Calculates direction from A to B
     * 
     * @param vectorA vector A
     * @param vectorB vector B
     * @param resultVector vector object to store result
     */
    void directionVector(V vectorA, V vectorB, V resultVector);
    
    /**
     * Calculates distance from vector A to vector B.
     * 
     * @param vectorA vector A
     * @param vectorB vector B
     * 
     * @return distance from A to B
     */
    double distance(V vectorA, V vectorB);
    
    /**
     * Calculates scalar product of vector A and vector B.
     * 
     * @param vectorA vector A
     * @param vectorB vector B
     * 
     * @return scalar product of A and B
     */
    double scalarProduct(V vectorA, V vectorB);
    
    /**
     * Multiplicates vector with a scalar.
     * 
     * @param scalar scalar
     * @param vector vector
     * 
     * @return scaled vector 
     */
    V scalarMultiplication(double scalar, V vector);
    
    /**
     * Multiplicates vector with a scalar.
     * 
     * @param scalar scalar
     * @param vector vector
     * @param resultVector vector object to store result
     */
    void scalarMultiplication(double scalar, V vector, V resultVector);
    
    /**
     * Adds two vectors.
     * 
     * @param vectorA vector A
     * @param vectorB vector B
     * 
     * @return result of addition 
     */
    V addVectors(V vectorA, V vectorB);
    
    /**
     * Adds two vectors.
     * 
     * @param vectorA vector A
     * @param vectorB vector B
     * @param resultVector vector object to store result
     */
    void addVectors(V vectorA, V vectorB, V resultVector);
}
