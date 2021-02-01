package com.gu;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Assignment22Test {

    @Test
    void next15LeapYears() {
        int[] result = Assignment22.next15LeapYears(2002);
        int[] expected = new int[]{2004, 2008, 2012, 2016, 2020, 2024, 2028, 2032, 2036, 2040, 2044, 2048, 2052, 2056, 2060};
        //assert statements
        assertArrayEquals(expected, result);
    }
}