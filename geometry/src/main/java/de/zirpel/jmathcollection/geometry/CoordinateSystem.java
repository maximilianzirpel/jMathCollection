/*
 * CoordinateSystem.java
 */
package de.zirpel.jmathcollection.geometry;

/**
 * Provide calculations with vectors in real vectorspace.
 * 
 * @author Maximilian Zirpel
 * @param <V>
 */
public interface CoordinateSystem<V extends Vector> {
    
    double value(V vector);
    
    V directionVector(V vectorA, V vectorB);
    
    void directionVector(V vectorA, V vectorB, V resultVector);
    
    double distance(V vectorA, V vectorB);
    
    double scalarProduct(V vectorA, V vectorB);
    
    V scalarMultiplication(double scalar, V vector);
    
    void scalarMultiplication(double scalar, V vector, V resultVector);
    
    V addVectors(V vectorA, V vectorB);
    
    void addVectors(V vectorA, V vectorB, V resultVector);
}
