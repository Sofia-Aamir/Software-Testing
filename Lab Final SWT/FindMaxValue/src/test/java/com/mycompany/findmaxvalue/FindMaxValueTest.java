/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.findmaxvalue;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author
 */
public class FindMaxValueTest {
    
    public FindMaxValueTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

    @Test
    public void testArrayWithPositiveNumbers() {
        int[] array = {1, 2, 3, 4, 5};
        assertEquals(5, FindMaxValue.findMax(array));
    }

    @Test
    public void testArrayWithNegativeNumbers() {
        int[] array = {-5, -4, -3, -2, -1};
        assertEquals(-1, FindMaxValue.findMax(array));
    }

    @Test
    public void testArrayWithBothPositiveAndNegativeNumbers() {
        int[] array = {-10, -5, 0, 5, 10};
        assertEquals(10, FindMaxValue.findMax(array));
    }

    @Test
    public void testSingleElementArray() {
        int[] array = {42};
        assertEquals(42, FindMaxValue.findMax(array));
    }

    @Test
    public void testArrayWithDuplicateMaximumValues() {
        int[] array = {1, 3, 3, 2};
        assertEquals(3, FindMaxValue.findMax(array));
    }

//    @Test
//    public void testEmptyArray() {
//        int[] array = {};
//        assertThrows(IllegalArgumentException.class, () -> {
//            FindMaxValue.findMax(array);
//        });
//    }
//
//    @Test
//    public void testNullArray() {
//        int[] array = null;
//        assertThrows(IllegalArgumentException.class, () -> {
//            FindMaxValue.findMax(array);
//        });
//    }
}
