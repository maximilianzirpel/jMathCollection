/*
 * 
 */
package de.zirpel.jmathcollection.geometry.twoD;

import de.zirpel.jmathcollection.geometry.CoordinateSystem;

/**
 * Implementation of CoordinateSystem for two dimenions.
 * 
 * @author Maximilian Zirpel
 */
public class CoordinateSystem2D implements CoordinateSystem<Vector2D>{
    
    /**
     * Calculates angles between two vectors.
     * 
     * @param vectorA vector A
     * @param vectorB vector B
     * 
     * @return angle between A and B (returns NaN if either vector has value 0)
     */
    public double angle(Vector2D vectorA, Vector2D vectorB) {
        double angle = Double.NaN; 
        if (value(vectorA) != 0.0 && value(vectorB) != 0.0) {
            angle = Math.acos(scalarProduct(vectorA, vectorB)/(value(vectorA)*value(vectorB)));
        } 
        return angle;
    }

    @Override
    public double value(Vector2D vector) {
        return Math.sqrt(vector.getX()*vector.getX() + vector.getY()*vector.getY());
    }

    @Override
    public Vector2D directionVector(Vector2D vectorA, Vector2D vectorB) {
        return new Vector2D(vectorB.getX() - vectorA.getX(), vectorB.getY() - vectorA.getY());
    }

    @Override
    public void directionVector(Vector2D vectorA, Vector2D vectorB, Vector2D resultVector) {
        resultVector.setX(vectorB.getX() - vectorA.getX());
        resultVector.setY(vectorB.getY() - vectorA.getY());
    }

    @Override
    public double distance(Vector2D vectorA, Vector2D vectorB) {
        return Math.sqrt((vectorB.getX() - vectorA.getX())*(vectorB.getX() - vectorA.getX()) + (vectorB.getY() - vectorA.getY())*(vectorB.getY() - vectorA.getY()));
    }

    @Override
    public double scalarProduct(Vector2D vectorA, Vector2D vectorB) {
        return vectorA.getX()*vectorB.getX() + vectorA.getY()*vectorB.getY();
    }

    @Override
    public Vector2D scalarMultiplication(double scalar, Vector2D vector) {
        return new Vector2D(scalar*vector.getX(), scalar*vector.getY());
    }

    @Override
    public void scalarMultiplication(double scalar, Vector2D vector, Vector2D resultVector) {
        resultVector.setX(scalar*vector.getX());
        resultVector.setY(scalar*vector.getY());
    }

    @Override
    public Vector2D addVectors(Vector2D vectorA, Vector2D vectorB) {
        return new Vector2D(vectorA.getX()+vectorB.getX(), vectorA.getY()+vectorB.getY());
    }

    @Override
    public void addVectors(Vector2D vectorA, Vector2D vectorB, Vector2D resultVector) {
        resultVector.setX(vectorA.getX()+vectorB.getX());
        resultVector.setY(vectorA.getY()+vectorB.getY());
    }

    @Override
    public Vector2D rotate(double angle, Vector2D vector) {
        return new Vector2D(Math.cos(angle)*vector.getX() - Math.sin(angle)*vector.getY(), Math.sin(angle)*vector.getX() + Math.cos(angle)*vector.getY());
    }

    @Override
    public void rotate(double angle, Vector2D vector, Vector2D resultVector) {
        resultVector.setX(Math.cos(angle)*vector.getX() - Math.sin(angle)*vector.getY());
        resultVector.setY(Math.sin(angle)*vector.getX() + Math.cos(angle)*vector.getY());
    }
    
}
