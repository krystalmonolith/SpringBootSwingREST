package com.alphapulsar.sb01.beans;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class CoordinateTest {
    @Test
    public void getX() throws Exception {
        Coordinate c = new Coordinate(1.0,2,3);
        assertTrue(c.getX() == 1.0);
    }

    @Test
    public void setX() throws Exception {
        Coordinate c = new Coordinate(1.0,2,3);
        c.setX(5.0);
        assertTrue(c.getX() == 5.0);
    }

    @Test
    public void getY() throws Exception {
        Coordinate c = new Coordinate(1.0,2,3);
        assertTrue(c.getY() == 2.0);
    }

    @Test
    public void setY() throws Exception {
        Coordinate c = new Coordinate(1.0,2,3);
        c.setY(6.0);
        assertTrue(c.getY() == 6.0);
    }

    @Test
    public void getZ() throws Exception {
        Coordinate c = new Coordinate(1.0,2,3);
        assertTrue(c.getZ() == 3.0);
    }

    @Test
    public void setZ() throws Exception {
        Coordinate c = new Coordinate(1.0,2,3);
        c.setZ(7.0);
        assertTrue(c.getZ() == 7.0);
    }
}