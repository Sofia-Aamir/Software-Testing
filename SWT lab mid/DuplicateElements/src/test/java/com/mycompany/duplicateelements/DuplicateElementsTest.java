/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.duplicateelements;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Arrays;



/**
 *
 * @author IQRa Computers
 */
public class DuplicateElementsTest {
    
    public DuplicateElementsTest() {
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
    public void testNoDuplicates() {
        int[] array = {1,2,3,4,5,6,7,8};
        int newLength = DuplicateElements.removeDuplicates(array);
        assertArrayEquals(new int[]{1, 2, 3, 4, 5,6,7,8}, Arrays.copyOf(array, newLength));
    }

    @Test
    public void testAllDuplicates() {
        int[] array = {7,7,7,7,7};
        int newLength = DuplicateElements.removeDuplicates(array);
        assertArrayEquals(new int[]{7}, Arrays.copyOf(array, newLength));
    }

    @Test
    public void testSomeDuplicates() {
        int[] array = {1, 1, 2, 2, 3, 4, 4, 5};
        int newLength = DuplicateElements.removeDuplicates(array);
        assertArrayEquals(new int[]{1, 2, 3, 4, 5}, Arrays.copyOf(array, newLength));
    }

    @Test
    public void testNoElements() {
        int[] array = {};
        int newLength = DuplicateElements.removeDuplicates(array);
       assertArrayEquals(new int[]{}, Arrays.copyOf(array, newLength));

    }

    @Test
    public void testSingleElement() {
        int[] array = {7};
        int newLength = DuplicateElements.removeDuplicates(array);
        assertArrayEquals(new int[]{7}, Arrays.copyOf(array, newLength));
    }

    @Test
    public void testLargeNumbers() {
        int[] array = {100, 100, 200, 300, 300, 400};
        int newLength = DuplicateElements.removeDuplicates(array);
        assertArrayEquals(new int[]{100, 200, 300, 400}, Arrays.copyOf(array, newLength));
    }

    @Test
    public void testConsecutiveDuplicates() {
        int[] array = {2, 2, 2, 3, 4, 4, 5, 5, 6, 6, 6, 7};
        int newLength = DuplicateElements.removeDuplicates(array);
        assertArrayEquals(new int[]{2, 3, 4, 5, 6, 7}, Arrays.copyOf(array, newLength));
    }

    @Test
    public void testAlternatingDuplicates() {
        int[] array = {1, 2, 1, 2, 1, 2, 1, 2};
        int newLength = DuplicateElements.removeDuplicates(array);
        assertArrayEquals(new int[]{1, 2, 1, 2, 1, 2, 1, 2}, Arrays.copyOf(array, newLength)); // This is expected to fail
    }

    @Test
    public void testUnsortedArrayWithDuplicates() {
        int[] array = {4, 1, 2, 4, 3, 1};
        int newLength = DuplicateElements.removeDuplicates(array);
        assertArrayEquals(new int[]{4, 1, 2, 4, 3, 1}, Arrays.copyOf(array, newLength)); // This is expected to fail
    }

    @Test
    public void testMixedPositiveAndNegativeNumbers() {
        int[] array = {-3, -2, -2, -1, 0, 0, 1, 1, 2, 3};
        int newLength = DuplicateElements.removeDuplicates(array);
        assertArrayEquals(new int[]{-3, -2, -1, 0, 1, 2, 3}, Arrays.copyOf(array, newLength));
    }
}
