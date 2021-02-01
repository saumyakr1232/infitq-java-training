package com.gu;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Assignment29Test {

    @Test
    void profit1() {
        int result = Assignment29.profit(20, 50);
        assertEquals(3860, result);

    }
    @Test
    void profit2() {
        int result = Assignment29.profit(100, 2);
        assertEquals(-1, result);

    }
}
