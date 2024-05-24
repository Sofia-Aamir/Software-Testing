package com.mycompany.duplicateelements;

import java.util.Arrays;

public class DuplicateElements {
    public static void main(String[] args) {
        int[] array = {1, 1, 2, 2, 3, 4, 4, 5};
        int newLength = removeDuplicates(array);
        System.out.println("Array after removing duplicates: " + 
            Arrays.toString(Arrays.copyOf(array, newLength)));
    }

    public static int removeDuplicates(int[] array) {
        if (array.length == 0) return 0;
        int j = 0;
        for (int i = 1; i < array.length; i++) {
            if (array[i] != array[j]) {
                j++;
                array[j] = array[i];
            }
        }
        return j + 1;
    }
}
