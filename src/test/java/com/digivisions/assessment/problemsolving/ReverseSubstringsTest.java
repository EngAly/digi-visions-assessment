package com.digivisions.assessment.problemsolving;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ReverseSubstringsTest {

    ReverseSubstrings reverseSubstrings = new ReverseSubstrings();

    @Test
    @Order(1)
    void doReverseSubstrings() {
        String expectedString = "abd(bnj)asdf";
        String reverseString = reverseSubstrings.doReverseSubstrings("abd(jnb)asdf");
        assertEquals(expectedString, reverseString);
    }

    @Test
    @Order(2)
    void doReverseSubstrings1() {
        String expectedString = "abdjnbasdf";
        String reverseString = reverseSubstrings.doReverseSubstrings("abdjnbasdf");
        assertEquals(expectedString, reverseString);
    }

    @Test
    @Order(3)
    void doReverseSubstrings2() {
        String expectedString = "dd(fd)a(hhhg)";
        String reverseString = reverseSubstrings.doReverseSubstrings("dd(df)a(ghhh)");
        assertEquals(expectedString, reverseString);
    }
}