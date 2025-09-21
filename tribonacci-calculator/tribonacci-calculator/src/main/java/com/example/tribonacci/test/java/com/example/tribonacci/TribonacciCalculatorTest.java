package com.example.tribonacci; // CORRECT PACKAGE for your structure

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

public class TribonacciCalculatorTest { // Should be public

    @Test
    public void testBaseCases() {
        assertEquals(0L, TribonacciCalculator.tribonacci(0));
        assertEquals(1L, TribonacciCalculator.tribonacci(1));
        assertEquals(1L, TribonacciCalculator.tribonacci(2));
    }

    @Test
    public void testRecursiveCases() {
        assertEquals(2L, TribonacciCalculator.tribonacci(3));
        assertEquals(4L, TribonacciCalculator.tribonacci(4));
        assertEquals(7L, TribonacciCalculator.tribonacci(5));
    }

    @Test
    public void testLargerValue() {
        assertEquals(149L, TribonacciCalculator.tribonacci(10));
    }

    @Test
    public void testGenerateSequence() {
        List<Long> firstFive = TribonacciCalculator.generateSequence(5);
        assertEquals(List.of(0L, 1L, 1L, 2L, 4L), firstFive);
        assertTrue(TribonacciCalculator.generateSequence(0).isEmpty());
    }

    @Test
    public void testNegativeInputThrows() {
        Exception ex = assertThrows(IllegalArgumentException.class, () -> {
            TribonacciCalculator.tribonacci(-1);
        });
        assertEquals("Position can't be negative, sorry!", ex.getMessage());
    }

    @Test
    public void testGenerateSequenceNegativeInputThrows() {
        Exception ex = assertThrows(IllegalArgumentException.class, () -> {
            TribonacciCalculator.generateSequence(-5);
        });
        assertTrue(ex.getMessage().contains("Count must be positive"));
    }
}