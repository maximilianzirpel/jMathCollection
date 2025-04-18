/*
 * CoordinateSystem2DTest.java
 */
package de.zirpel.jmathcollection.geometry.twoD;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

/**
 * Test usage of CoordinateSystem2D.
 * 
 * @author Maximilian Zirpel
 */
public class CoordinateSystem2DTest {
    
    private static Logger LOG;
    
    private static final double D_DELTA = Math.pow(10.0, -7);
    
    @BeforeAll
    public static void setup() {
        LOG = LogManager.getLogger(CoordinateSystem2DTest.class);
    }

    /**
     * Test of angle method, of class CoordinateSystem2D.
     */
    @Test
    public void testAngle() {
        LOG.info(String.format("Test calculate angle between two vectors"));
        Vector2D vectorA = new Vector2D(0, 0);
        Vector2D vectorB = new Vector2D(0, 0);
        CoordinateSystem2D cs = new CoordinateSystem2D();
        double expResult = Double.NaN;
        double result = cs.angle(vectorA, vectorB);
        assertEquals(expResult, result, D_DELTA);
        
        vectorA = new Vector2D(1.0, 0.0);
        result = cs.angle(vectorA, vectorB);
        assertEquals(expResult, result, D_DELTA);
        
        vectorA = new Vector2D(0, 0);
        vectorB = new Vector2D(1, 0);
        result = cs.angle(vectorA, vectorB);
        assertEquals(expResult, result, D_DELTA);
        
        vectorA = new Vector2D(0.5, 0.5);
        result = cs.angle(vectorA, vectorB);
        expResult = Math.PI/4.0;
        assertEquals(expResult, result, D_DELTA);
        
        result = cs.angle(vectorA, vectorA);
        expResult = 0.0;
        assertEquals(expResult, result, D_DELTA);
        
        vectorA = new Vector2D(0, -1);
        result = cs.angle(vectorA, vectorB);
        expResult = Math.PI/2.0;
        assertEquals(expResult, result, D_DELTA);
    }

    /**
     * Test of value method, of class CoordinateSystem2D.
     */
    @Test
    public void testValue() {
        LOG.info(String.format("Test calculating value of a vector"));
        Vector2D vector = new Vector2D();
        CoordinateSystem2D cs = new CoordinateSystem2D();
        double expResult = 0.0;
        double result = cs.value(vector);
        assertEquals(expResult, result, D_DELTA);
        
        vector.setX(42.0);
        result = cs.value(vector);
        expResult = 42.0;
        assertEquals(expResult, result, D_DELTA);
        
        vector.setX(-42.0);
        result = cs.value(vector);
        expResult = 42.0;
        assertEquals(expResult, result, D_DELTA);
        
        vector.setX(0.0);
        vector.setY(42.0);
        result = cs.value(vector);
        expResult = 42.0;
        assertEquals(expResult, result, D_DELTA);
        
        vector.setY(-42.0);
        result = cs.value(vector);
        expResult = 42.0;
        assertEquals(expResult, result, D_DELTA);
        
        vector.setX(3);
        vector.setY(4);
        result = cs.value(vector);
        expResult = 5.0;
        assertEquals(expResult, result, D_DELTA);
        
        vector.setX(-3);
        vector.setY(4);
        result = cs.value(vector);
        expResult = 5.0;
        assertEquals(expResult, result, D_DELTA);
        
        vector.setX(3);
        vector.setY(-4);
        result = cs.value(vector);
        expResult = 5.0;
        assertEquals(expResult, result, D_DELTA);
        
        vector.setX(-3);
        vector.setY(-4);
        result = cs.value(vector);
        expResult = 5.0;
        assertEquals(expResult, result, D_DELTA);
    }

    /**
     * Test of directionVector method, of class CoordinateSystem2D.
     */
    @Test
    public void testDirectionVector_Vector2D_Vector2D() {
        LOG.info(String.format("Test calculating direction vector"));
        Vector2D vectorA = new Vector2D(2, 0);
        Vector2D vectorB = new Vector2D(0, 5);
        CoordinateSystem2D cs = new CoordinateSystem2D();
        Vector2D expResult = new Vector2D(-2, 5);
        Vector2D result = cs.directionVector(vectorA, vectorB);
        assertEquals(expResult.getX(), result.getX(), D_DELTA);
        assertEquals(expResult.getY(), result.getY(), D_DELTA);
    }

    /**
     * Test of directionVector method, of class CoordinateSystem2D.
     */
    @Test
    public void testDirectionVector_3args() {
        LOG.info(String.format("Test calculating direction vector"));
        Vector2D vectorA = new Vector2D(2, 0);
        Vector2D vectorB = new Vector2D(0, 5);
        Vector2D resultVector = new Vector2D();
        CoordinateSystem2D instance = new CoordinateSystem2D();
        instance.directionVector(vectorA, vectorB, resultVector);
        
        double expectedX = -2;
        double expectedY = 5;
        
        assertEquals(expectedX, resultVector.getX(), D_DELTA);
        assertEquals(expectedY, resultVector.getY(), D_DELTA);
    }

    /**
     * Test of distance method, of class CoordinateSystem2D.
     */
    @Test
    public void testDistance() {
        LOG.info(String.format("Test calculating distance between vectors"));
        Vector2D vectorA = new Vector2D(1, 0);
        Vector2D vectorB = new Vector2D(0, 1);
        CoordinateSystem2D cs = new CoordinateSystem2D();
        double expResult = Math.sqrt(2);
        double result = cs.distance(vectorA, vectorB);
        assertEquals(expResult, result, D_DELTA);
        
    }

    /**
     * Test of scalarProduct method, of class CoordinateSystem2D.
     */
    @Test
    public void testScalarProduct() {
        LOG.info(String.format("Test calculating scalar product"));
        Vector2D vectorA = new Vector2D(2, 3);
        Vector2D vectorB = new Vector2D(3, -2);
        CoordinateSystem2D cs = new CoordinateSystem2D();
        double expResult = 0.0;
        double result = cs.scalarProduct(vectorA, vectorB);
        assertEquals(expResult, result, D_DELTA);
        
        vectorA = new Vector2D(2, 0.5);
        vectorB = new Vector2D(3, 1.5);
        result = cs.scalarProduct(vectorA, vectorB);
        expResult = 6.75;
        assertEquals(expResult, result, D_DELTA);
    }

    /**
     * Test of scalarMultiplication method, of class CoordinateSystem2D.
     */
    @Test
    public void testScalarMultiplication_double_Vector2D() {
        LOG.info(String.format("Test scalar multiplication of a vector"));
        double scalar = 4.2;
        Vector2D vector = new Vector2D(1, 0.5);
        CoordinateSystem2D cs = new CoordinateSystem2D();
        Vector2D expResult = new Vector2D(4.2, 2.1);
        Vector2D result = cs.scalarMultiplication(scalar, vector);
        assertEquals(expResult.getX(), result.getX(), D_DELTA);
        assertEquals(expResult.getY(), result.getY(), D_DELTA);
    }

    /**
     * Test of scalarMultiplication method, of class CoordinateSystem2D.
     */
    @Test
    public void testScalarMultiplication_3args() {
        LOG.info(String.format("Test scalar multiplication of a vector"));
        double scalar = 4.2;
        Vector2D vector = new Vector2D(1, 0.5);
        Vector2D resultVector = new Vector2D();
        CoordinateSystem2D cs = new CoordinateSystem2D();
        cs.scalarMultiplication(scalar, vector, resultVector);
        
        double expectedX = 4.2;
        double expectedY = 2.1;
        
        assertEquals(expectedX, resultVector.getX(), D_DELTA);
        assertEquals(expectedY, resultVector.getY(), D_DELTA);
    }

    /**
     * Test of addVectors method, of class CoordinateSystem2D.
     */
    @Test
    public void testAddVectors_Vector2D_Vector2D() {
        LOG.info(String.format("Test adding vectors"));
        Vector2D vectorA = new Vector2D(2, 2.5);
        Vector2D vectorB = new Vector2D(3, -0.5);
        CoordinateSystem2D cs = new CoordinateSystem2D();
        Vector2D expResult = new Vector2D(5, 2);
        Vector2D result = cs.addVectors(vectorA, vectorB);
        assertEquals(expResult.getX(), result.getX(), D_DELTA);
        assertEquals(expResult.getY(), result.getY(), D_DELTA);
    }

    /**
     * Test of addVectors method, of class CoordinateSystem2D.
     */
    @Test
    public void testAddVectors_3args() {
        LOG.info(String.format("Test adding vectors"));
        Vector2D vectorA = new Vector2D(2, 2.5);
        Vector2D vectorB = new Vector2D(3, -0.5);
        Vector2D resultVector = new Vector2D();
        CoordinateSystem2D cs = new CoordinateSystem2D();
        cs.addVectors(vectorA, vectorB, resultVector);
        
        double expectedX = 5;
        double expectedY = 2;
        
        assertEquals(expectedX, resultVector.getX(), D_DELTA);
        assertEquals(expectedY, resultVector.getY(), D_DELTA);
    }
    
    @Test
    public void testRotate_double_Vector2D() {
        LOG.info(String.format("Test rotating vector"));
        Vector2D vector = new Vector2D(1, 0);
        double angle = Math.PI/2.0;
        CoordinateSystem2D cs = new CoordinateSystem2D();
        Vector2D expResult = new Vector2D(0, 1);
        Vector2D result = cs.rotate(angle, vector);
        assertEquals(expResult.getX(), result.getX(), D_DELTA);
        assertEquals(expResult.getY(), result.getY(), D_DELTA);
        
        result = cs.rotate(-angle, vector);
        expResult.setY(-1);
        assertEquals(expResult.getX(), result.getX(), D_DELTA);
        assertEquals(expResult.getY(), result.getY(), D_DELTA);
    }
    
    @Test
    public void testRotate_3args() {
        LOG.info(String.format("Test rotating vector"));
        Vector2D vector = new Vector2D(1, 0);
        double angle = Math.PI/2.0;
        Vector2D resultVector = new Vector2D();
        CoordinateSystem2D cs = new CoordinateSystem2D();
        cs.rotate(angle, vector, resultVector);
        
        double expectedX = 0;
        double expectedY = 1;
        
        assertEquals(expectedX, resultVector.getX(), D_DELTA);
        assertEquals(expectedY, resultVector.getY(), D_DELTA);
        
        cs.rotate(-angle, vector, resultVector);
        
        expectedY = -1;
        
        assertEquals(expectedX, resultVector.getX(), D_DELTA);
        assertEquals(expectedY, resultVector.getY(), D_DELTA);
    }
    
}
