package com.gu;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Assignment31Test {

    @Test
    void checkPalindrome() {
        assertTrue(Assignment31.checkPalindrome("Nan"));
    }
    @Test
    void checkPalindrome2() {
        assertFalse(Assignment31.checkPalindrome("zebra"));
    }
}