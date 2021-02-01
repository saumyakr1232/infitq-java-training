package com.gu;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Assignment24Test {

    @Test
    void isSidesOfTriangle() {
        assertTrue(Assignment24.isSidesOfTriangle(3, 4, 5));
        assertFalse(Assignment24.isSidesOfTriangle(1, 2, 5));
    }
    @Test
    void isSidesOfTriangle1() {
        assertTrue(Assignment24.isSidesOfTriangle(4, 5, 3));
        assertFalse(Assignment24.isSidesOfTriangle(1, 1, 0));
    }
    @Test
    void isSidesOfTriangle2() {
        assertTrue(Assignment24.isSidesOfTriangle(6, 6, 6));
        assertFalse(Assignment24.isSidesOfTriangle(3, 3, 8));
    }
}